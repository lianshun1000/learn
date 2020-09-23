package com.learn.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class SpringmvcHandler {
    /**
     *@RequestMapping
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
       return "success";
    }
}
