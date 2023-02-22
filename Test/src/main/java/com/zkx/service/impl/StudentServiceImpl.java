package com.zkx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkx.mapper.StudentMapper;
import com.zkx.service.StudentService;
import com.zkx.vo.Student;
import org.springframework.stereotype.Service;

/**
 * @author DESK0
 * @date 2022/12/21 17:57
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
