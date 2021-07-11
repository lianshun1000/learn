package com.learn.designPattern.factory.simpleFactory.pizzastore.orderpizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:38 下午
 * @description   发出订购
 */
public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza();

        //使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("退出程序");
    }
}
