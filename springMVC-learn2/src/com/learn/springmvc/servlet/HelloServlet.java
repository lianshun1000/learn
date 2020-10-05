package com.learn.springmvc.servlet;

import com.learn.springmvc.beans.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //访问到SpringIOC容器对象
        //从ServletContext中获取容器对象
        ServletContext sc = getServletContext();
        ApplicationContext ctx = (ApplicationContext) sc.getAttribute("applicationContext");
        Person person = ctx.getBean("person",Person.class);
        person.sayHello();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
