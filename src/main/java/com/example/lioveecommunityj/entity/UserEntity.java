package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_comment")
@ApiModel("用户")
public class UserEntity {
    @ApiModelProperty("电话号码")
    @TableField("phone_num")
    private String phoneNum;

    @ApiModelProperty("密码")
    @TableField("pass_word")
    private String passWord;
}