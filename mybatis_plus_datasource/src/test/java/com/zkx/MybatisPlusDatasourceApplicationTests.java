package com.zkx;

import com.zkx.service.ProductService;
import com.zkx.service.UserService;
import com.zkx.vo.Product;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {
    @Resource
    private UserService userService;
    @Resource
    private ProductService productService;

    @Test
    public void test01() {

        User user1 = userService.getById(1);
        System.out.println(user1);

        Product product1 = productService.getById(1);
        System.out.println(product1);
    }

}
