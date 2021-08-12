package com.learn.springmvc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    /*
     * 当监听到ServletContext被创建则执行
     * */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //创建SpringIOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //将容器对象绑定到ServletContext中
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("applicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
