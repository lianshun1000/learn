package com.lagou.sqlSession;

import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/21 9:55 下午
 * @description
 */
public interface SqlSession {

    //查询所有
    <E> List<E> selectList(String statementId,Object... params) throws Exception;

    //根据条件查询单个
    <T> T selectOne(String statementId,Object... params) throws Exception;

    //为Dao接口生成代理实现类
    <T> T getMapper(Class<?> mapperClass);

    int update(String statement, Object... parameter) throws Exception;

    int insert(String statement, Object... parameter) throws Exception;

    int delete(String statement, Object... parameter) throws Exception;
}
