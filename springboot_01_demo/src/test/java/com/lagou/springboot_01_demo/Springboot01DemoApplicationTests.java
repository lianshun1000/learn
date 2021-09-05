package com.lagou.springboot_01_demo;

import com.lagou.config.JdbcConfiguration;
import com.lagou.pojo.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot01DemoApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private JdbcConfiguration jdbcConfiguration;

    @Autowired
    private DataSource dataSource;


    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void test1(){
        System.out.println(jdbcConfiguration);
        System.out.println(dataSource);
    }

}
