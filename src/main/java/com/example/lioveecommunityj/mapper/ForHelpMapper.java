package com.example.lioveecommunityj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lioveecommunityj.entity.HelpEntity;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ForHelpMapper extends BaseMapper<HelpEntity> {
    @Select("select tags,COUNT(*) from t_help GROUP BY tags where selectTime<help_time and selectTimeAddOne>help_time")
    List<Integer> selectDataNotice(Date selectTime , Date selectTimeAddOne);
}
