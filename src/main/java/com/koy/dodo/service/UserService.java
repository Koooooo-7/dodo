package com.koy.dodo.service;

import com.koy.dodo.pojo.UserVO;
import com.koy.dodo.pojo.entity.UserPO;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
public interface UserService {

   UserPO login(UserVO userVO);
}
