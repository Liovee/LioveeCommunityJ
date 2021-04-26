package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.vo.UserVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    
    @PostMapping("/userLogin")
    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    public JsonMessage userLogin(@RequestBody @Valid UserVo userVo , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success();
    }

}
