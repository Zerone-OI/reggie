package com.mypj.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mypj.reggie.dto.SetmealDto;
import com.mypj.reggie.entity.Setmeal;
import com.mypj.reggie.entity.SetmealDish;
import com.mypj.reggie.mapper.SetmealMapper;
import com.mypj.reggie.service.SetmealDishService;
import com.mypj.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peilong
 * @create 2023-02-14 16:03
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐,同时保存套餐和菜品的关联关系
     *
     * @param setmealDto
     */
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息
        this.save(setmealDto);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //保存套餐信息的关联信息
        setmealDishService.saveBatch(setmealDishes);

    }
}
