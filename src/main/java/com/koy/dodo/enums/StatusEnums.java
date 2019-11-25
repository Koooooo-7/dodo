package com.koy.dodo.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
public enum  StatusEnums implements IEnum {

    DELEATE(1,"删除");

    StatusEnums(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;

    @Override
    public Serializable getValue() {
        return this.status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
