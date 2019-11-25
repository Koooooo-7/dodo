package com.koy.dodo;

import com.koy.dodo.pojo.entity.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
