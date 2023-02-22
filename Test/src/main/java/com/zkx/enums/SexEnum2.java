package com.zkx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author DESK0
 * @date 2022/12/21 17:47
 */
@Getter
public enum SexEnum2 {
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum2() {
    }

    SexEnum2(int sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
