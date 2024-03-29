package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.LagouSecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lianshun
 * @date 2021/8/11 11:38 下午
 * @description
 */
@LagouController
@LagouRequestMapping("/demo")
@LagouSecurity({"ls"})
public class DemoController {

    @LagouAutowired
    private IDemoService demoService;

    @LagouRequestMapping("/query")
    @LagouSecurity({"ly"})
    public String query(HttpServletRequest request , HttpServletResponse response,String name){
       return demoService.getName(name);
    }
}
