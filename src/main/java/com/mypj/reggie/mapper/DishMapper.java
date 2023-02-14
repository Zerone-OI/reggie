package com.mypj.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypj.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Peilong
 * @create 2023-02-14 16:05
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
