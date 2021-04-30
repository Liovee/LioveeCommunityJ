package com.example.lioveecommunityj.vo;

import com.example.lioveecommunityj.entity.MessageEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MessageVo extends MessageEntity {
    @ApiModelProperty("文件")
    private MultipartFile file;

}
