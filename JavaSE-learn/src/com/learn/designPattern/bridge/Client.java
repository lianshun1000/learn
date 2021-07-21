package com.learn.designPattern.bridge;

/**
 * @author lianshun
 * @date 2021/7/17 7:39 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        Phone p1 = new FoldedPhone(new XiaoMi());
        p1.open();
        p1.call();
        p1.close();
    }
}
