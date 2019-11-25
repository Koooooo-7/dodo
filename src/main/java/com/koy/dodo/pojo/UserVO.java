package com.koy.dodo.pojo;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/22
 */

@Data
@ToString
public class UserVO {
    private String username;
    private String password;

    public boolean isLegalParams(){
        return StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password);
    }

}
