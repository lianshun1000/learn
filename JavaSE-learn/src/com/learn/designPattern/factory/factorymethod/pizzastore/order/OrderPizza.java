package com.learn.designPattern.factory.factorymethod.pizzastore.order;

import com.learn.designPattern.factory.simpleFactory.pizzastore.orderpizza.SimpleFactory;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lianshun
 * @date 2021/6/26 6:32 下午
 * @description
 */
public abstract class OrderPizza {

    //定义一个抽象方法，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    //构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;//订购pizza类型

        do {
            orderType = getType();
            createPizza(orderType);

            //输出Pizza的制作流程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }


    /*//构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    Pizza pizza = null;
    public void setSimpleFactory(SimpleFactory simpleFactory){
        String orderType = "";//用户输入
        this.simpleFactory = simpleFactory;//设置简单工厂对象

        do {
           orderType = getType();
           pizza = this.simpleFactory.createPizza(orderType);

           if(pizza != null){
               //输出Pizza的制作流程
               pizza.prepare();
               pizza.bake();
               pizza.cut();
               pizza.box();
           }else {
               System.out.println("订购失败");
               break;
           }
        }while (true);

    }*/

    //写一个方法，可以获取客户希望订购的pizza种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
