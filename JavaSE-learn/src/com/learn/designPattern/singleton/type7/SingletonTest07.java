package com.learn.designPattern.singleton.type7;

/**
 * @author lianshun
 * @date 2021/6/26 4:27 下午
 * @description
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        System.out.println("静态内部类");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);  //true
        System.out.println("instance.hashCode()="+instance.hashCode());
        System.out.println("instance2.hashCode()="+instance2.hashCode());
    }
}

class Singleton{

    private static volatile Singleton instance;

    //构造器私有化
    private Singleton(){}

    //写一个静态内部类，该类中有一个静态属性，类型是Singleton
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static  Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
