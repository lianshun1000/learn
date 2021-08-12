package com.learn.designPattern.principle.singlereponsibility;

public class SingleResponsbility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();

        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        airVehicle.run("飞机");
    }
}

//方案二遵守了单一职责原则
//但是开销很大，即将类分解，同时修改客户端
//改进：直接修改Vehicle类，改动会比较少
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水中运行");
    }
}