package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;

import java.util.Collections;

/**
 * @author lianshun
 * @date 2021/7/21 9:47 下午
 * @description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
