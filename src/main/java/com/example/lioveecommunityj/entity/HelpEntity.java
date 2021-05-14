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
@TableName("t_help")
@ApiModel("用户")
public class HelpEntity implements Serializable {
    @ApiModelProperty("请求ID")
    @TableId(type = IdType.AUTO)
    private Long helpId;

    @ApiModelProperty("请求类型 1卫生2绿化3治安4文化5医疗6社交7民主8教育9生活")
    @TableField("tags")
    private Integer tags;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("给予帮助人Id")
    @TableField("give_user_id")
    private Long giveUserId;

    @ApiModelProperty("帮助时间")
    @TableField("help_time")
    private Date helpTime;

    @ApiModelProperty("请求内容")
    @TableField("content")
    private String content;
}