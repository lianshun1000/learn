package com.learn.designPattern.prototype.improve;

/**
 * @author lianshun
 * @date 2021/7/11 1:31 下午
 * @description
 */
public class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                '}';
    }

    //克隆该实例，使用默认的clone方法来完成
    @Override
    protected Object clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
