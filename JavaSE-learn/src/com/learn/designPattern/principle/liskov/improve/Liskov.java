package com.learn.designPattern.principle.liskov.improve;

//里氏原则
//无意修改了父类的方法，导致程序错误
//解决方法：原来的父类和子类都继承一个更基础的类，去除原有继承关系，采用依赖，聚合，组合关系替代
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("----------------------------");

        B b = new B();
        System.out.println("11+3=" + b.func1(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

//创建一个更基础的类
class Base {

}

class A extends Base {
    //两数相减
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {
    private A a = new A();

    //两数相加
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    //使用A的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}