package com.zkx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.mapper.UserMapper;
import com.zkx.service.UserService;
import com.zkx.vo.User;
import org.springframework.stereotype.Service;

/**
 * Created by DESK0 on 2022/10/17 4:58
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
