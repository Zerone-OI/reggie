package com.mypj.reggie.common;

/**
 * @author Peilong
 * @create 2023-02-14 16:18
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
