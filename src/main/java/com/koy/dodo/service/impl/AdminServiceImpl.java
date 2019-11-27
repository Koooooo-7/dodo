package com.koy.dodo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.koy.dodo.common.CommonResult;
import com.koy.dodo.enums.ResultCodeEnums;
import com.koy.dodo.mapper.BannerMapper;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.service.AdminService;
import com.koy.dodo.util.ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        log.info("addBanner service, bannerPO:{}", bannerPO);
        try {
            bannerMapper.insert(bannerPO);
        } catch (Exception e) {
            log.error("addBanner failed, error:{}", e);
        }
    }

    @Override
    public CommonResult bannerList() {
        List<BannerVO> bannerVOS = null;
        try {
            QueryWrapper<BannerPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByAsc("sort");
            List<BannerPO> bannerPOS = bannerMapper.selectList(queryWrapper);
            bannerVOS = ConvertUtil.convertTo(bannerPOS, BannerVO.class);
        } catch (Exception e) {
            log.error("bannerList select error:{}", e);
            return CommonResult.failed(ResultCodeEnums.ACCESS_DATA_FAILED.getCode(), ResultCodeEnums.ACCESS_DATA_FAILED.getDesc());
        }
        return CommonResult.ok(bannerVOS);
    }

    @Override
    public CommonResult editBanner(BannerVO bannerVO) {
        if (!bannerVO.isLegalParamsOnUpdateById()) {
            log.warn("editBanner params illegal:{}", bannerVO);
            return CommonResult.failed(ResultCodeEnums.PARAMS_ILLEGAL.getCode(), ResultCodeEnums.PARAMS_ILLEGAL.getDesc());
        }
        try {
            BannerPO bannerPO = new BannerPO();
            BeanUtils.copyProperties(bannerVO, bannerPO);
            bannerMapper.updateById(bannerPO);
            return CommonResult.ok(null);
        } catch (BeansException e) {
            log.error("updateBanner error:{}", e);
        }
        return CommonResult.failed(ResultCodeEnums.MANIPULATE_DATA_FAILED.getCode(), ResultCodeEnums.MANIPULATE_DATA_FAILED.getDesc());
    }

    @Override
    public CommonResult deleteBanner(String bannerId) {
        bannerMapper.deleteById(bannerId);
        return CommonResult.ok(null);
    }
}
