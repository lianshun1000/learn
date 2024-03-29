package com.learn.designPattern.bridge;

/**
 * @author lianshun
 * @date 2021/7/17 7:32 下午
 * @description
 */
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println("小米开机");
    }

    @Override
    public void close() {
        System.out.println("小米关机");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }
}
