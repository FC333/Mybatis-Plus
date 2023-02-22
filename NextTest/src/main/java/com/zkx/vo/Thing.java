package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author DESK0
 * @date 2022/12/21 22:20
 */
@Data
public class Thing {
    private Integer id;
    private String name;
    private Integer balance;
    @Version
    private Integer version;
}
