package com.example.lioveecommunityj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("出租信息")
@TableName("t_apartment")
public class ApartmentEntity {

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
}
