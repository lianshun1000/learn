package com.learn.designPattern.bridge;

/**
 * @author lianshun
 * @date 2021/7/17 7:36 下午
 * @description
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("直立手机");
    }

    public void close() {
        super.close();
        System.out.println("直立手机");
    }


    public void call() {
        super.call();
        System.out.println("直立手机");
    }
}
