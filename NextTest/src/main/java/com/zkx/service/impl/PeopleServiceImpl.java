package com.zkx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.mapper.PeopleMapper;
import com.zkx.service.PeopleService;
import com.zkx.vo.People;
import org.springframework.stereotype.Service;

/**
 * @author DESK0
 * @date 2022/12/21 22:37
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {
}
