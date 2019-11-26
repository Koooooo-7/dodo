package com.koy.dodo.web.portal;

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

    /***
     * 前台默认index页面路由
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String portal() {
        return "redirect:/index";
    }
    /***
     * 前台index页面路由
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "portal/index";
    }
}
