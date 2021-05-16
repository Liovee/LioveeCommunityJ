package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.entity.HelpEntity;
import com.example.lioveecommunityj.service.ForHelpService;
import com.example.lioveecommunityj.vo.HelpVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@Api(tags = "请求帮助")
@RequestMapping("/forHelp")
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
    public JsonMessage insertEntrust(@RequestBody HelpVo helpVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.paramError(bindingResult.getAllErrors().get(0));
        }

        return JsonMessage.success(forHelpService.insertEntrust(helpVo),"插入结果");
    }

    @GetMapping("/selectMyHelp")
    @ApiOperation(value = "请求/给予的帮助",notes = "请求/给予的帮助 1请求2给予",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag", value = "帮助类型", dataType = "Integer", paramType = "query")})
    public JsonMessage selectMyHelp(@RequestParam Integer flag , HttpServletRequest request){

        return JsonMessage.success(forHelpService.selectMyHelp(flag,request),"查询结果");
    }

    @GetMapping("/selectGiveHelp")
    @ApiOperation(value = "查询属于给予帮助人的信息",notes = "查询属于给予帮助人的信息",httpMethod = "GET")
    public JsonMessage selectGiveHelp(HttpServletRequest request){

        return JsonMessage.success(forHelpService.selectGiveHelp(request),"查询结果");
    }

    @GetMapping("/selectDataNotice")
    @ApiOperation(value = "查询看板信息",notes = "查询看板信息,根据输入月份取标签",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "selectTime", value = "查询时间", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "tags", value = "查询标签", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "flag", value = "类型 1帮助2反馈", dataType = "Integer", paramType = "query")})
    public JsonMessage selectDataNotice(@RequestParam Date selectTime,@RequestParam Integer tags,@RequestParam Integer flag){

        return JsonMessage.success(forHelpService.selectDataNotice(selectTime,tags,flag),"查询结果");
    }
}
