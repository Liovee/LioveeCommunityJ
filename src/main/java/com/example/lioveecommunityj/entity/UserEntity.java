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
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
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
    @TableField("rights")
    private Integer rights;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("充值时间")
    @TableField("remain_time")
    private Date remainTime;

    @ApiModelProperty("出生日期")
    @TableField("birth")
    private Date birth;

    @ApiModelProperty("身份证号")
    @TableField("idCard")
    private String idCard;
}