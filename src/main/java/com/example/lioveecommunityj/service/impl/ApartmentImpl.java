package com.example.lioveecommunityj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.lioveecommunityj.common.util.MyStringUtil;
import com.example.lioveecommunityj.entity.ApartmentEntity;
import com.example.lioveecommunityj.entity.MessageEntity;
import com.example.lioveecommunityj.entity.UserEntity;
import com.example.lioveecommunityj.mapper.ApartmentMapper;
import com.example.lioveecommunityj.mapper.MessageMapper;
import com.example.lioveecommunityj.mapper.UserMapper;
import com.example.lioveecommunityj.service.ApartmentService;
import com.example.lioveecommunityj.vo.MessageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class ApartmentImpl implements ApartmentService {

    @Resource
    ApartmentMapper apartmentMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    MessageMapper messageMapper;

    @Override
    public String insertCommunityInformation(MessageVo messageVo, HttpServletRequest request) {
        MultipartFile file = messageVo.getFile();

        Long userId = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone_num",request.getSession().getAttribute("phoneNum"))).getUserId();

        if (file.isEmpty()){

            MessageEntity messageEntity = new MessageEntity(messageVo.getContent(),new Date(),userId,messageVo.getFlag(),messageVo.getCompany());

            return "上传"+MyStringUtil.intToString(messageMapper.insert(messageEntity));
        }

        File savefile = new File("D:\\"+request.getSession().getAttribute("phoneNum") );
        if (!savefile.exists()){
            savefile.mkdirs();
        }

        String path =  "\\" + ""+new Date().getTime()+file.getOriginalFilename() ;
        try {
            file.transferTo(new File(savefile+path));
        } catch (IOException e) {
            e.printStackTrace();
            return "上传异常";
        }

        MessageEntity messageEntity = new MessageEntity(messageVo.getContent(),new Date(),userId,savefile+path,messageVo.getFlag());

        return "上传"+MyStringUtil.intToString(messageMapper.insert(messageEntity));
    }

    @Override
    public PageInfo<MessageEntity> selectCommunityInformation(Integer flag, Integer pageNum , Integer pageSize) {
        PageHelper.startPage(pageNum ,  pageSize);
        return PageInfo.of(messageMapper.selectList(new QueryWrapper<MessageEntity>().eq("flag" , flag)));
    }

    @Override
    public PageInfo<ApartmentEntity> rentApartment(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,  pageSize);
        return PageInfo.of(apartmentMapper.selectList(new QueryWrapper<ApartmentEntity>()));
    }

    @Override
    public String updateStatus(Long apartmentId, Integer status) {
        return "更新状态"+MyStringUtil.intToString(apartmentMapper.update(new ApartmentEntity(),new UpdateWrapper<ApartmentEntity>().eq("apartment_id",apartmentId).set("status",status)));
    }

    @Override
    public String insertApartment(ApartmentEntity apartmentEntity) {
        return "插入"+ MyStringUtil.intToString(apartmentMapper.insert(apartmentEntity));
    }
}
