package com.koy.dodo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.koy.dodo.mapper.UserMapper;
import com.koy.dodo.pojo.UserVO;
import com.koy.dodo.pojo.entity.UserPO;
import com.koy.dodo.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPO login(UserVO userVO) {
        if (!userVO.isLegalParams()) {
            log.warn("login params illegal:{}", userVO);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", userVO.getUsername());
        map.put("password", userVO.getPassword());
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);

        try {
            UserPO userPO = userMapper.selectOne(wrapper);
            if (userPO != null) {
                return userPO;
            }
        } catch (Exception e) {
            log.error("login on find user error:{}", e);
        }

        return null;


    }
}
