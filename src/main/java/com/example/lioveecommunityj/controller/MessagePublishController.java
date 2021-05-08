package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.entity.ApartmentEntity;
import com.example.lioveecommunityj.service.ApartmentService;
import com.example.lioveecommunityj.vo.MessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "信息发布")
@RestController
@RequestMapping("/messagePublish")
public class MessagePublishController {

    @Autowired
    ApartmentService apartmentService;

    @PostMapping("/insertCommunityInformation")
    @ApiOperation(value = "插入社区/企业信息",notes = "插入社区/企业信息",httpMethod = "POST")
    public JsonMessage insertCommunityInformation(@RequestBody @Valid MessageVo messageVo ,HttpServletRequest request,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success(apartmentService.insertCommunityInformation(messageVo,request),"上传结果");
    }

    @GetMapping("/selectCommunityInformation")
    @ApiOperation(value = "查询社区/企业信息",notes = "查询社区/企业信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag", value = "插入1社区/2企业信息", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页面数量", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", paramType = "query")
    })
    public JsonMessage selectCommunityInformation(@RequestParam Integer flag , @RequestParam Integer pageNum , @RequestParam Integer pageSize){

        return JsonMessage.success(apartmentService.selectCommunityInformation(flag , pageNum , pageSize),"查询结果");
    }

    @GetMapping("/rentApartment")
    @ApiOperation(value = "查询所有出租房屋信息",notes = "查询所有出租房屋信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面数量", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", paramType = "query")})
    public JsonMessage rentApartment(@RequestParam Integer pageNum ,@RequestParam Integer pageSize){

        return JsonMessage.success(apartmentService.rentApartment(pageNum ,  pageSize),"出租查询结果");
    }

    @PostMapping("/insertApartment")
    @ApiOperation(value = "插入出租信息",notes = "插入出租信息",httpMethod = "POST")
    public JsonMessage insertApartment(@RequestBody @Valid ApartmentEntity apartmentEntity , HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success(apartmentService.insertApartment(apartmentEntity),"插入结果");
    }
}
