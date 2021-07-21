package com.learn.designPattern.bridge;

/**
 * @author lianshun
 * @date 2021/7/17 7:34 下午
 * @description
 */
public abstract class Phone {
    //组合品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        brand.open();
    }

    protected void close(){
        brand.close();
    }

    protected void call(){
        brand.call();
    }
}
