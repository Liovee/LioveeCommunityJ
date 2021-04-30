package com.example.lioveecommunityj.service;


import com.example.lioveecommunityj.entity.ApartmentEntity;
import com.example.lioveecommunityj.vo.MessageVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

public interface ApartmentService {

    /**
     * 上传社区/企业信息
     */
    String insertCommunityInformation(MessageVo messageVo, HttpServletRequest request);

    /**
     * 查询所有出租房屋信息
     */
    PageInfo<ApartmentEntity> rentApartment(Integer pageNum , Integer pageSize);

    /**
     * 插入出租信息
     */
    String insertApartment(ApartmentEntity apartmentEntity);
}
