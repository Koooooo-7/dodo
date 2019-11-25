package com.koy.dodo.enums;

import lombok.AllArgsConstructor;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@AllArgsConstructor
public enum  ResultCodeEnums {

    USER_NOT_EXIST(100404,"帐号或者密码错误");
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
