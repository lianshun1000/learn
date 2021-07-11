package com.learn.designPattern.factory.absfactory.pizzastore.order;



/**
 * @author lianshun
 * @date 2021/6/26 9:01 下午
 * @description
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
