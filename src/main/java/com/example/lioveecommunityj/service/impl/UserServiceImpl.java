package com.example.lioveecommunityj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.lioveecommunityj.common.util.MyStringUtil;
import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.mapper.UserMapper;
import com.example.lioveecommunityj.service.UserService;
import com.example.lioveecommunityj.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public String userLogin(UserVo userVo) {
        if (userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone_num",userVo.getPhoneNum()).eq("password",userVo.getPassword()))==null){
            return "用户名或密码错误";
        }
        return "登录成功";
    }

    @Override
    public UserEntity selectNowUser(String phoneNum) {
        return userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone_num",phoneNum));
    }

    @Override
    public PageInfo<UserEntity> selectAllUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,  pageSize);
        return PageInfo.of(userMapper.selectList(new QueryWrapper<>()));
    }

    @Override
    public PageInfo<UserEntity> selectUserByLike(String query, Integer pageNum, Integer pageSize) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("user_name",query);

        PageHelper.startPage(pageNum,  pageSize);
        return PageInfo.of(userMapper.selectList(wrapper));
    }

    @Override
    public String insertUser(UserEntity userEntity) {
        return "插入"+ MyStringUtil.intToString(userMapper.insert(userEntity));
    }

    @Override
    public String updateUser(UserEntity userEntity) {
        return "修改"+MyStringUtil.intToString(userMapper.updateById(new UserEntity()));
    }

    @Override
    public String deleteUser(Long userId) {
        return "删除"+MyStringUtil.intToString(userMapper.deleteById(userId));
    }

    @Override
    public String rightUser(Long userId, Integer right) {
        return "分配权限"+MyStringUtil.intToString(userMapper.update(new UserEntity(),new UpdateWrapper<UserEntity>().eq("user_id",userId).set("right",right)));
    }

    @Override
    public Double queryRemain(HttpServletRequest request) {
        return userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phoneNum",request.getSession().getAttribute("phoneNum"))).getRemain();
    }

    @Override
    public String addRemain(String phoneNum) {
        return "充值"+MyStringUtil.intToString(userMapper.update(new UserEntity() , new UpdateWrapper<UserEntity>().eq("phoneNum",phoneNum)));
    }
}
