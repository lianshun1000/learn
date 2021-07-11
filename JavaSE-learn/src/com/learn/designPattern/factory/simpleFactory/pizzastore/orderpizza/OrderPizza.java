package com.learn.designPattern.factory.simpleFactory.pizzastore.orderpizza;

import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.CheesePizza;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.GreekPizza;
import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lianshun
 * @date 2021/6/26 6:32 下午
 * @description
 */
public class OrderPizza {
    //构造器
    /*public OrderPizza(){
        Pizza pizza = null;
        String orderType;//订购pizza类型

        do{
            orderType = getType();
            if(orderType.equals("greek")){
                pizza = new GreekPizza();
                pizza.setName("greek");
            }else if(orderType.equals("cheese")){
                pizza = new CheesePizza();
                pizza.setName("cheese");
            }else {
                break;
            }

            //输出Pizza的制作流程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }*/

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
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

    }

    //写一个方法，可以获取客户希望订购的pizza种类
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
