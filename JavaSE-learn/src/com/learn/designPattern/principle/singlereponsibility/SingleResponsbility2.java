package com.learn.designPattern.principle.singlereponsibility;

public class SingleResponsbility2 {
}

class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在天空运行");
    }
}

class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在水中运行");
    }
}