package com.learn.designPattern.singleton.type2;

/**
 * @author lianshun
 * @date 2021/6/26 4:08 下午
 * @description
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);  //true
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton{
     //1、构造器私有化，防止new
    private Singleton(){

    }

    //2、本类内部创建对象实例
    private static Singleton instance;

    static {//在静态代码块中创建单例对象
        instance = new Singleton();
    }

    //3、提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
