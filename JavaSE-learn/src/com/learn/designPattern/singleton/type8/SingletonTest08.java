package com.learn.designPattern.singleton.type8;

/**
 * @author lianshun
 * @date 2021/6/26 5:17 下午
 * @description
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);  //true
        System.out.println("instance.hashCode()=" + instance.hashCode());
        System.out.println("instance2.hashCode()=" + instance2.hashCode());

        instance.sayOK();
    }
}

//使用枚举可以实现单例
enum Singleton {
    INSTANCE;

    public void sayOK() {
        System.out.println("OK~~");
    }
}
