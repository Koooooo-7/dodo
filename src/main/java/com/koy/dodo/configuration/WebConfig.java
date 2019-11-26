package com.koy.dodo.configuration;

import com.koy.dodo.security.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 登录拦截器配置
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/admin/*/**")
                .excludePathPatterns("/admin/doLogin","/admin/login","/admin/");
    }
}
