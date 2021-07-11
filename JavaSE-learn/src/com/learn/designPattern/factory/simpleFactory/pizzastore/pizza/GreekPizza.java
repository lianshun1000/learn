package com.learn.designPattern.factory.simpleFactory.pizzastore.pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:31 下午
 * @description
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给制作GreekPizza准备原材料");
    }
}
