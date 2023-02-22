package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zkx.enums.SexEnum2;
import lombok.Data;

/**
 * @author DESK0
 * @date 2022/12/21 17:45
 */
@Data
public class Student {
    @TableId("sid")
    private Integer id;
    @TableField("s_name")
    private String name;
    private SexEnum2 sex;
    private Integer age;
}
