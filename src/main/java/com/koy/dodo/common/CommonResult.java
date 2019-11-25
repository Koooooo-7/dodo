package com.koy.dodo.common;

import lombok.Data;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@Data
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> CommonResult ok(T data){
        return new CommonResult<T>(0,"success",data);
    }

    public static<T> CommonResult failed(int code,String message){
        return new CommonResult<>(code,message,null);
    }
}
