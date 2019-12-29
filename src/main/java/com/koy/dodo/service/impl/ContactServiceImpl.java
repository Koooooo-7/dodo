package com.koy.dodo.service.impl;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.enums.ResultCodeEnums;
import com.koy.dodo.mapper.ContactMapper;
import com.koy.dodo.pojo.ContactVO;
import com.koy.dodo.pojo.entity.ContactPO;
import com.koy.dodo.service.ContactService;
import com.koy.dodo.util.ConvertUtil;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/12/29
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;
    @Override
    public CommonResult add(ContactVO contactVO) {
        if (!contactVO.isParamsLegal()){
            return CommonResult.failed(ResultCodeEnums.PARAMS_ILLEGAL.getCode(),ResultCodeEnums.PARAMS_ILLEGAL.getDesc());
        }
        ContactPO contactPO = new ContactPO();
        BeanUtils.copyProperties(contactVO,contactPO);
        contactMapper.insert(contactPO);
        return CommonResult.ok(null);
    }
}
