package com.zkx;

import com.zkx.mapper.UserMapper;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DESK0 on 2022/10/16 20:55
 */
@SpringBootTest
public class BaseMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        //通过一个条件构造器查询一个List集合,无条件可设为null返回所有
        //SELECT uid AS id,user_name AS name,age,email,sex,is_deleted FROM t_user WHERE is_deleted=0
        List<User> list = userMapper.selectList(null);
        //使用Lombok中方法的引用直接输出
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        //实现新增用户信息
        //INSERT INTO t_user ( user_name, age, email, sex ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        //user.setId(44L);//id为主键不能重复,防报错
        user.setName("lili-44");
        user.setAge(45464644);
        user.setEmail("lili-44@com");
        int num = userMapper.insert(user);
        System.out.println("num = " + num);
        System.out.println("id:" + user.getId());
    }


    @Test
    public void testUpdate() {
        //修改用户信息
        //UPDATE t_user SET user_name=?, age=?, email=?, sex=? WHERE uid=? AND is_deleted=0
        //实体类中使用了逻辑删除注解后,删除和修改数据均为UPDATE语句
        User user = new User();
        user.setId(94L);
        user.setAge(45);
        user.setName("lili-45");
        user.setEmail("lili-45@com");
        int k = userMapper.updateById(user);
        System.out.println("k = " + k);
    }

    @Test
    public void testDelete() {
        //通过id删除用户信息
        //UPDATE t_user SET is_deleted=1 WHERE uid=? AND is_deleted=0
/*        int result = userMapper.deleteById(24);
        System.out.println("result:"+result);*/

        //根据map集合中所设置的条件删除用户信息
        //UPDATE t_user SET is_deleted=1 WHERE user_name = ? AND age = ? AND is_deleted=0
/*        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "小黑");
        map.put("age",45);
        int result = userMapper.deleteByMap(map);
        System.out.println("result:"+result);*/

        //通过多个id实现批量删除
        //UPDATE t_user SET is_deleted=1 WHERE uid IN ( ? , ? , ? ) AND is_deleted=0
        List<Long> list = Arrays.asList(21L, 22L, 23L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:" + result);
    }

    @Test
    public void testSelect() {
        //通过id查询用户信息

        //SELECT uid AS id,user_name AS name,age,email,sex,is_deleted FROM t_user WHERE uid=? AND is_deleted=0
/*        User user = userMapper.selectById(20);
        System.out.println(user);*/

        //根据多个id查询多个用户信息
/*        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);*/

        //根据map集合中的条件查询用户信息
/*        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "bb2");
        map.put("age", 102);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);*/

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        //自定义mapper.xml查询所有数据
        Map<String, Object> map = userMapper.selectMapById(93L);
        System.out.println(map);
    }
}
