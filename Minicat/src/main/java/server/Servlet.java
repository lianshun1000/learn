package server;

/**
 * @author lianshun
 * @date 2021/9/5 4:37 下午
 * @description
 */
public interface Servlet {

    void init() throws Exception;

    void destroy() throws Exception;

    void service(Request request ,Response response)throws Exception;
}
