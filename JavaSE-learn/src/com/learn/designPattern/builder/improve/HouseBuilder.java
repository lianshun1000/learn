package com.learn.designPattern.builder.improve;

/**
 * @author lianshun
 * @date 2021/7/17 2:57 下午
 * @description 抽象的建造者
 */
public abstract class HouseBuilder {
    protected House house = new House();

    //将建造的流程写好
    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public House buildHouse() {
        return house;
    }
}
