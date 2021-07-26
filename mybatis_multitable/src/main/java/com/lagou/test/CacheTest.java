package com.lagou.test;

import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author lianshun
 * @date 2021/7/24 12:07 下午
 * @description
 */
public class CacheTest {

    private IUserMapper userMapper;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @Test
    public void firstLevelCache(){
        //第一次查询id为1的用户
        //首先去一级缓存中查询，有则返回，没有则查询数据库，同时将查询出来的结果放到一级缓存中
        User user1 = userMapper.findUserById(1);

        //更新用户
        //做增删改操作，并进行了事务提交，就是刷新一级缓存
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        user.setBirthday(new Date());
        user.setPassword("14223");
        userMapper.updateUser(user);
        sqlSession.commit();

        //手动清空一级缓存
        sqlSession.clearCache();

        //第二次查询id为1的用户
        //首先去一级缓存中查询，有则返回，没有则查询数据库，同时将查询出来的结果放到一级缓存中
        User user2 = userMapper.findUserById(1);

        System.out.println(user1 == user2);
    }


    @Test
    public void secondLevelCache(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper mapper3 = sqlSession3.getMapper(IUserMapper.class);

        User user1 = mapper1.findUserById(1);
        sqlSession1.close();//清空一级缓存


        User user = new User();
        user.setId(1);
        user.setUsername("tom1");
        user.setBirthday(new Date());
        user.setPassword("hhhh");
        mapper3.updateUser(user);
        sqlSession3.commit();//清空二级缓存

        User user2 = mapper2.findUserById(1);

        //二级缓存不是缓存的一个结果对象，而是查询结果数据，所以每次获取会封装为一个新的对象
        System.out.println(user1 == user2);
    }
}
