package com.learn.designPattern.builder.improve;

/**
 * @author lianshun
 * @date 2021/7/17 3:00 下午
 * @description
 */
public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙20米");
    }

    @Override
    public void roofed() {
        System.out.println("高楼盖屋顶");
    }
}
