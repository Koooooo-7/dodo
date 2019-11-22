package com.koy.dodo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/22
 */
@Controller
@RequestMapping("/")
public class PortalController {


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "portal/index";
    }
}
