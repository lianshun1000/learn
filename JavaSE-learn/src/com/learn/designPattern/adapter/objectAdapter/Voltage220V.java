package com.learn.designPattern.adapter.objectAdapter;

/**
 * @author lianshun
 * @date 2021/7/17 4:11 下午
 * @description
 */
public class Voltage220V {
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "V");
        return src;
    }
}
