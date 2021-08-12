package com.lagou.test;

import com.lagou.mapper.UserMapper;
import com.lagou.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/28 11:43 下午
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringMP {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> all = userMapper.selectList(null);
        for (User user : all) {
            System.out.println(user);
        }
    }
}
