package server;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lianshun
 * @date 2021/9/5 3:52 下午
 * @description 把请求信息封装为request（根据InputSteam封装）
 * */
public class Request {

    private String method;//请求方式，比如GET/POST

    private String url;//例如 /，/index.html

    private InputStream inputStream;//输入流，其他属性从输入流中获取

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Request() {
    }

    public Request(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;

        //从输入流中获取请求信息
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] bytes = new byte[count];
        inputStream.read(bytes);
        String inputStr = new String(bytes);

        //获取第一行请求头信息
       String firstLineStr = inputStr.split("\\n")[0];//GET / HTTP/1.1
        String[] s = firstLineStr.split(" ");
        this.method = s[0];
        this.url = s[1];

        System.out.println("==========>method" + method);
        System.out.println("==========>url" + url);
    }


}
