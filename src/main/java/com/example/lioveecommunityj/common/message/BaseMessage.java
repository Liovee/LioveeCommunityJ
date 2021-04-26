package com.example.lioveecommunityj.common.message;

/**
 * 异常分类编码，按需扩展分类
 */
public enum BaseMessage {

    SUCCESS(0, "请求成功"),
    NO_LOGIN(1001, "请登录"),
    SYSTEM_ERROR(1002, "系统错误"),
    PARAM_ERROR(1003, "请求参数错误"),
    BUSINESS_ERROR(1004, "业务错误"),
    NO_PERMISSION(1005, "没有权限");

    private int code;
    private String message;

    BaseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
