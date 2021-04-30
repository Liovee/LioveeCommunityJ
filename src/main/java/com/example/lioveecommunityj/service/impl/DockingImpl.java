package com.example.lioveecommunityj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lioveecommunityj.entity.DockingEntity;
import com.example.lioveecommunityj.mapper.DockingMapper;
import com.example.lioveecommunityj.service.DockingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DockingImpl implements DockingService {

    @Resource
    DockingMapper dockingMapper;

    @Override
    public PageInfo<DockingEntity> selectDocking(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,  pageSize);
        return PageInfo.of(dockingMapper.selectList(new QueryWrapper<DockingEntity>()));
    }
}
