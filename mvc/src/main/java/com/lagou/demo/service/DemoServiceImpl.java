package com.lagou.demo.service;

import com.lagou.edu.mvcframework.annotations.LagouService;

/**
 * @author lianshun
 * @date 2021/8/11 11:39 下午
 * @description
 */
@LagouService("demoService")
public class DemoServiceImpl implements IDemoService{
    @Override
    public String getName(String name) {
        System.out.println("Service实现类中的name参数：" + name);
        return name;
    }
}
