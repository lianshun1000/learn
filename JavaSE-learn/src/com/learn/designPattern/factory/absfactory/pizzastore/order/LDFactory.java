package com.learn.designPattern.factory.absfactory.pizzastore.order;


import com.learn.designPattern.factory.absfactory.pizzastore.pizza.*;

/**
 * @author lianshun
 * @date 2021/6/27 1:21 下午
 * @description
 */
public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
