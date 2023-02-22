package com.zkx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.vo.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DESK0
 * @date 2022/12/21 22:30
 */
public interface PeopleMapper extends BaseMapper<People> {

    People selectByIdAndAge(@Param("id") Integer id, @Param("age") Integer age);

    List<People> selectByAgePage(Page<People> page);
}
