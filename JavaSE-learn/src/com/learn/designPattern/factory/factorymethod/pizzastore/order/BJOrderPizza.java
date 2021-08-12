package com.learn.designPattern.factory.factorymethod.pizzastore.order;

import com.learn.designPattern.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.learn.designPattern.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

/**
 * @author lianshun
 * @date 2021/6/26 8:59 下午
 * @description
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
