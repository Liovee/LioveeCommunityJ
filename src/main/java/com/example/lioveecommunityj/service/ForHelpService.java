package com.example.lioveecommunityj.service;

import com.example.lioveecommunityj.entity.HelpEntity;
import com.example.lioveecommunityj.entity.UserEntity;

import java.util.List;

public interface ForHelpService {
    /**
     * 查询所有委托人
     */
    List<UserEntity> selectClient();

    /**
     * 插入委托
     */
    String insertEntrust(HelpEntity helpEntity);
}
