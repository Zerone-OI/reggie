package com.mypj.reggie.common;

/**
 * @author Peilong
 * @create 2023-02-14 12:40
 */

/**
 * 基于ThreadLocal封装工具类,用于记录和更新当前用户保存的id
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId (Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId (){
        return threadLocal.get();
    }

}
