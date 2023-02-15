package com.mypj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mypj.reggie.dto.DishDto;
import com.mypj.reggie.entity.Dish;
import com.mypj.reggie.entity.DishFlavor;
import com.mypj.reggie.mapper.DishMapper;
import com.mypj.reggie.service.DishFlavorService;
import com.mypj.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peilong
 * @create 2023-02-14 16:03
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品,同事保存口味数据
     * @param dishDto
     */
    //由于对多个表进行操作所以需要加入事务控制
    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto){
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);

        //菜品id
        Long dishId = dishDto.getId();

        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        //stream流
        flavors = flavors.stream().map((item)->{
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }
}
