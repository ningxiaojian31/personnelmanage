package cn.zdxh.personnelmanage.controller;

import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.Admin;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.AdminService;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import cn.zdxh.personnelmanage.utils.ExcelTitlesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExcelValuesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExportExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 导出excel表的控制器
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeInfoService employeeInfoService;

    /**
     * 显示export页面
     * @return
     */
    @GetMapping("/show")
    public String showExcel(){
        return "/excel/export";
    }

    /**
     * 导出admin表
     * @param response
     */
    @GetMapping("/adms")
    public void exportAdm(HttpServletResponse response)  {
        //获取管理员数据
        List<Admin> allAdmins = adminService.findAllAdmins();
        //标题
        String[] adminTitles = ExcelTitlesHelperUtils.getAdminTitles();
        //将数据转换下格式，list转成二维数组，参数一是数据，参数二是标题条数
        String[][] adminValues = ExcelValuesHelperUtils.getAdminValues(allAdmins, adminTitles.length);
        //进行导出表
        try {
            ExportExcelUtils.createExcelUtils(adminValues,adminTitles,response);
        } catch (Exception e) {
            //导表发生异常的时候
            throw new MyException(ResultEnum.EXCEL_ERROR.getCode(),ResultEnum.EXCEL_ERROR.getMsg());
        }
    }

    /**
     * 导出EmployeeInfo表
     * @param response
     */
    @GetMapping("/emps")
    public void exportEmp(HttpServletResponse response) {
        //获取员工数据
        List<EmployeeInfo> allEmployees = employeeInfoService.findAllEmployees(0, 10000);
        //标题
        String[] employeeInfoTitles = ExcelTitlesHelperUtils.getEmployeeInfoTitles();
        //将数据转换下格式，list转成二维数组，参数一是数据，参数二是标题条数
        String[][] adminValues = ExcelValuesHelperUtils.getEmployeeInfoValues(allEmployees, employeeInfoTitles.length);
        //进行导出表
        try {
            ExportExcelUtils.createExcelUtils(adminValues,employeeInfoTitles,response);
        } catch (Exception e) {
            //导表发生异常的时候
          throw new MyException(ResultEnum.EXCEL_ERROR.getCode(),ResultEnum.EXCEL_ERROR.getMsg());
        }
    }
}
