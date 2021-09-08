package server;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author lianshun
 * @date 2021/9/5 3:22 下午
 * @description Minicat的主类
 */
public class Bootstrap {

    //定义socket监听的端口号
    private int port = 8080;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    //Minicat启动需要的初始化的操作
    public void start() throws Exception {

        //加载解析相关的配置，web.xml
        loadServlet();

        //定义一个线程池
        int coolPoolSize = 10;
        int maximumPoolSize = 50;
        long keepAliveTime = 100L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(50);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coolPoolSize, maximumPoolSize,keepAliveTime,timeUnit,workQueue,threadFactory,handler);


        //完成Minicat1.0版本（启动http://localhost:8080返回一个固定的字符串到页面）
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("=============>Minicat start on port:" + port);

        /*while (true){
            Socket socket = serverSocket.accept();
            //接收到请求
            OutputStream outputStream = socket.getOutputStream();
            String data = "Hello Minicat";
            String responseText = HttpProtocoUtil.getHttpHeader200(data.getBytes().length) + data;
            outputStream.write(responseText.getBytes());
            socket.close();
        }*/


        //完成Minicat2.0版本（封装request和response对象，返回一个静态资源文件）
        /*while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            //封装request对象和response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());
            response.outputHtml(request.getUrl());


            socket.close();
        }*/

        //完成Minicat3.0版本（可以请求动态资源Servlet）
        /*while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            //封装request对象和response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());

            if(servletMap.get(request.getUrl()) == null){
                response.outputHtml(request.getUrl());
            }else{
                //动态资源servlet请求
                HttpServlet httpServlet = servletMap.get(request.getUrl());
                httpServlet.service(request,response);
            }


            socket.close();
        }*/

        //多线程改造
        /*while (true){
            Socket socket = serverSocket.accept();
            RequestProcessor requestProcessor = new RequestProcessor(socket,servletMap);
            requestProcessor.start();
        }*/

        //使用线程池
        while (true){
            System.out.println("===========>使用线程池进行多线程改造");
            Socket socket = serverSocket.accept();
            RequestProcessor requestProcessor = new RequestProcessor(socket,servletMap);
            //requestProcessor.start();
            threadPoolExecutor.execute(requestProcessor);
        }


    }

    private Map<String,HttpServlet> servletMap = new HashMap<>();
    /**
     * 加载解析web.xml,初始化Servlet
     */
    private void loadServlet() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("web.xml");
        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();

            List<Element> selectNodes = rootElement.selectNodes("//servlet");
            for (int i = 0; i < selectNodes.size(); i++) {
                Element element = selectNodes.get(i);
                Element servletNameElement = (Element)element.selectSingleNode("servlet-name");
                String servletName = servletNameElement.getStringValue();

                Element servletClassElement = (Element)element.selectSingleNode("servlet-class");
                String servletClass = servletClassElement.getStringValue();

                //根据servletName找到url-pattern
                Element servletMapping = (Element) rootElement.selectSingleNode("/web-app/servlet-mapping[servlet-name='" + servletName + "']");
                String urlPattern = servletMapping.selectSingleNode("url-pattern").getStringValue();

                servletMap.put(urlPattern,(HttpServlet) Class.forName(servletClass).newInstance());

            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    //Minicat的启动入口
    public static void main(String[] args) {
         Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
