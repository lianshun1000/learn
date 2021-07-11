package com.learn.designPattern.factory.absfactory.pizzastore.order;

import com.learn.designPattern.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lianshun
 * @date 2021/6/27 1:27 下午
 * @description
 */
public class OrderPizza{
    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory){
        setAbsFactory(absFactory);
    }

    private void setAbsFactory(AbsFactory absFactory){
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = absFactory;

        do {
           orderType = getType();
           pizza = absFactory.createPizza(orderType);

           if(pizza != null){
               pizza.prepare();
               pizza.bake();
               pizza.cut();
               pizza.box();
           }else {
               System.out.println("订购失败");
               break;
           }
        }while (true);
    }


    private String getType(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
