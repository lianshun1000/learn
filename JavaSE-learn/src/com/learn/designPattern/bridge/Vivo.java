package com.learn.designPattern.bridge;

/**
 * @author lianshun
 * @date 2021/7/17 7:32 下午
 * @description
 */
public class Vivo implements Brand {

    @Override
    public void open() {
        System.out.println("vivo开机");
    }

    @Override
    public void close() {
        System.out.println("vivo关机");
    }

    @Override
    public void call() {
        System.out.println("vivo打电话");
    }
}
