package com.mypj.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mypj.reggie.common.BusinessException;
import com.mypj.reggie.entity.Category;
import com.mypj.reggie.entity.Dish;
import com.mypj.reggie.entity.Setmeal;
import com.mypj.reggie.mapper.CategoryMapper;
import com.mypj.reggie.service.CategoryService;
import com.mypj.reggie.service.DishService;
import com.mypj.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Peilong
 * @create 2023-02-14 13:28
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        if (count1 > 0){
            //抛出业务异常
            throw new BusinessException("已关联菜品,不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);

        if (count2 > 0){
            //抛出业务异常
            throw new BusinessException("已关联套餐,不能删除");
        }

        super.removeById(id);


    }
}
