package com.koy.dodo.web.portal.api;

import com.koy.dodo.common.CommonResult;
import com.koy.dodo.pojo.ContactVO;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/12/28
 */
@RestController
@RequestMapping("/portal/api/contact")
public class ContactController {


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult addContact(@RequestBody ContactVO contactVO){
        return CommonResult.ok(null);
    }
}
