package com.watchme.common.exception;

/**
 * @author: wangqiang
 * @date: 2018/5/3 15:56
 * @description:
 */
public enum ExceptionEnum {
    //服务器代码发生异常
    UNKONW_ERROR(-1, "服务器代码发生异常,请联系管理员"),
    SUCCESS(0, "成功"),
    NULL_POINTER(1, "发生空指针异常"),
    ILLEGAL_ARGUMENT(2, "请求参数类型不匹配"),
    SQL(3, "数据库访问异常"),
    ACCOUNT_ERROR(4, "用户名或密码错误"),
    BUSINESS(5, "业务逻辑异常");
    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
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
