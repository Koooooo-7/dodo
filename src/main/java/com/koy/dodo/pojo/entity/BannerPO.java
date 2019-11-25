package com.koy.dodo.pojo.entity;

import com.koy.dodo.enums.SortEnums;
import com.koy.dodo.enums.StatusEnums;
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
public class BannerPO extends BaseEntity {

    private String name;
    private String src;
    private SortEnums sort;
    private StatusEnums status;


}
