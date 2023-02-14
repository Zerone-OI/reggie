package com.mypj.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mypj.reggie.entity.Category;

/**
 * @author Peilong
 * @create 2023-02-14 13:27
 */
public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
