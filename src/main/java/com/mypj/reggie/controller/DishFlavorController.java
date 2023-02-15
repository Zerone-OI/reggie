package com.mypj.reggie.controller;

import com.mypj.reggie.service.DishFlavorService;
import com.mypj.reggie.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peilong
 * @create 2023-02-15 16:05
 */
@RestController
@RequestMapping("/dish")
public class DishFlavorController {
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private DishService dishService;
}
