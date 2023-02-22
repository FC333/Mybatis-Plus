package com.zkx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * Created by DESK0 on 2022/10/16 21:16
 */
@Getter//枚举中存的都是常量，所以有getter即可
public enum SexEnum {
    //定义值
    MALE(1, "男"),
    FEMALE(2, "女");

    //定义属性
    @EnumValue//将注解所标识的属性的值存储到数据库中
    private Integer sex;
    private String sexName;

    SexEnum() {
    }

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
