package com.zkx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.enums.SexEnum2;
import com.zkx.mapper.StudentMapper;
import com.zkx.mapper.TeacherMapper;
import com.zkx.service.StudentService;
import com.zkx.vo.Student;
import com.zkx.vo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.zkx.enums.SexEnum2.MALE;

/**
 * @author DESK0
 * @date 2022/12/21 18:28
 */
@SpringBootTest
public class MPTest {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentService studentService;

    @Test
    public void testOne() {
        List<Student> students1 = studentMapper.selectList(null);
        students1.forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        Student student = studentMapper.selectById(102);
        System.out.println("student = " + student);
    }

    @Test
    public void testThree() {
        List<Student> students1 = studentMapper.selectList(null);
        students1.forEach(System.out::println);
    }

    @Test
    public void testFour() {
        List<Student> students1 = studentMapper.selectList(null);
        students1.forEach(System.out::println);
    }

    @Test
    public void testFive() {
        Student student1 = new Student();
        student1.setId(103);
        student1.setName("lisi3");
        student1.setSex(SexEnum2.FEMALE);
        student1.setAge(18);
        int insert = studentMapper.insert(student1);
        System.out.println("insert = " + insert);
    }

    @Test
    public void testSix() {
        long count = studentService.count();
        System.out.println("count = " + count);
    }

    @Test
    public void testSeven() {
        List<Student> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student student = new Student();
            student.setId(110 + i);
            student.setName("lisi" + String.valueOf((i + 10)));
            student.setSex(SexEnum2.FEMALE);
            student.setAge(18);
            list1.add(student);
        }

        //测试批量添加,sava开头的为添加
        boolean b = studentService.saveBatch(list1);
        System.out.println("b = " + b);
    }

    @Test
    public void testEight() {
        List<Student> lisi3 = studentMapper.selectByNameAndAge("lisi3", 18);
        lisi3.forEach(System.out::println);
    }

    @Test
    public void testNine() {
        Page<Student> page = new Page<>(3, 3);
        List<Student> students = studentMapper.selectVoByIdPage(page, 17);
        students.forEach(System.out::println);
    }

    @Test
    public void testTen() {
        Teacher teacher1 = teacherMapper.selectById(1101);
        System.out.println("小李查询出的价格：" + teacher1.getBalance());

        Teacher teacher2 = teacherMapper.selectById(1101);
        System.out.println("小王查询出的价格：" + teacher2.getBalance());

        //小李将余额加500
        teacher1.setBalance(teacher1.getBalance() + 500);
        int i = teacherMapper.updateById(teacher1);
        System.out.println("小李改价结果 = " + i);
        //

        //小王将余额减100
        teacher2.setBalance(teacher2.getBalance() - 100);
        int j = teacherMapper.updateById(teacher2);
        System.out.println("小王改价结果 = " + j);
        //此时改价时版本号不一致,所以改了个寂寞

        Teacher teacher3 = teacherMapper.selectById(1101);
        System.out.println("最终价格" + teacher3.getBalance());
    }
}
