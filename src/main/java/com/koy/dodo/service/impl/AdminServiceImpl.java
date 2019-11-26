package com.koy.dodo.service.impl;

import com.koy.dodo.mapper.BannerMapper;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/25
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public void addBanner(BannerPO bannerPO) {
        log.info("addBanner service, bannerPO:{}",bannerPO);
        try {
            bannerMapper.insert(bannerPO);
        } catch (Exception e) {
            log.error("addBanner failed, error:{}",e);
        }
    }
}
