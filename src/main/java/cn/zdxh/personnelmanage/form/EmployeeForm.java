package cn.zdxh.personnelmanage.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 接收表单的员工信息，并且带有数据校验的功能
 *
 * @author Justin
 * @since 2019-03-15
 */
@ApiModel(description = "员工的表单接收对象")
public class EmployeeForm {

    /**
     * 自增主键
     */
    @ApiModelProperty(dataType = "integer",name = "empId",value = "员工id")
    private Integer empId;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(dataType = "string",name = "empName",value = "员工姓名",required = true)
    private String empName;
    /**
     * 性别：1为男，2为女
     */
    @NotNull(message = "性别不能为空")
    @ApiModelProperty(dataType = "integer",name = "empSex",value = "员工性别，1为男，2为女",required = true)
    private Integer empSex;
    /**
     * 民族
     */
    @NotBlank(message = "民族不能为空")
    @ApiModelProperty(dataType = "string",name = "empNation",value = "民族",required = true)
    private String empNation;
    /**
     * 工号
     */
    @NotBlank(message = "工号不能为空")
    @ApiModelProperty(dataType = "string",name = "empNumber",value = "工号",required = true)
    private String empNumber;
    /**
     * 生日，格式化接收参数
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "生日不能为空")
    @ApiModelProperty(dataType = "date",name = "empBirthday",value = "生日",required = true)
    private Date empBirthday;
    /**
     * 身份证
     */
    @NotBlank(message = "生日不能为空")
    @ApiModelProperty(dataType = "string",name = "empCard",value = "身份证",required = true)
    private String empCard;
    /**
     * 是否结婚 1为已婚 2为未婚
     */
    @NotNull(message = "是否结婚不能为空")
    @ApiModelProperty(dataType = "integer",name = "empMarry",value = "是否结婚 1为已婚 2为未婚",required = true)
    private Integer empMarry;
    /**
     * 部门
     */
    @NotBlank(message = "部门不能为空")
    @ApiModelProperty(dataType = "string",name = "empDepart",value = "部门",required = true)
    private String empDepart;
    /**
     * 个人照片
     */
    @ApiModelProperty(dataType = "string",name = "empPic",value = "个人照片")
    private String empPic;
    /**
     * 职位
     */
    @NotBlank(message = "职位不能为空")
    @ApiModelProperty(dataType = "string",name = "empPosition",value = "职位",required = true)
    private String empPosition;
    /**
     * 毕业院校
     */
    @NotBlank(message = "毕业院校不能为空")
    @ApiModelProperty(dataType = "string",name = "empSchool",value = "毕业院校",required = true)
    private String empSchool;
    /**
     * 联系电话
     */
    @Pattern(regexp="^1[34578]\\d{9}$",message="手机号码格式不正确")
    @NotBlank(message = "联系电话不能为空")
    @ApiModelProperty(dataType = "string",name = "empPhone",value = "联系电话",required = true)
    private String empPhone;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(dataType = "string",name = "empEmail",value = "邮箱",required = true)
    private String empEmail;
    /**
     * 居住地
     */
    @NotBlank(message = "居住地不能为空")
    @ApiModelProperty(dataType = "string",name = "empAddr",value = "居住地",required = true)
    private String empAddr;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public String getEmpNation() {
        return empNation;
    }

    public void setEmpNation(String empNation) {
        this.empNation = empNation;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard;
    }

    public Integer getEmpMarry() {
        return empMarry;
    }

    public void setEmpMarry(Integer empMarry) {
        this.empMarry = empMarry;
    }

    public String getEmpDepart() {
        return empDepart;
    }

    public void setEmpDepart(String empDepart) {
        this.empDepart = empDepart;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpSchool() {
        return empSchool;
    }

    public void setEmpSchool(String empSchool) {
        this.empSchool = empSchool;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    @Override
    public String toString() {
        return "EmployeeForm{" +
                ", empId=" + empId +
                ", empName=" + empName +
                ", empSex=" + empSex +
                ", empNation=" + empNation +
                ", empNumber=" + empNumber +
                ", empBirthday=" + empBirthday +
                ", empCard=" + empCard +
                ", empMarry=" + empMarry +
                ", empDepart=" + empDepart +
                ", empPic=" + empPic +
                ", empPosition=" + empPosition +
                ", empSchool=" + empSchool +
                ", empPhone=" + empPhone +
                ", empEmail=" + empEmail +
                ", empAddr=" + empAddr +
                "}";
    }
}
