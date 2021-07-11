package com.learn.designPattern.factory.simpleFactory.pizzastore.orderpizza;

import com.learn.designPattern.factory.simpleFactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lianshun
 * @date 2021/6/26 6:32 下午
 * @description
 */
public class OrderPizza2 {
    Pizza pizza = null;
    String orderType = "";
    //构造器
    public OrderPizza2(){
        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);

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
