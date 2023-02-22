package com.zkx;

import com.zkx.enums.SexEnum;
import com.zkx.mapper.UserMapper;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author DESK0
 * @date 2022/10/18 10:30
 */
@SpringBootTest
public class EnumTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test01() {
        User user = new User();
        user.setAge(12);
        user.setName("lili");
        user.setSex(SexEnum.FEMALE);
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }
}
