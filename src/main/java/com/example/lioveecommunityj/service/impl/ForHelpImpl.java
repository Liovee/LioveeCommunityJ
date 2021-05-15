package com.example.lioveecommunityj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lioveecommunityj.common.util.MyStringUtil;
import com.example.lioveecommunityj.entity.HelpEntity;
import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.mapper.ForHelpMapper;
import com.example.lioveecommunityj.mapper.UserMapper;
import com.example.lioveecommunityj.service.ForHelpService;
import com.example.lioveecommunityj.vo.HelpVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ForHelpImpl implements ForHelpService {

    @Resource
    UserMapper userMapper;

    @Resource
    ForHelpMapper forHelpMapper;

    @Override
    public List<UserEntity> selectClient() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public String insertEntrust(HelpVo helpVo) {
        HelpEntity helpEntity = new HelpEntity();
        BeanUtils.copyProperties(helpVo,helpEntity);
        helpEntity.setTags(helpVo.getTags().toString());
        return "插入"+ MyStringUtil.intToString(forHelpMapper.insert(helpEntity));
    }

    @Override
    public List<HelpEntity> selectMyHelp(Integer flag, HttpServletRequest request) {
        Long userId = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone_num",request.getSession().getAttribute("phoneNum"))).getUserId();
        QueryWrapper wrapper = new QueryWrapper<HelpEntity>();
        if (flag == 1){
             wrapper.eq("user_id",userId);
        }
        if (flag == 2){
            wrapper.eq("give_user_id",userId);
        }
        return forHelpMapper.selectList(wrapper);
    }

    @Override
    public List<HelpEntity> selectGiveHelp(HttpServletRequest request) {
        Long userId = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone_num",request.getSession().getAttribute("phoneNum"))).getUserId();

        return forHelpMapper.selectList(new QueryWrapper<HelpEntity>().eq("give_user_id",userId));
    }

    @Override
    public List<Integer> selectDataNotice(Date selectTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(selectTime);
        cal.add(Calendar.MONTH, 1);
        return forHelpMapper.selectDataNotice(selectTime,cal.getTime());
    }
}
