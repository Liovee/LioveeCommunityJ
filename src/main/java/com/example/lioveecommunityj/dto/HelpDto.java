package com.example.lioveecommunityj.dto;

import com.example.lioveecommunityj.entity.HelpEntity;
import lombok.Data;

@Data
public class HelpDto extends HelpEntity {
    private String userName;
    private String phoneNum;
}
