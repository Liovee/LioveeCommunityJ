package com.example.lioveecommunityj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lioveecommunityj.common.util.MyStringUtil;
import com.example.lioveecommunityj.entity.HelpEntity;
import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.mapper.ForHelpMapper;
import com.example.lioveecommunityj.mapper.UserMapper;
import com.example.lioveecommunityj.service.ForHelpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public String insertEntrust(HelpEntity helpEntity) {
        return "插入"+ MyStringUtil.intToString(forHelpMapper.insert(helpEntity));
    }

    @Override
    public List<Integer> selectDataNotice(Date selectTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(selectTime);
        cal.add(Calendar.MONTH, 1);
        return forHelpMapper.selectDataNotice(selectTime,cal.getTime());
    }
}
