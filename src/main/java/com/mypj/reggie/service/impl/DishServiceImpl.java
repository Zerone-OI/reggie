package com.mypj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mypj.reggie.entity.Dish;
import com.mypj.reggie.mapper.DishMapper;
import com.mypj.reggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author Peilong
 * @create 2023-02-14 16:03
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
