package com.learn.springmvc.handler;

import com.learn.springmvc.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/springmvc")
public class SpringmvcHandler {
    /**
     * @RequestMapping
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }

    /**
     * @RequestMapping method 映射请求方式
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMappingMethod() {
        return "success";
    }

    /**
     * @RequestMapping 映射请求参数 ，以及请求头
     * params:username   age
     * headers
     */
    @RequestMapping(value = "/testRequestMappingParamsAndHeaders", params = {"username", "age=2", "!email" }, headers = {"Accept-Language" })
    public String testRequestMappingParamsAndHeaders() {
        return "success";
    }

    /**
     * 带占位符的URL
     */
    @RequestMapping("/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") int id) {
        System.out.println(name + ":" + id);
        return "success";
    }

    /**
     * REST GET
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id) {
        System.out.println("REST GET:" + id);
        return "success";
    }

    /**
     * REST DELETE
     */
    @ResponseBody
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("REST DELETE:" + id);
        return "success";
    }

    /**
     * REST POST
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("REST POST:");
        return "success";
    }

    /**
     * REST PUT
     */
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String testRestPut() {
        System.out.println("REST PUT:");
        return "success";
    }

    /**
     * RequestParam 映射请求参数到请求处理方法的形参
     * 1、如果请求参数与形参名一致，则可以省略@RequestParam指定
     * 2、@RequestParam标注的形参必须要赋值
     * 可以使用 required来设置为不是必须的
     * 3、可以使用defaultValue来指定一个默认值来替代null
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username, @RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
        //web: request.getParameter()   request.getParameterMap()
        System.out.println(username + "," + age);
        return "success";
    }

    /**
     * @RequestHeader映射请求头信息到方法的形参
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String accpetLanguage) {
        System.out.println(accpetLanguage);
        return "success";
    }

    /**
     * @CookieValue映射cookie信息到方法的形参
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println(sessionId);
        return "success";
    }

    /**
     * POJO
     */
    @RequestMapping(value = "/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 测试原生的API
     */
    @RequestMapping(value = "/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        System.out.println(response);
        //request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request,response);    //转发
        //response.sendRedirect("https://www.baidu.com");  //重定向
        // response.getWriter().println("Hello MVC");
        return "success";
    }
}
