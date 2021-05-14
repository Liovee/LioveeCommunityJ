package com.example.lioveecommunityj.service;


import com.example.lioveecommunityj.entity.ApartmentEntity;
import com.example.lioveecommunityj.entity.MessageEntity;
import com.example.lioveecommunityj.vo.MessageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface ApartmentService {

    /**
     * 上传社区/企业信息
     */
    String insertCommunityInformation(MessageVo messageVo, HttpServletRequest request);

    /**
     * 查询社区/企业信息
     */
    PageInfo<MessageEntity> selectCommunityInformation(Integer flag, Integer pageNum , Integer pageSize);

    /**
     * 查询所有出租房屋信息
     */
    PageInfo<ApartmentEntity> rentApartment(Integer pageNum , Integer pageSize);

    /**
     * 更新出租房屋状态
     */
    String updateStatus(Long apartmentId , Integer status);

    /**
     * 插入出租信息
     */
    String insertApartment(ApartmentEntity apartmentEntity);
}
