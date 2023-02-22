package com.zkx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.mapper.ProductMapper;
import com.zkx.mapper.UserMapper;
import com.zkx.service.ProductService;
import com.zkx.service.UserService;
import com.zkx.vo.Product;
import com.zkx.vo.User;
import org.springframework.stereotype.Service;

/**
 * @author Ori
 * @date 2022/3/10-18:56
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
