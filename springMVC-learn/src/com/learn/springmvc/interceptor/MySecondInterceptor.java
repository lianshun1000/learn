package com.learn.springmvc.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 自定义拦截器
* */
/*@Component*/
public class MySecondInterceptor implements HandlerInterceptor {

    @Override
    /*
    * 1、是在DispatcherServlet 的请求处理方法之前执行
    * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MySecondInterceptor  preHandle");
        return true;
    }

    @Override
    /*
    * 2、是在DispatcherServlet 的请求处理方法之后，视图处理之前执行
    * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MySecondInterceptor  postHandle");
    }

    @Override

    /*
    * 3、在视图处理之后才执行（转发、重定向都做完之后）
    * */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MySecondInterceptor  afterCompletion");
    }
}
