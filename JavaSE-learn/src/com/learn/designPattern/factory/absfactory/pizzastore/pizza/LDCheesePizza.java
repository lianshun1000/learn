package com.learn.designPattern.factory.absfactory.pizzastore.pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:30 下午
 * @description
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("LDCheesePizza");
        System.out.println("给LDCheesePizza准备原材料");
    }
}
