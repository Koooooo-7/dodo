package com.koy.dodo.web.admin.api;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/26
 */
@RestController
@RequestMapping("/admin/api")
@Slf4j
public class AdminApiController {


    @Autowired
    private AdminService adminServiceImpl;
    @Autowired
    private DodoProperties dodoProperties;

    /**
     * Banner列表接口
     * @return
     */
    @RequestMapping("/banner/list")
    public CommonResult bannerList() {
        log.info("access bannerList");
        CommonResult result = adminServiceImpl.bannerList();
        log.info("access BannerList result:{}", result);
        return result;
    }


    /**
     * 添加Banner接口
     * @param bannerVO
     * @return
     */
    @RequestMapping(value = "/banner/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addBanner(BannerVO bannerVO) {
        log.info("addBanner BannerVO:{}",bannerVO);
        MultipartFile file = bannerVO.getFile();
        if (file == null || file.isEmpty()) {
            log.warn("file is empty in BannerVO:{}",bannerVO);
            return CommonResult.failed(ResultCodeEnums.UPLOAD_FILE_FAILED.getCode(),ResultCodeEnums.UPLOAD_FILE_FAILED.getDesc());
        }

        FileVO saveFile = FileUtil.saveFile(file, dodoProperties.getFileStorePath());
        if (saveFile == null){
            log.warn("file upload failed");
            return CommonResult.failed(ResultCodeEnums.UPLOAD_FILE_FAILED.getCode(),ResultCodeEnums.UPLOAD_FILE_FAILED.getDesc());
        }
        BannerPO bannerPO = new BannerPO();
        BeanUtils.copyProperties(bannerVO,bannerPO);
        bannerPO.setSrc(saveFile.getFileSrc());
        adminServiceImpl.addBanner(bannerPO);
        log.info("Controller addBanner success, bannerPO:{}",bannerPO);
        return CommonResult.ok(null);
    }

}
