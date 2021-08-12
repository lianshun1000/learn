package com.lagou.edu.mvcframework.pojo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author lianshun
 * @date 2021/8/12 12:26 上午
 * @description  封装handler方法相关的信息
 */
public class Handler {

    private Object controller;

    private Method method;

    private Pattern pattern;//Spring中URL支持正则

    private Map<String,Integer> paramIndexMapping;//参数顺序，进行参数绑定

    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.paramIndexMapping = new HashMap<>();
    }


    public void setController(Object controller) {
        this.controller = controller;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setParamIndexMapping(Map<String, Integer> paramIndexMapping) {
        this.paramIndexMapping = paramIndexMapping;
    }

    public Object getController() {
        return controller;
    }

    public Method getMethod() {
        return method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Map<String, Integer> getParamIndexMapping() {
        return paramIndexMapping;
    }
}
