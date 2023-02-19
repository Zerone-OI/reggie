package com.mypj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mypj.reggie.dto.SetmealDto;
import com.mypj.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author Peilong
 * @create 2023-02-14 16:01
 */
public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);

    public void deleteWithDish(List<Long> ids);
}
