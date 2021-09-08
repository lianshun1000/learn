package server;

/**
 * @author lianshun
 * @date 2021/9/5 3:34 下午
 * @description http协议工具类，主要提供响应头信息
 */
public class HttpProtocoUtil {


      public static String getHttpHeader200(long contentLength){
          return "HTTP/1.1 200 OK \n" +
                  "Content-Type: text/html; charset=UTF-8 \n" +
                  "Content-Length: " + contentLength + "\n" +
                  "\r\n";
      }


    public static String getHttpHeader404(){
          String str404 = "<h1>404 not  found</h1>";
        return "HTTP/1.1 404 NOT Found \n" +
                "Content-Type: text/html; charset=UTF-8 \n" +
                "Content-Length: " + str404.getBytes().length + "\n" +
                "\r\n";
    }
}
