package com.koy.dodo.security.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.koy.dodo.mapper.UserMapper;
import com.koy.dodo.pojo.entity.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/29
 */
@Component
@Slf4j
public class DodoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        UserPO userPO = null;
        try {
            userPO = userMapper.selectOne(wrapper);
        } catch (Exception e) {
            log.error("loadUserByUsername selectOne not one User error:{}", e);
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        if (userPO == null){
            log.warn("loadUserByUsername selectOne User is null, username:{}", username);
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // TODO: START 需要对admin密码进行加密存储到数据库，现在先反向加密一次
        String password = userPO.getPassword();
        userPO.setPassword(passwordEncoder.encode(password));
        // TODO: END
        return new DodoUserDetails(userPO);
    }
}
