package com.learn.designPattern.adapter.objectAdapter;

/**
 * @author lianshun
 * @date 2021/7/17 4:13 下午
 * @description 适配器类
 */
public class VoltageAdapter implements Voltage5V {
    private Voltage220V v;

    public VoltageAdapter(Voltage220V v) {
        this.v = v;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != v) {
            int src = v.output220V();
            dst = src / 44;
            System.out.println("适配完成");
        }
        return dst;
    }
}
