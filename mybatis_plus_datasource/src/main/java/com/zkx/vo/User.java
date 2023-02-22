package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Ori
 * @date 2022/3/10-18:48
 */
@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    private Integer isDeleted;
}
