package com.example.lioveecommunityj.service;

import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface UserService {
    /**
     * 用户登录
     */
    String userLogin(UserVo userVo);

    /**
     *查询当前用户
     */
    UserEntity selectNowUser(String phoneNum);

    /**
     *查询所有用户
     */
    PageInfo<UserEntity> selectAllUser(Integer pageNum, Integer pageSize);

    /**
     *模糊查询用户
     */
    PageInfo<UserEntity>  selectUserByLike( String query,  Integer pageNum,  Integer pageSize);

    /**
     *新增用户
     */
    String insertUser(UserEntity userEntity);

    /**
     *修改用户
     */
    String updateUser(UserEntity userEntity);

    /**
     *删除用户
     */
    String deleteUser(Long userId);

    /**
     *删除用户
     */
    String rightUser(Long userId, Integer right);
}
