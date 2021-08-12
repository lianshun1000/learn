package com.lagou.plugin;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author lianshun
 * @date 2021/7/24 5:42 下午
 * @description
 */
@Intercepts({
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class})
})
public class MyPlugin implements Interceptor {
    @Override
    //拦截方法：只要被拦截的目标对象方法被执行时，每次都会执行intercept方法
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("对方法进行了增强");
        return invocation.proceed();//原方法执行
    }

    @Override
    //主要为了把当前的拦截器生成代理对象存到拦截器链中
    public Object plugin(Object o) {
        Object wrap = Plugin.wrap(o, this);
        return wrap;
    }

    @Override
    //获取配置文件的参数
    public void setProperties(Properties properties) {
        System.out.println("获取到的配置文件的参数：" + properties);
    }
}
