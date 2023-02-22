package com.zkx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zkx.mapper.UserMapper;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DESK0
 * @date 2022/10/17 17:09
 */
//条件构造器的使用
//删除和查询用的是QueryWrapper,更新和添加用的是UpdateWrapper
@SpringBootTest
public class WrapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01() {
        //查询用户名包含i,且年龄在11到15之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //添加查询条件,链式结构,使用的是数据库的字段名
        queryWrapper.like("user_name", "i").between("age", 11, 15)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void Test02() {
        //查询用户，按照年龄降序排序，若年龄相同则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void Test03() {
        //删除邮箱为null的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result = " + result);
    }

    @Test
    //修改操作的第一种用法
    public void Test04() {
        //将 年龄大于40且用户名包含i 或 邮箱为null 的用户修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //条件会自动用and拼接所以不用and方法
        //and优先级高于or,所以这里直接.or
        queryWrapper.gt("age", 40).like("user_name", "i")
                .or()
                .isNull("email");

        User user = new User();
        user.setName("bb");
        user.setAge(66);
        user.setEmail("bb@b.com");

        //第一个参数用于修改的内容，第二个为修改条件
        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    //条件的优先级
    public void Test044() {
        //上个Test的条件为           将 年龄大于40且用户名包含i 或 邮箱为null 的用户修改
        //这个Test的条件为           将 户名包含i 并且 年龄大于40或邮箱为null 的用户修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //lambda中的条件优先执行
        queryWrapper.like("user_name", "i")
                .and(i -> i.gt("age", 40).or().isNull("email"));

        User user = new User();
        user.setName("dd");
        user.setAge(11);
        user.setEmail("dd@d.com");

        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    //以上方法都是默认查询所有字段，如果仅仅需要查询某些字段 需要使用以下方法
    public void Test05() {
        //查询用户的姓名和年龄
        //SELECT user_name,age FROM t_user WHERE is_deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    //子查询的使用例子
    //select * from t_user where uid in (select uid from t_user where uid <=20);
    public void Test06() {
        //查询id小于等于20的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid <= 20");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    //使用updateWrapper实现修改功能，可见Test04
    public void Test07() {
        //将 户名包含i 并且 年龄大于40或邮箱为null 的用户修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("user_name", "i")
                .and(i -> i.gt("age", 40).or().isNull("email"));
        //此步可以避免创建实体类对象
        userUpdateWrapper.set("user_name", "upUp").set("age", 34);
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println("update = " + update);
        //使用userUpdateWrapper的一些方法可以设置修改的条件和字段
        //与Test04不同的是这个使用userUpdateWrapper的set方法，上面的传入实体类修改。
    }

    @Test
    //组装条件
    public void Test08() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 11;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {//使用mybatis-plus包的StringUtils(不为空和null)
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }//gt大于，ge大于等于。lt小于，le小于等于。
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    //使用condition简化Test08
    public void Test09() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 11;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    //LambdaQueryWrapper的使用
    //使用 User::getAge 以防止些写错字段名
    public void Test10() {
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 11;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    //LambdaUpdateWrapper的使用
    public void Test11() {
        //将 户名包含i 并且 年龄大于40或邮箱为null 的用户修改
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "i")
                .and(i -> i.gt(User::getAge, 40).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName, "upup").set(User::getAge, 34);
        int update = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("update = " + update);
    }
}
