package com.learn.reflect.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class workHandler implements InvocationHandler {
    //代理类中的真实对象
    private Object obj;

    public workHandler() {
        // TODO Auto-generated constructor stub
    }
    //构造函数，给我们的真实对象赋值
    public workHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实的对象执行之前我们可以添加自己的操作
        System.out.println(obj);
        Object invoke = method.invoke(obj, args);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
    }
}
