package com.example.lioveecommunityj.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lioveecommunityj.entity.UserEntity;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    @Select("select * from t_user WHERE TIMESTAMPDIFF(YEAR,birth,now())>=60")
    List<UserEntity> queryUserByAge();

}
