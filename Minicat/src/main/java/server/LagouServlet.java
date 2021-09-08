package server;

import java.io.IOException;

/**
 * @author lianshun
 * @date 2021/9/5 4:41 下午
 * @description
 */
public class LagouServlet extends HttpServlet{
    @Override
    public void doGet(Request request, Response response) {
        String context = "<h1>Lagou Servlet GET</h1>";
        try {
            response.output(HttpProtocoUtil.getHttpHeader200(context.getBytes().length) + context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        String context = "<h1>Lagou Servlet POST</h1>";
        try {
            response.output(HttpProtocoUtil.getHttpHeader200(context.getBytes().length) + context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
