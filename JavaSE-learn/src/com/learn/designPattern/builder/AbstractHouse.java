package com.learn.designPattern.builder;

/**
 * @author lianshun
 * @date 2021/7/17 2:30 下午
 * @description
 */
public abstract class AbstractHouse {
    public abstract void buildBasic();

    public abstract void buildWall();

    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWall();
        roofed();
    }
}
