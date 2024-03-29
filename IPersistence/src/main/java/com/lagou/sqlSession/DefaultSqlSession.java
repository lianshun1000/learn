package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * @author lianshun
 * @date 2021/7/21 9:56 下午
 * @description
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {
        //将要完成对simpleExecutor里的query方法调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = selectList(statementId, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或返回结果过多");
        }
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理，来为Dao层接口生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            //proxy:当前代理对象的引用
            //method：当前被调用方法的引用
            //args:传递的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //底层都还是去执行JDBC代码，根据不同情况去调用selectList或selectOne

                //1.准备参数：statementId=namespace.id,sql语句的唯一表识  namespace.id=接口全限类名.方法名
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId = className + "." + methodName;

                //准备参数2：params：args
                //获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                System.out.println(genericReturnType.toString());
                //判断是否进行了 泛型类型参数化
                if (genericReturnType instanceof ParameterizedType) {
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                } else if (genericReturnType.toString().equals("int")) {
                    int rows = update(statementId, args);
                    return rows;
                }
                return selectOne(statementId, args);
            }
        });

        return (T) proxyInstance;
    }

    @Override
    public int update(String statement, Object... parameter) throws Exception {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statement);
        int rows = simpleExecutor.update(configuration, mappedStatement, parameter);
        return rows;
    }

    @Override
    public int insert(String statement, Object... parameter) throws Exception {
        return update(statement, parameter);
    }

    @Override
    public int delete(String statement, Object... parameter) throws Exception {
        return update(statement, parameter);
    }
}
