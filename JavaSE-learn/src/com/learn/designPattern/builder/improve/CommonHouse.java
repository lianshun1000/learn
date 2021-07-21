package com.learn.designPattern.builder.improve;

/**
 * @author lianshun
 * @date 2021/7/17 3:00 下午
 * @description
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙10米");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子盖屋顶");
    }
}
