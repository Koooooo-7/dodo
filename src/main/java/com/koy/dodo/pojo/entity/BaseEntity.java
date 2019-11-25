package com.koy.dodo.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@Data
@ToString
public class BaseEntity {
    private Long id;
    private Long created_time;
    private Long updated_time;
    private Date created_by;
    @TableField(fill = FieldFill.UPDATE)
    private Date updated_by;
}
