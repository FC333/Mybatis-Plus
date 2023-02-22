package com.zkx;

import com.zkx.service.UserService;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DESK0 on 2022/10/17 5:00
 */
@SpringBootTest
public class ServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetCount() {
        //查询总记录数
        long count = userService.count();
        System.out.println("总记录数 ：" + count);
    }

    //批量添加的方法在IService中不在BaseMapper中，防止一条sql语句过长
    //通过单个添加循环实现
    @Test
    public void testInsertMore() {
        //save开头的为添加
        //此方法既有批量添加也有批量修改的功能，有id为修改，无为添加。
        //userService.saveOrUpdateBatch();

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("afternoon-" + i);
            user.setAge(456 + i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
