package com.lagou.test;


import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/28 10:41 下午
 * @description
 */
public class MPTest {

    @Test
    public void mybatisTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        List<User> users1 = mapper.selectList(null);
        for (User user : users1) {
            System.out.println(user);
        }

        sqlSession.close();

    }
}
