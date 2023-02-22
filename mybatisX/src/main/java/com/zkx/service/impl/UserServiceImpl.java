package com.zkx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.vo.User;
import com.zkx.service.UserService;
import com.zkx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author DESK0
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-12-15 21:57:47
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




