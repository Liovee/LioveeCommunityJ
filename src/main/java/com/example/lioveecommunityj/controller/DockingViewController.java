package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "对接查看")
@RestController
@RequestMapping("/dockingView")
public class DockingViewController {
    @GetMapping("/selectDocking")
    @ApiOperation(value = "查询所有对接信息",notes = "查询所有对接信息",httpMethod = "GET")
    public JsonMessage selectDocking(){

        return JsonMessage.success(new PageInfo(),"信息查询结果");
    }
}
