package com.koy.dodo.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
@Data
@ToString
public class BannerVO {

    @TableField(insertStrategy = FieldStrategy.NEVER)
    private Long id;
    private String name;
    private int sort;
    private int status;
    @JsonIgnore
    private MultipartFile file;

}
