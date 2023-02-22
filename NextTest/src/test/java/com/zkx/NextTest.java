package com.zkx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkx.enums.SexEnum3;
import com.zkx.mapper.PeopleMapper;
import com.zkx.mapper.ThingMapper;
import com.zkx.service.PeopleService;
import com.zkx.vo.People;
import com.zkx.vo.Thing;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DESK0
 * @date 2022/12/21 22:39
 */
@SpringBootTest
public class NextTest {

    @Resource
    private PeopleMapper peopleMapper;
    @Resource
    private ThingMapper thingMapper;
    @Resource
    private PeopleService peopleService;

    @Test
    public void testOne() {
        List<People> people = peopleMapper.selectList(null);
        people.forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        People people = peopleMapper.selectById(1);
        System.out.println("people = " + people);
    }

    @Test
    public void testThree() {
        People people = peopleMapper.selectByIdAndAge(1, 18);
        System.out.println("people = " + people);
    }

    @Test
    public void testFour() {
        Page<People> page = new Page<>(3, 3);

        List<People> people = peopleMapper.selectByAgePage(page);
        people.forEach(System.out::println);
    }

    @Test
    public void testFive() {
        long count = peopleService.count();
        System.out.println("count = " + count);
    }

    @Test
    public void testSix() {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            People people = new People();
            people.setId(6 + i);
            people.setName("l" + String.valueOf((6 + i)));
            people.setSex(SexEnum3.FEMALE);
            people.setAge(3 + i);
            list.add(people);
        }

        boolean b = peopleService.saveBatch(list);
        System.out.println("b = " + b);
    }

    @Test
    public void testSeven() {
        Thing thing1 = thingMapper.selectById(11);
        System.out.println("小李查询的余额为" + thing1.getBalance());

        Thing thing2 = thingMapper.selectById(11);
        System.out.println("小王查询的余额为" + thing2.getBalance());

        thing1.setBalance(thing1.getBalance() + 500);
        int i = thingMapper.updateById(thing1);
        System.out.println("小李修改结果" + i);

        thing2.setBalance(thing2.getBalance() - 100);
        int j = thingMapper.updateById(thing2);
        System.out.println("小王修改结果" + j);

        Thing thing = thingMapper.selectById(11);
        System.out.println("最终价格" + thing.getBalance());
    }

    @Test
    public void testEight() {
        int i = peopleMapper.deleteById(9);
        System.out.println("i = " + i);
    }
}
