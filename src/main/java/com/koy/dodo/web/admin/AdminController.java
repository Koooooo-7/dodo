package com.koy.dodo.web.admin;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.configuration.properties.DodoProperties;
import com.koy.dodo.enums.ResultCodeEnums;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.FileVO;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.service.AdminService;
import com.koy.dodo.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = "/banner", method = RequestMethod.GET)
    public String banner() {
        return "admin/banner";
    }




}
