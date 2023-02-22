package com.zkx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.mapper.UserMapper;
import com.zkx.service.UserService;
import com.zkx.vo.User;
import org.springframework.stereotype.Service;

/**
 * @author Ori
 * @date 2022/3/10-18:56
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
