package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.service.DockingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "对接查看")
@RestController
@RequestMapping("/dockingView")
public class DockingViewController {

    @Autowired
    DockingService dockingService;

    @GetMapping("/selectDocking")
    @ApiOperation(value = "查询所有对接信息",notes = "查询所有对接信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面数量", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", paramType = "query")})
    public JsonMessage selectDocking(@RequestParam Integer pageNum ,@RequestParam Integer pageSize){

        return JsonMessage.success(dockingService.selectDocking(pageNum , pageSize),"信息查询结果");
    }
}
