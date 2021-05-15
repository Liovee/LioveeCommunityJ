package com.example.lioveecommunityj.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HelpVo {
    @ApiModelProperty("请求ID")
    private Long helpId;

    @ApiModelProperty("请求类型 1卫生2绿化3治安4文化5医疗6社交7民主8教育9生活 ")
    private List<Integer> tags;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("给予帮助人Id")
    private Long giveUserId;

    @ApiModelProperty("帮助时间")
    private Date helpTime;

    @ApiModelProperty("请求内容")
    private String content;

    @ApiModelProperty("预约时间")
    private Date appointmentTime;
}
