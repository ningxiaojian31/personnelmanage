package cn.zdxh.personnelmanage.enums;

/**
 * 统一错误管理
 * 给自定义异常使用
 * 需要根据业务场景来添加相应的枚举类型。。。。。。。可扩展
 */
public enum ResultEnum {

    CHECK_ERROR(10,"填写内容不正确"),
    EMP_NOT_EXIST(11,"此员工不存在"),
    INSERT_FAIL(12,"插入失败"),
    EXCEL_ERROR(13,"导表发生错误"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
