package com.example.lioveecommunityj.vo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

public class MessageVo {
    @ApiModelProperty("文件")
    private MultipartFile file;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("1 社区/2 企业")
    private Integer flag;

}
