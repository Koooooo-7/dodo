package com.koy.dodo.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@TableName(value = "banner",keepGlobalPrefix = true)
public class BannerPO extends BaseEntity {

    private String name;
    private String src;
    private int sort;
    @TableLogic
    private int status;


}
