package com.learn.designPattern.factory.absfactory.pizzastore.pizza;


/**
 * @author lianshun
 * @date 2021/6/26 6:30 下午
 * @description
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("LDPepperPizza");
        System.out.println("给LDPepperPizza准备原材料");
    }
}
