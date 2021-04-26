package com.example.lioveecommunityj.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("用户登录")
@Data
public class UserVo {
    private String phoneNum;
    private String passWord;
}
