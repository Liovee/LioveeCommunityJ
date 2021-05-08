package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_comment")
@ApiModel("用户")
public class UserEntity implements Serializable {
    @ApiModelProperty("姓名")
    @TableId(type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty("姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("家庭住址")
    @TableField("home_address")
    private String homeAddress;

    @ApiModelProperty("电话号码")
    @TableField("phone_num")
    private String phoneNum;

    @ApiModelProperty("余额")
    @TableField("remain")
    private Double remain;

    @ApiModelProperty("角色")
    @TableField("right")
    private Integer right;

    @ApiModelProperty("密码")
    @TableField("pass_word")
    private String passWord;

    @ApiModelProperty("充值时间")
    @TableField("remain_time")
    private String remainTime;
}