package com.learn.designPattern.principle.singlereponsibility;

public class SingleResponsbility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类
//方式一
//在run方法中违反了单一职责，可以根据不同交通工具的运行方法，分解成不同的类
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行");
    }
}