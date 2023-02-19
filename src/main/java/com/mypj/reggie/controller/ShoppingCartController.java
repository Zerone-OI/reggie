package com.mypj.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mypj.reggie.common.BaseContext;
import com.mypj.reggie.common.R;
import com.mypj.reggie.entity.ShoppingCart;
import com.mypj.reggie.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart) {
        log.info("购物车数据:{}", shoppingCart);

        //获得用户id
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setId(currentId);

        //查询当前菜品或者套餐是否在购物车中
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ShoppingCart::getId, currentId);
        if (dishId == null) {
            //套餐在购物车中
            wrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        } else {
            //菜品在购物车中
            wrapper.eq(ShoppingCart::getDishId, shoppingCart.getDishId());
        }

        ShoppingCart cartServiceOne = shoppingCartService.getOne(wrapper);

        if (cartServiceOne != null) {
            //原先菜品已经存在
            Integer number = cartServiceOne.getNumber();
            cartServiceOne.setNumber(number + 1);
            shoppingCartService.updateById(cartServiceOne);
        } else {
            //如果不存在,添加到购物车,设置数量为1
            cartServiceOne.setNumber(1);
            shoppingCartService.save(cartServiceOne);
            cartServiceOne = shoppingCart;
        }


        return R.success(cartServiceOne);
    }
}
