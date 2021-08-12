package com.learn.reflect.test;

import com.learn.reflect.impl.testforClassImpl;
import com.learn.reflect.inter.testforClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ServiceLoader;

public class test {
    public static void main(String[] args) throws Exception {
        /*Class interfaceImpl = testforClass.class;
        Object instance = Proxy.newProxyInstance(interfaceImpl.getClassLoader(),
                new Class[] { interfaceImpl }, new workHandler(interfaceImpl));
        // 反射 获取方法
        System.out.println(instance.getClass().);
        Method method = instance.getClass().getMethod("test");
        //使用
        System.out.println(method);*/

        ServiceLoader<testforClass> tst = ServiceLoader.load(testforClass.class);
        System.out.println(tst);
        for (testforClass testforClass : tst) {
            testforClass.test();
        }

    }
}
