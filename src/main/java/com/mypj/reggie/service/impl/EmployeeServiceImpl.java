package com.mypj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mypj.reggie.entity.Employee;
import com.mypj.reggie.mapper.EmployeeMapper;
import com.mypj.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author Peilong
 * @create 2023-02-12 22:45
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
