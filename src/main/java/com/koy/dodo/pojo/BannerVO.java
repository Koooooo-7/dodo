package com.koy.dodo.pojo;

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
    private String name;
    private int sort;
    private int status;
    private MultipartFile file;

}
