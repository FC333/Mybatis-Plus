package com.zkx.vo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author DESK0
 * @date 2022/12/21 17:59
 */
@Data
public class Teacher {
    private Integer id;
    private Integer balance;
    @Version
    private Integer version;
}
