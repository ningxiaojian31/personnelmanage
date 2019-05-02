package cn.zdxh.personnelmanage.controller;


import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.form.EmployeeForm;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工信息表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */

@Controller
@RequestMapping("/employee")
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService employeeInfoService;



    /**
     * 查询所有的员工（默认0到10个）
     * @GetMapping 表示的是get请求
     * @ResponseBody 返回的是json的格式（分页时的ajax数据请求）
     * @param currentPage 当前页
     * @param limit 每页显示多少个
     * @return
     */
    @GetMapping("/emps")
    public String employees(@RequestParam(value = "currentPage",defaultValue = "0") String currentPage, @RequestParam(value = "limit",defaultValue = "2") String limit,Map<String,Object> map){
        //向数据库查询值
        List<EmployeeInfo> allEmployees = employeeInfoService.findAllEmployees(Integer.parseInt(currentPage), Integer.parseInt(limit));
        Integer allCount = employeeInfoService.findAllCount();
        //存储值，可以在引擎模板中取值（页面中取值）
        map.put("employees",allEmployees);
        map.put("totalPage",allCount);//总页数
        map.put("currentPage",currentPage);//当前页数-1
        //employee_list的意思就是employee_list.html页面，并在其中取值，相当于jsp页面
        return "employee/employee_list";
    }

    /**
     * 在修改之前需要进行一次数据回显，查询某个需要修改的员工
     * @GetMapping 表示的是get请求
     * @param id  员工id
     * @param map 存储值
     * @return
     */
    @GetMapping("/emp/{id}")
    public String employee(@PathVariable("id") Integer id,Map<String,Object> map){
        EmployeeInfo employee = employeeInfoService.findEmployee(id);
        map.put("employee",employee);
        return "employee/employee_update";
    }

    /**
     * 更新员工信息
     * @PutMapping 表示的是put请求方式
     * @param employeeForm 表单传过来的对象
     * @param bindingResult 表单验证对象
     * @return
     */
    @PutMapping("/emp/{id}")
    public String updateEmployee(@Validated EmployeeForm employeeForm, BindingResult bindingResult,@PathVariable("id") Integer id){
        //数据校验出现错误的时候，需要抛个异常，并且异常捕获到异常页面
        if (bindingResult.hasErrors()){
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //封装页面传过来的员工id
        employeeForm.setEmpId(id);
        EmployeeInfo employeeInfo = new EmployeeInfo();
        //对象属性转换
        BeanUtils.copyProperties(employeeForm,employeeInfo);
        employeeInfoService.updateEmployee(employeeInfo);
        return "result/success";
    }

    /**
     * 仅仅作页面跳转的作用（跳转到新增员工的页面）
     * @GetMapping get的请求方式
     * @return
     */
    @GetMapping("/emp")
    public String insertEmployeeBefore(){
        return "employee/employee_create";
    }

    /**
     * 新增员工信息
     * @PostMapping post方式提交
     * @param employeeForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/emp")
    public String insertEmployee(@Validated EmployeeForm employeeForm, BindingResult bindingResult){
        //数据校验出现错误的时候，需要抛个异常，并且异常捕获到异常页面
        if (bindingResult.hasErrors()){
            //错误码 ResultEnum.CHECK_ERROR.getCode()
            //数据校验的具体错误信息  bindingResult.getFieldError().getDefaultMessage()
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        EmployeeInfo employeeInfo = new EmployeeInfo();
        //对象属性转换
        BeanUtils.copyProperties(employeeForm,employeeInfo);
        employeeInfoService.insertEmployee(employeeInfo);
        return "result/success";
    }

    /**
     * 删除员工
     * @DeleteMapping delete请求
     * @param id 员工id
     * @return
     */
    @DeleteMapping("emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeInfoService.deleteEmployee(id);
        return "employee/employee_list";
    }

    /**
     * 根据员工姓名模糊查询员工
     * @param content
     * @return
     */
    @PostMapping("/search")
    public String searchEmployees(String content,Map<String,Object> map){
        //搜索框的内容不为空时才进行搜索
        if (!StringUtils.isEmpty(content)) {
            List<EmployeeInfo> employeeInfos = employeeInfoService.findAllEmployeeInfosBySearch(content);
            //存储值，可以在引擎模板中取值（页面中取值）
            map.put("employees",employeeInfos);
        }
        return "employee/employee_list";
    }

}

