package cn.zdxh.personnelmanage.utils;

import cn.zdxh.personnelmanage.po.Admin;
import cn.zdxh.personnelmanage.po.EmployeeInfo;

import java.util.List;

/**
 * excel表的值
 */
public class ExcelValuesHelperUtils {
    /**
     * Admin表
     * @param lists 数据库查出的总值
     * @param titlesSize excel表的行数
     * @return
     */
    public static String[][] getAdminValues(List<Admin> lists, int titlesSize){
        String[][] values=new String[lists.size()][titlesSize];
        for (int i = 0 ;i < lists.size() ;i++){
            Admin adm = lists.get(i);
            values[i][0]=String.valueOf(adm.getId());
            values[i][1]=adm.getUsername();
            values[i][2]=adm.getPassword();
            if (adm.getSign()==1){
                values[i][3]="系统管理员";
            }else {
                values[i][3]="人事管理员";
            }
        }
        return values;
    }

    /**
     * EmployeeInfo
     * @param lists
     * @param titlesSize
     * @return
     */
    public static String[][] getEmployeeInfoValues(List<EmployeeInfo> lists, int titlesSize) {
        String[][] values = new String[lists.size()][titlesSize];
        for (int i = 0; i < lists.size(); i++) {
            EmployeeInfo emp = lists.get(i);
            values[i][0] = String.valueOf(emp.getEmpId());
            values[i][1] = emp.getEmpName();
            if (emp.getEmpSex()==1){
                values[i][2]="男";
            }else {
                values[i][2]="女";
            }
            values[i][3] =emp.getEmpNation();
            values[i][4] = emp.getEmpNumber();
            values[i][5] = emp.getEmpBirthday().toString();
            values[i][6] = emp.getEmpCard();
            if (emp.getEmpMarry()==1){
                values[i][7]="已婚";
            }else {
                values[i][7]="未婚";
            }
            values[i][8] = emp.getEmpDepart();
            values[i][9] = emp.getEmpPic();
            values[i][10] = emp.getEmpPosition();
            values[i][11] = emp.getEmpSchool();
            values[i][12] = emp.getEmpPhone();
            values[i][13] = emp.getEmpEmail();
            values[i][14] = emp.getEmpSchool();
        }
        return values;
    }

    /**
     * 其他的excel表可以在此进行拓展。。。。。。。。。。
     */
}
