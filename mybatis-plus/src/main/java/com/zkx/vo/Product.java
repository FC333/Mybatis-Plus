package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author DESK0
 * @date 2022/10/18 9:52
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version //标识乐观锁版本号字段
    private Integer version;
}
