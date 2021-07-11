package com.learn.designPattern.factory.absfactory.pizzastore.order;


import com.learn.designPattern.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.learn.designPattern.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.learn.designPattern.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author lianshun
 * @date 2021/6/27 1:21 下午
 * @description
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
