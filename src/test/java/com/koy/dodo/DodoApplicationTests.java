package com.koy.dodo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.koy.dodo.mapper.BannerMapper;
import com.koy.dodo.mapper.UserMapper;
import com.koy.dodo.pojo.entity.BannerPO;
import com.koy.dodo.pojo.entity.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DodoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BannerMapper bannerMapper;
    @Test
    void testBannerPOinsert(){
        BannerPO bannerPO = new BannerPO();
        bannerPO.setName("test");
        bannerMapper.insert(bannerPO);
    }

    @Test
    void testSql(){
        List<UserPO> userPOS = userMapper.selectList(null);
        System.out.println(userPOS);
    }


}
