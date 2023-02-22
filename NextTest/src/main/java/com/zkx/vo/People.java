package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.zkx.enums.SexEnum3;
import lombok.Data;

/**
 * @author DESK0
 * @date 2022/12/21 22:17
 */
@Data
public class People {
    @TableId("pid")
    private Integer id;
    @TableField("p_name")
    private String name;
    private SexEnum3 sex;
    private Integer age;
    @TableLogic
    private Integer isDeleted;
}
