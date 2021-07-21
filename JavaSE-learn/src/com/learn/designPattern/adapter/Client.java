package com.learn.designPattern.adapter;

/**
 * @author lianshun
 * @date 2021/7/17 4:16 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
