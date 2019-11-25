package com.koy.dodo.web.admin;

import com.koy.dodo.configuration.properties.DodoProperties;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.FileVO;
import com.koy.dodo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class AdminController {
    @Autowired
    private DodoProperties dodoProperties;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        System.out.println(dodoProperties.getFileStorePath());
        return "admin/index";
    }

    @RequestMapping(value = "/banner", method = RequestMethod.GET)
    public String banner() {
        return "admin/banner";
    }


    @RequestMapping(value = "/addBanner", method = RequestMethod.POST)
    public String addBanner(MultipartFile file, HttpServletRequest request,BannerVO bannerVO) {

        if (file == null || file.isEmpty()) {
            request.getSession().setAttribute("banner_upload_msg", "文件不能为空！");
            return "admin/banner";
        }

        FileVO saveFile = FileUtil.saveFile(file, dodoProperties.getFileStorePath());
        if (saveFile == null){
            request.getSession().setAttribute("banner_upload_msg", "上传文件失败");
            return "admin/banner";
        }

        return "redirect:/admin/banner";
    }


}
