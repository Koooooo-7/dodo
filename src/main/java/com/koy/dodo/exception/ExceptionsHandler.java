//package com.koy.dodo.exception;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * @Description
// * @Auther Koy  https://github.com/Koooooo-7
// * @Date 2019/11/23
// */
//@ControllerAdvice
//public class ExceptionsHandler {
//
//
//    @ExceptionHandler(Exception.class)
//    public void handler(HttpServletResponse response){
//        try {
//            response.sendRedirect("/index");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
