package com.lagou.sqlSession;

/**
 * @author lianshun
 * @date 2021/7/21 9:08 下午
 * @description
 */
public interface SqlSessionFactory {

    public SqlSession openSession();
}
