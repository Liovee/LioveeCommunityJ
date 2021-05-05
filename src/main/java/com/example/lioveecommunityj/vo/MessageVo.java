package com.example.lioveecommunityj.vo;

import com.example.lioveecommunityj.entity.MessageEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


public class MessageVo extends MessageEntity {

    @ApiModelProperty("文件")
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MessageVo(String content, Date publishTime, Long userId, String file_path, Integer flag) {
        super(content, publishTime, userId, file_path, flag);
    }
}
