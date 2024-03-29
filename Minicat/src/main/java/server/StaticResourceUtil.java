package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lianshun
 * @date 2021/9/5 4:09 下午
 * @description
 */
public class StaticResourceUtil {

    /**
     * 获取静态资源的绝对路径
     * @param path
     * @return
     */
    public static String getAbsolutePath(String path){
        String absolutePath = StaticResourceUtil.class.getResource("/").getPath();
        return absolutePath.replaceAll("\\\\","/") + path;
    }

    /**
     * 读取静态资源文件输入流，通过输出流输出
     * @param inputStream
     * @param outputStream
     */
    public static void outputStaticResource(InputStream inputStream, OutputStream outputStream) throws IOException {
        int count = 0;
        while(count == 0){
            count = inputStream.available();
        }

        int resourceSize = count;
        //输出http请求头，然后又再输出具体内容
        outputStream.write(HttpProtocoUtil.getHttpHeader200(resourceSize).getBytes());
        //读取内容输出
        long written = 0;//已经读取的内容长度
        int byteSize = 1024;//计划缓冲的长度

        byte[] bytes = new byte[byteSize];
        while (written < resourceSize){
            if(written + byteSize > resourceSize){//说明剩余未读取大小不足一个1024长度，那就按照真实长度处理
                byteSize = (int)(resourceSize - written);//剩余的文件内容长度
                bytes = new byte[byteSize];
            }

            inputStream.read(bytes);
            outputStream.write(bytes);

            outputStream.flush();
            written += byteSize;
        }

    }


}
