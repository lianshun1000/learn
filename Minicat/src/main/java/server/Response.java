package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author lianshun
 * @date 2021/9/5 3:52 下午
 * @description 封装response对象需要依赖于OutPutStream
 *          该对象需要提供核心方法，输出html
 */
public class Response {
    private OutputStream outputStream;

    public Response() {
    }

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    //输出指定字符串
    public void output(String content) throws IOException {
        outputStream.write(content.getBytes());
    }

    /**
     *
     * @param path url,根据url来获取静态资源的绝对路径，进一步根据绝对路径读取该静态资源文件，最终通过输出流输出
     */
    public void outputHtml(String path) throws IOException {
        //获取静态资源文件的绝对路径
        String absoluteResourcePath = StaticResourceUtil.getAbsolutePath(path);
        //输入静态资源文件
        File file = new File(absoluteResourcePath);
        if (file.exists() && file.isFile()){
            //读取静态资源文件 输出静态资源
            StaticResourceUtil.outputStaticResource(new FileInputStream(file),outputStream);
        }else{
            //输出404
            output(HttpProtocoUtil.getHttpHeader404());
        }
    }
}
