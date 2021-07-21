package com.learn.designPattern.builder.improve;


/**
 * @author lianshun
 * @date 2021/7/17 2:32 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //创建指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成建造，返回产品
        House house = houseDirector.constructHouse();
    }
}
