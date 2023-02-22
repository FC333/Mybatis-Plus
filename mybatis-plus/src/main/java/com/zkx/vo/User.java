package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.zkx.enums.SexEnum;
import lombok.Data;

/**
 * Created by DESK0 on 2022/10/16 20:39
 */
@Data//自动生成setter,getter,hashCode,toString.equals方法(无参是默认有的,不会生成有参)
//@TableName("t_user")//设置实体类所对应的表名
public class User {

    //@TableId:将属性所对应的字段指定为主键.value属性用于指定主键的字段,type属性用于设置主键生成策略
    //默认为雪花算法:IdType.ASSIGN_ID,使用数据库自增策略:1.数据库设置了id自增 2.使用AUTO或配置文件设置auto
    //@TableId(value = "uid",type = IdType.AUTO)
    @TableId("uid")
    private Long id;

    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;

    private Integer age;
    private String email;

    private SexEnum sex;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;//在Mybatis-Plus中,驼峰命名和下划线命名会自动映射
}
