package com.koy.dodo.security;

import com.koy.dodo.security.core.DodoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/29
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DodoUserDetailsService dodoUserDetailsService;
//    @Autowired
//    private DodoAccessDeniedHandler dodoAccessDeniedHandler;
    /**
     * security拦截配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 前台页面
                .antMatchers("/index").permitAll()
                // 后台登录
                .antMatchers("/admin/login").permitAll()
                // 静态资源
                .antMatchers("/**/*.js","/**/*.css","/**/*.jpg","/**/*.png").permitAll()
                .antMatchers("/admin/*").authenticated()
                .and()
                .formLogin()
                // 配置自定义登录页面 控制器  以及 处理登录post的表单的路径（即把数据post给security接管）
                .loginPage("/admin/login").loginProcessingUrl("/admin/doLogin")
                //使用这个作为登录成功的页面进行GET跳转，默认跳转到登录前的页面 也可以设置(true)一直跳转到这里
                .defaultSuccessUrl("/admin/index",true)
                // 默认会重定向到根目录，而且是内部转发，因为登录帐号的时候是POST，那边转发的这个request也就是POST，如果接受转发的方法不接受POST那就炸了
                //RequestDispatcher rd = request.getRequestDispatcher("/user/detail").forward( request , response )
//                .successForwardUrl("/user/detail")
                .and().logout().logoutSuccessUrl("/admin/login")
                // 权限不足时的处理
//                .and().exceptionHandling().accessDeniedHandler(dodoAccessDeniedHandler)
                .and()
                .csrf()
                .disable();
    }


    /**
     * 认证以及加密方式配置
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dodoUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
