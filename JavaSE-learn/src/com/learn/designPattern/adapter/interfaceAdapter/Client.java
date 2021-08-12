package com.learn.designPattern.adapter.interfaceAdapter;

/**
 * @author lianshun
 * @date 2021/7/17 5:14 下午
 * @description
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("使用了m1");
            }
        };
        adapter.m1();
    }
}
