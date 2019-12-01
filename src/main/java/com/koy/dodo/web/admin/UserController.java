package com.koy.dodo.web.admin;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.enums.ResultCodeEnums;
import com.koy.dodo.pojo.UserVO;
import com.koy.dodo.pojo.entity.UserPO;
import com.koy.dodo.security.core.DodoUserDetailsService;
import com.koy.dodo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/22
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class UserController {


    @Autowired
    private UserService userServiceImpl;

    /**
     * 登录默认根路径
     * @return
     */
    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public String index(){
        return "redirect:/admin/login";
    }
    /**
     * 登录默认index路径
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String login(HttpServletRequest request)
    {
//        if (request.getSession().getAttribute("username") != null){
//            return "redirect:/admin/index";
//        }

        return "/admin/login";
    }

//    /**
//     * 登录认证逻辑
//     * @return
//     */
//    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
//    public String doLogin(UserVO userVO,HttpServletRequest request){
//        log.info("doLogin,user:{}",userVO);
//        UserPO userPO = userServiceImpl.login(userVO);
//        HttpSession session = request.getSession();
//        if (userPO == null){
//            log.warn("user not exist user:{}",userVO);
//            session.setAttribute("adminLoginMsg", ResultCodeEnums.USER_NOT_EXIST.getDesc());
//            return "/admin/login";
//        }
//
//        session.setAttribute("username",userPO.getUsername());
//        log.info("doLogin success,user:{}",userPO);
//        return "redirect:/admin/index";
//    }
}
