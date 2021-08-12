package com.learn.springmvc.helloWord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求处理器 / 控制器
 */
@Controller
public class SpringMVCHandler {
    /**
     * 处理客户端请求：http:localhost:8080/springMVC-learn/hello
     *
     * @RequestMapping:完成请求与请求方法的映射
     */
    @RequestMapping("/hello")
    public String handleHello() {
        System.out.println("Hello SpringMVC!");
        return "success";//通过视图解析器得到具体的视图路径再转发去往具体视图
    }
}
