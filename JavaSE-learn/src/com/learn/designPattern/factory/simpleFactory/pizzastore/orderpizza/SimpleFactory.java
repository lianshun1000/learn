package com.learn.designPattern.factory.simpleFactory.pizzastore.orderpizza;

import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.CheesePizza;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.GreekPizza;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:59 下午
 * @description  简单工厂类
 */
public class SimpleFactory {

    //根据orderType返回一个Pizza对象
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("greek");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("cheese");
        }

        return pizza;
    }

    //简单工厂模式也叫静态工厂模式
    public static Pizza createPizza2(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("greek");
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("cheese");
        }

        return pizza;
    }
}
