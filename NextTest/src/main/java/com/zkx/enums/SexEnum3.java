package com.zkx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author DESK0
 * @date 2022/12/21 22:18
 */
@Getter
public enum SexEnum3 {

    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    private Integer sex;
    private String SexName;

    SexEnum3() {
    }

    SexEnum3(Integer sex, String sexName) {
        this.sex = sex;
        SexName = sexName;
    }
}
