package com.zkx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zkx.mapper.StudentMapper;
import com.zkx.vo.Student;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DESK0
 * @date 2022/12/21 19:21
 */
@SpringBootTest
public class WrapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testOne() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("sid", 105);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("s_name", 2);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void testThree() {
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("sid", 110).set("age", 81);
        int update = studentMapper.update(null, updateWrapper);
        System.out.println("update = " + update);
    }


    @Test
    public void testFour() {
        Integer id = 105;
        Integer age = 19;

        LambdaQueryWrapper<Student> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(id != null, Student::getId, id)
                .gt(age != null, Student::getAge, age);
        List<Student> students = studentMapper.selectList(lambdaQueryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void testFive() {
    }

    @Test
    public void testSix() {
    }

    @Test
    public void testSeven() {
    }

    @Test
    public void testEight() {
    }

}
