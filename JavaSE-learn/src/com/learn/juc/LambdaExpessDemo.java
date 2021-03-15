package com.learn.juc;

/**
 * 1、函数式编程
 *
 * 拷贝小括号，写死右箭头，落地大括号
 *
 */
public class LambdaExpessDemo {
    public static void main(String[] args) {
        Foo foo = () -> System.out.println("hello");

        foo.sayHello();

    }
}

@FunctionalInterface
interface Foo{
     void sayHello();

     default int  mul(int x,int y){
        return x * y;
    }

     static int  add(int x,int y){
        return x + y;
    }

}
