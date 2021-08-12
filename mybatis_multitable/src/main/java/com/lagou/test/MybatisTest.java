package com.lagou.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.mapper.IOrderMapper;
import com.lagou.mapper.IUserMapper;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.Order;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/22 11:22 下午
 * @description
 */
public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //Resources工具类，将配置文件加载为字节流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析配置文件，生产SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //生产SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是不会自动提交，所以在进行增删改操作时，需要手动提交
        IOrderMapper orderMapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orders = orderMapper.findOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //Resources工具类，将配置文件加载为字节流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析配置文件，生产SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //生产SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是不会自动提交，所以在进行增删改操作时，需要手动提交
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public void test3() throws IOException {
        //Resources工具类，将配置文件加载为字节流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析配置文件，生产SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //生产SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是不会自动提交，所以在进行增删改操作时，需要手动提交
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        List<User> users = userMapper.findAllUserAndRole();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    private IUserMapper userMapper;
    private IOrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("练顺");
        user.setPassword("1234");
        user.setBirthday(new Date());
        userMapper.addUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("刘颖");
        user.setPassword("1234");
        user.setBirthday(new Date());
        userMapper.updateUser(user);
    }

    @Test
    public void selectUser() {
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUser(3);
    }

    @Test
    public void onToOne() {
        List<Order> orderAndUser = orderMapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }
    }

    @Test
    public void onToMany() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void manyToMany() {
        List<User> users = userMapper.findAllUserAndRole();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void pageHelperTest() {
        PageHelper.startPage(1, 1);
        List<User> list = userMapper.selectUser();
        for (User user : list) {
            System.out.println(user);
        }
        PageInfo<User> userPageInfo = new PageInfo<>(list);
        System.out.println("总条数" + userPageInfo.getTotal());
        System.out.println("总页数" + userPageInfo.getPages());
        System.out.println("当前页" + userPageInfo.getPageNum());
        System.out.println("每页条数" + userPageInfo.getPageSize());
    }


    @Test
    public void mapperTest() throws IOException {
        //Resources工具类，将配置文件加载为字节流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //解析配置文件，生产SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //生产SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启一个事务，但是不会自动提交，所以在进行增删改操作时，需要手动提交
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setId(1);
        User user = userMapper.selectOne(user1);
        System.out.println(user);


        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", 1);
        List<User> users = userMapper.selectByExample(example);
        for (User user2 : users) {
            System.out.println(user2);
        }

        sqlSession.close();
    }
}
