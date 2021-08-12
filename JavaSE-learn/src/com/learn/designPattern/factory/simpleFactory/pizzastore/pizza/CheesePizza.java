package com.learn.designPattern.factory.simpleFactory.pizzastore.pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:30 下午
 * @description
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作CheesePizza准备原材料");
    }
}
