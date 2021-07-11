package com.learn.designPattern.factory.factorymethod.pizzastore.pizza;

/**
 * @author lianshun
 * @date 2021/6/26 6:26 下午
 * @description
 */
public abstract class Pizza {
    protected String name;

    //准备原材料，不同的pizza不一样
    public abstract void prepare();

    public void bake(){
        System.out.println(name+"baking;");
    }

    public void cut(){
        System.out.println(name+"cutting;");
    }

    public void box(){
        System.out.println(name+"boxing;");
    }

    public void setName(String name){
        this.name = name;
    }
}
