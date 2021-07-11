package com.learn.designPattern.factory.factorymethod.pizzastore.pizza;

import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:30 下午
 * @description
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("BJPepperPizza");
        System.out.println("给北京BJPepperPizza准备原材料");
    }
}
