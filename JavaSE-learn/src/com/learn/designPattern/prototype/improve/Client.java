package com.learn.designPattern.prototype.improve;

/**
 * @author lianshun
 * @date 2021/7/11 1:57 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式对对象的克隆");
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
    }
}
