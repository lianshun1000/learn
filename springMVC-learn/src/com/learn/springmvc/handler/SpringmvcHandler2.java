package com.learn.springmvc.handler;

import com.learn.springmvc.beans.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class SpringmvcHandler2 {
    /*
    * ModelAndView
    * 猜测：SpringMVC会把ModelAndView的模型数据存放到request域对象中
    * */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
      //模型数据：username=Admin
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("username","Admin");
        //设置视图信息
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String ,Object> map){
        //模型数据：password=123456
        //SpringMVC会把map中的模型数据放到request域中,SpringMVC在调用完请求处理方法后，不管方法返回值是什么类型，都会处理成一个ModelAndView对象
        //添加模型数据
       map.put("password","123456");
        return "success";
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        //模型数据：loginMsg=用户名或者密码错误
        model.addAttribute("loginMsg","用户名或者密码错误");
        return "success";
    }

    @RequestMapping("/testView")
    public String testView(){
        return "success";
    }

    @RequestMapping("/testRedirectView")
    public String testRedirectView(){
        return "redirect:/OK.jsp";
    }

    /*处理json*/
    @ResponseBody//负责将方法返回值转换为JSON字符串响应给浏览器端
    @RequestMapping("/testJson")
    public Collection<String> testJson(){
        Collection col = new ArrayList();
        col.add("aa");
        return col;
    }

    /*使用HttpServletConvert完成下载功能：
    支持@RequestBody  @ResponseBody  HttpEntity  ResponseEntity
    下载的原理：将服务器端的文件以流的形式写到客户端
    ResponseEntity：将要下载的文件数据以及一些响应信息封装到ResponseEntity对象中，浏览器通过解析发送回去的响应数据，就可以进行一个下载操作
    * */
    @RequestMapping("/testDownLoad")
    public ResponseEntity<byte[]> testDownLoad(HttpSession session) throws IOException {
        byte  [] imgs;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("WEB-INF/img/liuying.jpg");
        imgs = new byte[in.available()];
        in.read(imgs);
        //将响应数据以及一些响应头信息封装到ResponseEntity中
        /*
        * 参数：1、发送给浏览器端的数据
        *       2、设置响应头
        *       3、设置响应码
        * */
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=ai.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]>  rs = new ResponseEntity<byte[]>(imgs,headers,statusCode);
        return  rs;
    }


    /*文件上传
    * 原理：将本地文件上传到服务器端
    * */
    @RequestMapping("/upload")
    public  String testUpload(@RequestParam("desc") String desc, @RequestParam("uploadFile")MultipartFile multipartFile , HttpSession session) throws IOException {
           //获取到上传文件到名字
        String uploadFileName = multipartFile.getOriginalFilename();
        //获取输入流
        InputStream in = multipartFile.getInputStream();
        //获取服务器端uploads文件夹的真实路径
        ServletContext sc = session.getServletContext();
        String  realPath = sc.getRealPath("uploads");
        File targetFile = new File(realPath+"/"+uploadFileName);
        FileOutputStream os = new FileOutputStream(targetFile);

        //写文件
        /*int i;
        while((i=in.read())!=-1){
            os.write(i);
        }
        in.close();
        os.close();*/
        multipartFile.transferTo(targetFile);
        return "success";
    }
}
