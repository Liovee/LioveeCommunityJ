package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("出租信息")
@TableName("t_apartment")
public class ApartmentEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("出租Id")
    private Long apartment_id;

    @ApiModelProperty("联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty("房间号")
    @TableField("room_num")
    private String roomNum;

    @ApiModelProperty("电话号码")
    @TableField("phone_num")
    private String phoneNum;

    @ApiModelProperty("意向出租人")
    @TableField("intentional_lessor")
    private String intentionalLessor;

    @ApiModelProperty("1未租2已租3到期4已被选")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("月租")
    @TableField("month_rent")
    private String monthRent;

    @ApiModelProperty("欲租时长")
    @TableField("rent_time")
    private String rentTime;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("文件存储路径")
    @TableField("url")
    private String url;
}
