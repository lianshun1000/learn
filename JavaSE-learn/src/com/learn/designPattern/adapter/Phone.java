package com.learn.designPattern.adapter;

/**
 * @author lianshun
 * @date 2021/7/17 4:14 下午
 * @description
 */
public class Phone {
    public void charging(Voltage5V v) {
        if (v.output5V() == 5) {
            System.out.println("可以充电");
        } else {
            System.out.println("炸了");
        }
    }
}
