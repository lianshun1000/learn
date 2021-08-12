package com.lagou.edu.mvcframework.servlet;

import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.LagouService;
import com.lagou.edu.mvcframework.pojo.Handler;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lianshun
 * @date 2021/8/11 11:06 下午
 * @description
 */
public class LgDispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();

    private List<String> classNames = new ArrayList<>();//缓存扫描到的类的全限定类名

    private Map<String,Object> ioc = new HashMap<>();

    //private Map<String,Method> handlerMapping = new HashMap<>();
    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
       //加载配置文件springmvc.properties
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);
        //扫描注解
        doScan(properties.getProperty("scanPackage"));

        //初始化Bean对象（实现IOC）
        doInstance();

        //实现依赖注入
        doAutoWired();

        //构造一个HandlerMapping处理器映射器，将配置好的URL和method建立映射关系
        initHandlerMapping();
        

        System.out.println("lagou mvc 初始化完成......");
        //等待请求进入，处理请求
    }
    //构造一个HandlerMapping处理器映射器
    private void initHandlerMapping() {
        if(ioc.isEmpty()) return;

        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            //获取IOC中当前遍历对象的class类型
            Class<?> aClass = entry.getValue().getClass();

            if(!aClass.isAnnotationPresent(LagouController.class)) continue;

            String baseUrl = "";
            if(aClass.isAnnotationPresent(LagouRequestMapping.class)){
                LagouRequestMapping annotation = aClass.getAnnotation(LagouRequestMapping.class);
                baseUrl = annotation.value();
            }

            //获取方法
            Method[] methods = aClass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                //方法没有标识LagouRequestMapping，则不处理
                if(!method.isAnnotationPresent(LagouRequestMapping.class)) continue;

                LagouRequestMapping annotation = method.getAnnotation(LagouRequestMapping.class);
                String methodUrl = annotation.value();

                String url = baseUrl + methodUrl;

                Handler handler = new Handler(entry.getValue(),method, Pattern.compile(url));
                //计算方法的参数位置信息
                Parameter[] parameters = method.getParameters();
                for (int j = 0; j < parameters.length; j++) {
                    Parameter parameter = parameters[j];
                    if(parameter.getType() == HttpServletRequest.class || parameter.getType() == HttpServletResponse.class){
                        //如果是request和response对象，那么参数名写HttpServletRequest和HttpServletResponse
                        handler.getParamIndexMapping().put(parameter.getType().getSimpleName(),j);
                    }else {
                        handler.getParamIndexMapping().put(parameter.getName(),j);
                    }
                }

                //建立url和method之间的关系
                handlerMapping.add(handler);

            }
        }
    }
    //实现依赖注入
    private void doAutoWired() {
        if(ioc.isEmpty())return;
        //遍历ioc中所有的对象，查看对象字段中，是否有@LagouAutowired注解，如果有，需要维护依赖注入
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            //获取bean对象中字段的信息
            Field[] declaredFields = entry.getValue().getClass().getDeclaredFields();

            for (int i = 0; i < declaredFields.length; i++) {
                Field declaredField = declaredFields[i];

                if(!declaredField.isAnnotationPresent(LagouAutowired.class)){continue;}

                //有注解
                LagouAutowired annotation = declaredField.getAnnotation(LagouAutowired.class);
                String beanName = annotation.value();
                if("".equals(beanName.trim())){
                    //如果没有配置beanName,那么需要根据当前字段类型注入（接口注入）
                    beanName = declaredField.getType().getName();
                }
                //开启赋值
                declaredField.setAccessible(true);

                try {
                    declaredField.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    //初始化Bean对象
    //基于classNames缓存的全限定类名，以及反射技术，完成对象的创建和管理
    private void doInstance(){
        if(classNames.size() == 0) return;

        try {
            for (int i = 0; i < classNames.size(); i++) {
                String className = classNames.get(i);
                Class<?> aClass = Class.forName(className);
                //区分controller和service
                if(aClass.isAnnotationPresent(LagouController.class)){
                    //此处controller的id不做过多处理，不取value，就拿类的首字母小写作为id保存到IOC中
                    String simpleName = aClass.getSimpleName();
                    String lowerFirstSimpleName = lowerFirst(simpleName);

                    Object o = aClass.newInstance();
                    ioc.put(lowerFirstSimpleName,o);
                }else if(aClass.isAnnotationPresent(LagouService.class)){
                    LagouService lagouService = aClass.getAnnotation(LagouService.class);
                    //获取注解的value
                    String beanName = lagouService.value();
                    //如果指定了id，则以指定的为准
                    if(!"".equals(beanName.trim())){
                        ioc.put(beanName,aClass.newInstance());
                    }else{
                        //如果没有指定，则以类名首字母小写
                        beanName = lowerFirst(aClass.getSimpleName());
                        ioc.put(beanName,aClass.newInstance());
                    }

                    //service层往往是有接口的，面向接口开发，此时再以接口名为id，放入一份对象到ioc中，方便后期根据接口类型注入
                    Class<?>[] interfaces = aClass.getInterfaces();
                    for (int j = 0; j < interfaces.length; j++) {
                        Class<?> anInterface = interfaces[j];
                        //以接口的类名为id放入
                        ioc.put(anInterface.getName(),aClass.newInstance());
                    }
                }else {
                    continue;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String lowerFirst(String str){
        char[] chars = str.toCharArray();
        if('A' <= chars[0] && chars[0] <= 'Z'){
            chars[0] += 32;
        }
        return String.valueOf(chars);
    }

    //扫描类
    private void doScan(String scanPackage) {
        String scanPackagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + scanPackage.replaceAll("\\.", "/");
        File pack = new File(scanPackagePath);
        File[] files = pack.listFiles();

        for (File file : files) {
            if(file.isDirectory()){
                doScan(scanPackage + "." + file.getName());
            }else if(file.getName().endsWith(".class")){
                String className = scanPackage + "." + file.getName().replaceAll(".class","");
                classNames.add(className);
            }
        }

    }

    //加载配置文件
    private void doLoadConfig(String contextConfigLocation) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接受处理请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求，根据url，找到对应的Method方法，进行调用
        //获取url
       /* String requestURI = req.getRequestURI();
        Method method = handlerMapping.get(requestURI);//获取到一个反射的方法
        //反射调用，需要传入对象，参数
        method.invoke()*/

        //根据url获取到能够处理当前请求的handler
        Handler handler = getHandler(req);
        if (handler == null){
            resp.getWriter().write("404 not found");
            return;
        }

        //参数绑定
        //获取所有参数类型数组，数组长度是我们传入的args的长度
        Class<?>[] parameterTypes = handler.getMethod().getParameterTypes();
        //传入反射调用
        Object[] paraValues = new Object[parameterTypes.length];
        //以下就是为了向参数数组中塞值，而且还得保证参数的顺序和方法中形参的顺序一致
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历request所有参数
        for(Map.Entry<String,String[]> param : parameterMap.entrySet()){
            String value = StringUtils.join(param.getValue(), ",");
            //如果参数和方法中的参数匹配上了，填充参数
            if(!handler.getParamIndexMapping().containsKey(param.getKey())) continue;
            //方法形参确实有该参数，找到他的索引位置，把对应的参数值放入paraValues;
            Integer index = handler.getParamIndexMapping().get(param.getKey());

            paraValues[index] = value;//把前台传过来的参数值填充到对应的位置去
        }

        int requestIndex = handler.getParamIndexMapping().get(HttpServletRequest.class.getSimpleName());
        paraValues[requestIndex] = req;

        int responseIndex = handler.getParamIndexMapping().get(HttpServletResponse.class.getSimpleName());
        paraValues[responseIndex] = resp;

        //最终调用handler的method
        try {
            handler.getMethod().invoke(handler.getController(),paraValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Handler getHandler(HttpServletRequest req) {
        if(handlerMapping.isEmpty()) return null;

        String url = req.getRequestURI();

        for (Handler handler : handlerMapping) {
            Matcher matcher = handler.getPattern().matcher(url);

            if(!matcher.matches()) continue;
            return handler;
        }

        return null;
    }
}
