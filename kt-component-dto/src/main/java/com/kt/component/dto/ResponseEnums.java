package com.kt.component.dto;

/*
 * @author JavisChen
 * @desc 响应常量管理
 * @date 2018/5/29 下午2:55
 */
public enum ResponseEnums {

    /**
     * 成功编码
     */
    OK("000000", "ok"),

    /**
     * A0001 ~ A0100是系统预留的用户端错误码
     */
    USER_ERROR("A0001", "用户端错误"),
    USER_METHOD_NOT_ALLOWED("A0002", "Request method not supported"),
    USER_METHOD_ARGUMENT_NOT_VALID("A0003", "用户参数不合法"),
    USER_REQUIRED_REQUEST_BODY_IS_MISSING("A0004", "Required request body is missing"),
    USER_NOT_LOGIN("A0005", "尚未登录"),
    USER_LOGIN_FAIL("A0006", "登录认证失败"),
    USER_ACCESS_DENIED("A0007", "权限不足"),


    SERVER_ERROR("B0001", "系统执行错误"),
    THIRD_PARTY_ERROR("C00001", "调用第三方服务出错");

    private String code;
    private String msg;

    ResponseEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
