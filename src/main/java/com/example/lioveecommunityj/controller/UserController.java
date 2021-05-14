package com.example.lioveecommunityj.controller;

import com.example.lioveecommunityj.common.message.JsonMessage;
import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.service.UserService;
import com.example.lioveecommunityj.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserService userService;
    
    @PostMapping("/userLogin")
    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    public JsonMessage userLogin(@RequestBody @Valid UserVo userVo , HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        request.getSession().setAttribute("phoneNum",userVo.getPhoneNum());
        return JsonMessage.success(userService.userLogin(userVo),"登录结果");
    }

    @GetMapping("/selectNowUser")
    @ApiOperation(value = "查询当前用户",notes = "查询当前用户",httpMethod = "GET")
    public JsonMessage selectNowUser(HttpServletRequest request){

        return JsonMessage.success(userService.selectNowUser(request.getSession().getAttribute("phoneNum").toString()),"查询结果");
    }

    @GetMapping("/selectUserById")
    @ApiOperation(value = "查询用户通过Id",notes = "查询用户通过Id",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "Integer", paramType = "query")
    })
    public JsonMessage selectUserById(@RequestParam Long userId){

        return JsonMessage.success(userService.selectUserById(userId),"查询结果");
    }

    @GetMapping("/selectAllUser")
    @ApiOperation(value = "查询所有用户",notes = "查询所有用户",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面数量", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面发小", dataType = "Integer", paramType = "query")

    })
    public JsonMessage selectAllUser(@RequestParam Integer pageNum,@RequestParam Integer pageSize){

        return JsonMessage.success(userService.selectAllUser(pageNum, pageSize),"查询结果");
    }

    @GetMapping("/selectUserByLike")
    @ApiOperation(value = "模糊查询用户",notes = "模糊查询用户",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询字段", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页面数量", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", dataType = "Integer", paramType = "query")

    })
    public JsonMessage selectUserByLike(@RequestParam String query,@RequestParam Integer pageNum,@RequestParam Integer pageSize){

        return JsonMessage.success(userService.selectUserByLike(query, pageNum, pageSize),"查询结果");
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "新增用户",notes = "新增用户",httpMethod = "POST")
    public JsonMessage insertUser(@RequestBody @Valid UserEntity userEntity ,  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success(userService.insertUser(userEntity),"新增结果");
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户",notes = "修改用户",httpMethod = "POST")
    public JsonMessage updateUser(@RequestBody @Valid UserEntity userEntity , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return JsonMessage.bizError(bindingResult.getAllErrors().get(0));
        }
        return JsonMessage.success(userService.updateUser(userEntity),"修改结果");
    }

    @GetMapping("/deleteUser")
    @ApiOperation(value = "删除用户",notes = "删除用户",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "Long", paramType = "query")
    })
    public JsonMessage deleteUser(@RequestParam Long userId){

        return JsonMessage.success(userService.deleteUser(userId),"删除结果");
    }

    @GetMapping("/rightUser")
    @ApiOperation(value = "分配用户权限",notes = "分配用户权限",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "rights", value = "用户权限 1管理员 2普通用户", dataType = "Integer", paramType = "query")
    })
    public JsonMessage rightUser(@RequestParam Long userId,@RequestParam Integer rights){

        return JsonMessage.success(userService.rightUser(userId, rights),"分配结果");
    }

    @GetMapping("/queryRemain")
    @ApiOperation(value = "查询用户余额",notes = "查询用户余额",httpMethod = "GET")
    public JsonMessage queryRemain(HttpServletRequest request){

        return JsonMessage.success(userService.queryRemain(request),"查询结果");
    }

    @GetMapping("/addRemain")
    @ApiOperation(value = "充值用户余额",notes = "充值用户余额",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNum", value = "电话号码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "money", value = "充值金额", dataType = "String", paramType = "query")
    })
    public JsonMessage addRemain(@RequestParam String phoneNum,@RequestParam double money){

        return JsonMessage.success(userService.addRemain(phoneNum,money),"充值结果");
    }

    @GetMapping("/queryUserByAge")
    @ApiOperation(value = "查询用户年级大于60的用户",notes = "查询用户年级大于60的用户",httpMethod = "GET")
    public JsonMessage queryUserByAge(){

        return JsonMessage.success(userService.queryUserByAge(),"查询结果");
    }
}
