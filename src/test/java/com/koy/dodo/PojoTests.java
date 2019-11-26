package com.koy.dodo;

import com.koy.dodo.mapper.BannerMapper;
import com.koy.dodo.pojo.BannerVO;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.pojo.entity.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Auther Koy  https://github.com/Koooooo-7
 * @Date 2019/11/23
 */
public class PojoTests {

    @Test
    public void testPO(){
        UserPO userPO = new UserPO();
        System.out.println(userPO);
    }

    @Test
    public void testPO2(){
        BannerVO bannerVO = new BannerVO();
        bannerVO.setName("name");
        bannerVO.setSort(1);
        bannerVO.setStatus(0);
        BannerPO bannerPO = new BannerPO();
        BeanUtils.copyProperties(bannerVO,bannerPO);
        System.out.println(bannerPO);
    }


}
