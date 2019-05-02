package cn.zdxh.personnelmanage.utils;

/**
 * excel表的行名
 */
public class ExcelTitlesHelperUtils {
    /**
     * Admin
     * @return
     */
    public static String[] getAdminTitles(){
        String[] titles = {"ID","用户名","密码","管理员"};
        return titles;
    }

    /**
     * EmployeeInfo
     * @return
     */
    public static String[] getEmployeeInfoTitles(){
        String[] titles = {"ID","员工名","性别","民族","工号","生日","身份证","是否结婚","部门",
                "个人图片","职位","毕业院校","电话号码","Email","地址"};
        return titles;
    }



}
