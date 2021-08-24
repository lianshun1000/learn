package com.lagou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lianshun
 * @date 2021/8/22 11:06 下午
 * @description
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo(){
        return "热部署 hello spring boot";
    }

}
