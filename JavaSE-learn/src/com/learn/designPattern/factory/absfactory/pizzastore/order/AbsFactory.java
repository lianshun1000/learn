package com.learn.designPattern.factory.absfactory.pizzastore.order;

import com.learn.designPattern.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author lianshun
 * @date 2021/6/27 1:19 下午
 * @description   抽象工厂模式的抽象层
 */
public interface AbsFactory {
    //工厂子类具体实现
     Pizza createPizza(String orderType);
}
