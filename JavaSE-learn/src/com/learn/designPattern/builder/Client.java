package com.learn.designPattern.builder;

/**
 * @author lianshun
 * @date 2021/7/17 2:32 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
