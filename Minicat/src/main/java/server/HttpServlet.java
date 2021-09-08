package server;

/**
 * @author lianshun
 * @date 2021/9/5 4:38 下午
 * @description
 */
public abstract class HttpServlet implements Servlet{

    public abstract void doGet(Request request,Response response);

    public abstract void doPost(Request request,Response response);

    @Override
    public void service(Request request,Response response)throws Exception{
         if("GET".equalsIgnoreCase(request.getMethod())){
             doGet(request,response);
         }else{
             doPost(request,response);
         }
    }
}
