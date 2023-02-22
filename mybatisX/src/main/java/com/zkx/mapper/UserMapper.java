package com.zkx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zkx.vo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author DESK0
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-12-15 21:57:47
* @Entity com.zkx.vo.User
*/
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByAgeAndSex(@Param("age") Integer age, @Param("sex") Integer sex);
}




