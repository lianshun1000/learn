package com.learn.springmvc.handler;

import com.learn.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHandler {
    @Autowired
    private UserService userService;

    public UserHandler() {
        System.out.println("UserHandler");
    }

    @RequestMapping("/hello")
    public String hello() {
        userService.hello();
        return "success";
    }
}
