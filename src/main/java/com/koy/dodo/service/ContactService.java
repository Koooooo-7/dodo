package com.koy.dodo.service;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.pojo.ContactVO;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/12/29
 */
public interface ContactService {
    CommonResult add(ContactVO contactVO);
}
