package com.example.lioveecommunityj.common.util;

import org.springframework.util.StringUtils;

public class MyStringUtil extends StringUtils {
    public String isNull(Object obj){
        if (obj == null){
            return "为空";
        }
        return "不为空";
    }

    public static String intToString(Integer i){
        if (i == null){
            return "为空";
        }
        if (i == 0){
            return "失败";
        }
        return "成功";
    }
}
