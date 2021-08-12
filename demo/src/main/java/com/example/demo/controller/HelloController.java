package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lianshun
 * @date 2021/7/27 3:10 下午
 * @description
 */
@RestController
public class HelloController {

    @RequestMapping("/helloword")
    public String helloword() {
        return "helloword";
    }

}
