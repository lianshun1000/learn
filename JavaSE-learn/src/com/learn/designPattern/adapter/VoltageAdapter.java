package com.learn.designPattern.adapter;

/**
 * @author lianshun
 * @date 2021/7/17 4:13 下午
 * @description 适配器类
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int src = output220V();
        int dstV = src / 44;
        return dstV;
    }
}
