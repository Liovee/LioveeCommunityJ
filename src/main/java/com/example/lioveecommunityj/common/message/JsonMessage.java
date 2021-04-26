package com.example.lioveecommunityj.common.message;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

import static com.example.lioveecommunityj.common.message.BaseMessage.*;

/**
 * Function: Please Descrip This Class.
 *
 * @author timothy
 * @date 2020-06-19.
 * Copyright (c) 2020,yuebaoling@g7.com.cn All Rights Reserved.
 */
@ApiModel("接口返回对象")
@Data
@AllArgsConstructor
public class JsonMessage<T> implements Serializable {
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "0:请求成功  1001:请登录  1002:系统错误  1003:请求参数错误  1004:业务错误  1005:没有权限")
    private int code;
    @ApiModelProperty(value = "数据(Json字符串)")
    private T data;

    public JsonMessage() {
    }

    public JsonMessage(String msg, int code) {
        this(msg, code, null);
    }

    public static <T> JsonMessage<T> success() {
        return JsonMessage.success(SUCCESS.getMessage());
    }

    public static <T> JsonMessage<T> success(T data) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return JsonMessage.success(data, SUCCESS.getMessage());
    }

    public static <T> JsonMessage<T> success(T data, String msg) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return new JsonMessage<T>(msg, SUCCESS.getCode(), data);
    }

    public static <T> JsonMessage<T> success(String msg) {
        return new JsonMessage<T>(msg, SUCCESS.getCode(), null);
    }

    public static <T> JsonMessage<T> needLogin() {
        return new JsonMessage<T>(NO_LOGIN.getMessage(), NO_LOGIN.getCode(), null);
    }

    public static <T> JsonMessage<T> needLogin(String msg) {
        return new JsonMessage<T>(msg, NO_LOGIN.getCode(), null);
    }

    public static <T> JsonMessage<T> systemError() {
        return JsonMessage.systemError(SYSTEM_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> systemError(T data) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return JsonMessage.systemError(data, SYSTEM_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> systemError(T data, String msg) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return new JsonMessage<T>(msg, SYSTEM_ERROR.getCode(), data);
    }

    public static <T> JsonMessage<T> systemError(String msg) {
        return new JsonMessage<T>(msg, SYSTEM_ERROR.getCode(), null);
    }


    public static <T> JsonMessage<T> paramError() {
        return JsonMessage.paramError(PARAM_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> paramError(T data) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return JsonMessage.paramError(data, PARAM_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> paramError(String msg) {
        return new JsonMessage<T>(msg, PARAM_ERROR.getCode(), null);
    }

    public static <T> JsonMessage<T> paramError(T data, String msg) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return new JsonMessage<T>(msg, PARAM_ERROR.getCode(), data);
    }


    public static <T> JsonMessage<T> bizError() {
        return JsonMessage.bizError(BUSINESS_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> bizError(T data) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return JsonMessage.bizError(data, BUSINESS_ERROR.getMessage());
    }

    public static <T> JsonMessage<T> bizError(T data, String msg) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return new JsonMessage<T>(msg, BUSINESS_ERROR.getCode(), data);
    }

    public static <T> JsonMessage<T> bizError(String msg) {
        return new JsonMessage<T>(msg, BUSINESS_ERROR.getCode(), null);
    }


    public static <T> JsonMessage<T> noPermission() {
        return JsonMessage.noPermission(null);
    }

    public static <T> JsonMessage<T> noPermission(T data) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return JsonMessage.noPermission(data, NO_PERMISSION.getMessage());
    }

    public static <T> JsonMessage<T> noPermission(T data, String msg) {
        if (null != data && data instanceof JsonMessage) {
            return (JsonMessage) data;
        }
        return new JsonMessage<T>(msg, NO_PERMISSION.getCode(), data);
    }

    public static <T> JsonMessage<T> noPermission(String msg) {
        return new JsonMessage<T>(msg, NO_PERMISSION.getCode(), null);
    }

}
