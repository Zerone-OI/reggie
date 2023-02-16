package com.mypj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mypj.reggie.dto.DishDto;
import com.mypj.reggie.entity.Dish;

/**
 * @author Peilong
 * @create 2023-02-14 16:01
 */
public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateByIdWithFlavor(DishDto dishDto);
}
