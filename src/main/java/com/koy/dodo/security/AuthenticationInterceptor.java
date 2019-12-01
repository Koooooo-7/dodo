//package com.koy.dodo.security;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * @Description
// * @Auther Koy  https://github.com/Koooooo-7
// * @Date 2019/11/23
// */
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getSession().getAttribute("username") == null){
//            request.getSession().setAttribute("adminLoginMsg","您尚未登录");
//            response.sendRedirect("/admin/login");
//            return false;
//        }
//        return true;
//    }
//}
