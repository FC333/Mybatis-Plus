package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Ori
 * @date 2022/3/10-18:51
 */
@Data
@TableName("t_product")
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer version;
}
