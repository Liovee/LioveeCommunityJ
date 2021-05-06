package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.entity.HelpEntity;
import com.example.lioveecommunityj.service.ForHelpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "请求帮助")
public class ForHelpController {

    @Autowired
    ForHelpService forHelpService;

    @GetMapping("/selectClient")
    @ApiOperation(value = "查询所有委托人",notes = "查询所有委托人",httpMethod = "GET")
    public JsonMessage selectClient(){

        return JsonMessage.success(forHelpService.selectClient(),"查询结果");
    }

    @PostMapping("/insertEntrust")
    @ApiOperation(value = "插入委托/插入信息请求",notes = "插入委托/插入信息请求",httpMethod = "POST")
    public JsonMessage insertEntrust(@RequestBody HelpEntity helpEntity, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.paramError(bindingResult.getAllErrors().get(0));
        }

        return JsonMessage.success(forHelpService.insertEntrust(helpEntity),"插入结果");
    }
}
