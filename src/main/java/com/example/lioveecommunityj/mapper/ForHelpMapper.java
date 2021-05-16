package com.example.lioveecommunityj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lioveecommunityj.entity.HelpEntity;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ForHelpMapper extends BaseMapper<HelpEntity> {
//    @Select("select a.tags,COUNT(*) from (SELECT * from t_help where status IS not NULL) a GROUP BY tags  where selectTime<help_time and selectTimeAddOne>help_time")
    @Select("select count(*) from t_help WHERE tags LIKE concat('%',#{tags},'%') AND status is not null and #{selectTime}<help_time and #{selectTimeAddOne}>help_time")
    List<Integer> selectHelpNotice(Integer tags,Date selectTime , Date selectTimeAddOne);

//    @Select("select a.tags,COUNT(*) from (SELECT * from t_help where status IS NULL) a GROUP BY tags  where selectTime<help_time and selectTimeAddOne>help_time")
    @Select("select count(*) from t_help WHERE tags LIKE concat('%',#{tags},'%') AND status is null and #{selectTime}<help_time and #{selectTimeAddOne}>help_time")
    List<Integer> selectFankuiNotice(Integer tags,Date selectTime , Date selectTimeAddOne);
}
