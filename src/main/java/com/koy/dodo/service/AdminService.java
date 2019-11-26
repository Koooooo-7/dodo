package com.koy.dodo.service;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.UserVO;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.pojo.entity.UserPO;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
public interface AdminService {

    /**
     * 添加Banner
     * @param bannerPO
     */
    void addBanner(BannerPO bannerPO);

    /**
     * Banner列表
     */
    CommonResult bannerList();
}
