package com.learn.designPattern.builder.improve;

/**
 * @author lianshun
 * @date 2021/7/17 2:55 下午
 * @description
 */

//产品 =》 Product
public class House {
    private String basic;
    private String wall;
    private String roofed;

    public String getBasic() {
        return basic;
    }

    public String getWall() {
        return wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
