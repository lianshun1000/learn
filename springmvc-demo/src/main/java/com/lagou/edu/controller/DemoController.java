package com.lagou.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * @author lianshun
 * @date 2021/8/9 10:09 下午
 * @description
 */
@Controller
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/handle01")
    public ModelAndView handle01(){
        Date date = new Date();
        //封装了数据和页面信息的模型
        ModelAndView modelAndView = new ModelAndView();
        //向请求域request.setAttribute("date",date);
        modelAndView.addObject("date",date);
        //视图信息
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * SpringMVC在handler方法上传入Map，Model，ModelMap参数，并向这些参数中保存数据（放入请求域），都可以在页面获取到
     * 运行时的具体类型都是BindingAwareModelMap，相当于给BindingAwareModelMap保存的数据都会放到请求域中
     */

    @RequestMapping("/handle11")
    public String handle11(ModelMap map){
        Date date = new Date();
        map.addAttribute("date",date);
        return "success";
    }

    @RequestMapping("/handle12")
    public String handle12(Model model){
        Date date = new Date();
        model.addAttribute("date",date);
        return "success";
    }


    @RequestMapping("/handle13")
    public String handle13(Map<String,Object> map){
        Date date = new Date();
        map.put("date",date);
        return "success";
    }
}
