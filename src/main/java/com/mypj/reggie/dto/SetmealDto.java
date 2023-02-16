package com.mypj.reggie.dto;


import com.mypj.reggie.entity.Setmeal;
import com.mypj.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
