package com.example.lioveecommunityj.service;

import com.example.lioveecommunityj.entity.DockingEntity;
import com.github.pagehelper.PageInfo;

public interface DockingService {
    /**
     * 查询所有对接信息
     */
    PageInfo<DockingEntity> selectDocking(Integer pageNum , Integer pageSize);
}
