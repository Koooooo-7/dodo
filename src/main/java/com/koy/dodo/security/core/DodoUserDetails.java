package com.koy.dodo.security.core;

import com.koy.dodo.pojo.entity.UserPO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/29
 */
public class DodoUserDetails implements UserDetails {

    private UserPO userPO;

    public DodoUserDetails(UserPO userPO) {
        this.userPO = userPO;
    }

    // 目前没有权限分配
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPO.getPassword();
    }

    @Override
    public String getUsername() {
        return userPO.getUsername();
    }


    // UserPO不为空则帐号肯定存在
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 暂时没有封禁用户功能，所以用户都没有封禁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 延签目前没有有效期一说
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 目前没有用户注销类似功能
    @Override
    public boolean isEnabled() {
        return true;
    }

}
