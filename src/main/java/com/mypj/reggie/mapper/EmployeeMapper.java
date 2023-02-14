package com.mypj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypj.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Peilong
 * @create 2023-02-12 22:42
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
