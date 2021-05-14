package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("对接信息")
@TableName("t_docking")
public class DockingEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("对接Id")
    private Long message_id;

    @ApiModelProperty("请求人")
    @TableField("applicant")
    private String applicant;

    @ApiModelProperty("请求的电话号码")
    @TableField("applicant_phone")
    private String applicantPhone;

    @ApiModelProperty("帮扶者")
    @TableField("helper")
    private String helper;

    @ApiModelProperty("帮扶者电话号码")
    @TableField("helper_phone")
    private String helperPhone;

    @ApiModelProperty("帮扶类型")
    @TableField("helper_type")
    private String helperType;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("评价")
    @TableField("comtent")
    private String comtent;
}
