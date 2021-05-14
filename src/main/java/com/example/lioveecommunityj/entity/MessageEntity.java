package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("信息发送")
@TableName("t_message")
@AllArgsConstructor
public class MessageEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("信息Id")
    private Long message_id;

    @ApiModelProperty("请求信息")
    @TableField("content")
    private String content;

    @ApiModelProperty("发布时间")
    @TableField("publish_time")
    private Date publishTime;

    @ApiModelProperty("发布者")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("文件地址")
    @TableField("file_path")
    private String file_path;

    @ApiModelProperty("1 社区/2 企业")
    @TableField("flag")
    private Integer flag;

    @ApiModelProperty("公司名称")
    @TableField("company")
    private String company;

    public MessageEntity(String content, Date publishTime, Long userId , Integer flag , String company) {
        this.content = content;
        this.publishTime = publishTime;
        this.userId = userId;
        this.flag = flag;
        this.company = company;
    }

    public MessageEntity(String content, Date publishTime, Long userId, String file_path, Integer flag) {
        this.content = content;
        this.publishTime = publishTime;
        this.userId = userId;
        this.file_path = file_path;
        this.flag = flag;
    }
}
