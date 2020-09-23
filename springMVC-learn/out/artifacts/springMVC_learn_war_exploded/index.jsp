<%--
  Created by IntelliJ IDEA.
  User: lianshun
  Date: 2020/9/23
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="springmvc/testRequestMapping">testRequestMapping</a>
  <br/>
  <%--相对路径：不以/开头的路径，相对于当前路径发送请求
      绝对路径：以/开头的路径，直接在http:localhost:8080后面拼接请求
  --%>
   <a href="hello">Hello SpringMVC</a>
  </body>
</html>
