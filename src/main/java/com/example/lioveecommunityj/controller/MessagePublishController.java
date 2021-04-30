package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.entity.ApartmentEntity;
import com.example.lioveecommunityj.vo.MessageVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "信息发布")
@RestController
@RequestMapping("/messagePublish")
public class MessagePublishController {




    @PostMapping("/insertCommunityInformation")
    @ApiOperation(value = "插入社区/企业信息",notes = "插入社区/企业信息",httpMethod = "POST")
    public JsonMessage insertCommunityInformation(@RequestBody @Valid MessageVo messageVo , HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success("插入成功","插入结果");
    }

    @GetMapping("/rentApartment")
    @ApiOperation(value = "查询所有出租房屋信息",notes = "查询所有出租房屋信息",httpMethod = "GET")
    public JsonMessage rentApartment(){

        return JsonMessage.success(new PageInfo(),"出租查询结果");
    }

    @PostMapping("/insertApartment")
    @ApiOperation(value = "插入出租信息",notes = "插入出租信息",httpMethod = "POST")
    public JsonMessage insertApartment(@RequestBody @Valid ApartmentEntity apartmentEntity , HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success("插入成功","插入结果");
    }
}
