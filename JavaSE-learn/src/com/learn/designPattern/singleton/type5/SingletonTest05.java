package com.learn.designPattern.singleton.type5;

/**
 * @author lianshun
 * @date 2021/6/26 4:27 下午
 * @description
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        System.out.println("懒汉式3,同步代码快");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);  //true
        System.out.println("instance.hashCode()="+instance.hashCode());
        System.out.println("instance2.hashCode()="+instance2.hashCode());
    }
}

class Singleton{
    private static Singleton instance;

    private Singleton(){}

    //提供一个静态的公有方法，加入同步处理的方法，解决线程安全问题
    //即懒汉式

    public static  Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
