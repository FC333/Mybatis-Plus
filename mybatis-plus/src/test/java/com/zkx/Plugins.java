package com.zkx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.mapper.ProductMapper;
import com.zkx.mapper.UserMapper;
import com.zkx.vo.Product;
import com.zkx.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author DESK0
 * @date 2022/10/18 8:13
 */
@SpringBootTest
public class Plugins {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testPage() {
        Page<User> page = new Page<>(2, 4);
        //(页码，显示条数)// limit 起始索引(页码-1再乘以条数)，显示条数。
        userMapper.selectPage(page, null);

        System.out.println("1. " + page.getRecords());//获取当前页数据
        System.out.println("2. " + page.getCurrent());//获取页码
        System.out.println("3. " + page.getSize());//获取显示条数
        System.out.println("4. " + page.getPages());//获取总页数
        System.out.println("5. " + page.getTotal());//获取总记录数
        System.out.println("6. " + page.hasNext());//是否有下一页
        System.out.println("7. " + page.hasPrevious());//是否有上一页
    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page<>(2, 4);
        userMapper.selectPageVo(page, 10);

        System.out.println("1. " + page.getRecords());//获取当前页数据
        System.out.println("2. " + page.getCurrent());//获取页码
        System.out.println("3. " + page.getSize());//获取显示条数
    }

    @Test
    public void testProduct01() {
        Product A = productMapper.selectById(1);
        System.out.println("A查询的价格 = " + A.getPrice());

        Product B = productMapper.selectById(1);
        System.out.println("B查询的价格 = " + B.getPrice());

        //A将价格+50
        A.setPrice(A.getPrice() + 50);
        productMapper.updateById(A);

        //B将价格-30
        B.setPrice(B.getPrice() - 30);
        int result = productMapper.updateById(B);
        //老板查价格
        Product C = productMapper.selectById(1);
        System.out.println("C查询的价格 = " + C.getPrice());
    }
}
