package com.learn.designPattern.factory.absfactory.pizzastore.pizza;


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
