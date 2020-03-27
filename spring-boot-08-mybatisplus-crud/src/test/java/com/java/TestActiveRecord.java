package com.java;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.mapper.UserMapper;
import com.java.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class TestActiveRecord {

    @Test
    void testAR1(){
        User user = new User();
        user.setName("huangzhen");
        user.setUserName("黄振");
        user.setMail("617192837@qq.com");
        user.setPassword("1222223");

        boolean b = user.insert();
        System.out.println(b);
    }

    @Test
    void testAR2(){
        User user = new User();
        user.setId(11);

        User user1 = user.selectById();
        System.out.println(user1);
    }


    @Test
    void testAR3(){
        User user = new User();
        user.setId(7);
        user.setPassword("aaaa@hnu");
        user.setVersion(1);

        boolean b = user.updateById();
        System.out.println(b);
    }

    @Test
    void testAr4(){
        User user = new User();
        user.setId(13);
        boolean b = user.deleteById();
        System.out.println(b);
    }

    @Test
    void testSqlExplainInterceptor(){
        User user = new User();

        user.setAge(13);
        boolean b = user.update(null);
        System.out.println(b);
    }

}
