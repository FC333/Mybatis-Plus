package com.zkx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.vo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DESK0
 * @date 2022/12/21 17:53
 */

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectByNameAndAge(@Param("b_name") String name, @Param("b_age") Integer age);

    List<Student> selectVoByIdPage(Page<Student> page, Integer age);
}
