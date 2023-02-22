package com.zkx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.vo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by DESK0 on 2022/10/16 20:48
 */
public interface UserMapper extends BaseMapper<User> {
    //自定义方法，根据id查询用户信息返回Map集合
    //@SuppressWarnings("MybatisXMapperMethodInspection")
    @MapKey("id")
    Map<String, Object> selectMapById(Long id);

    //根据年龄返回分页数据,要使用分页插件必须把Page对象放在第一个参数
    //@Param:Dao层中给sql传参的注解
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
