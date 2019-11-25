package com.koy.dodo.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
public enum SortEnums implements IEnum {

    FIRST(1,"排序：第一个"),
    SECOND(2,"排序：第一个"),
    THIRD(3,"排序：第一个"),
    ;
    private int sort;
    private String desc;

    SortEnums(int sort, String desc) {
        this.sort = sort;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.sort;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
