<%--
  Created by IntelliJ IDEA.
  User: lianshun
  Date: 2020/9/23
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Success page</h1>
    username:${requestScope.username}<%--四个域对象：pageScope   requestScope   sessionScope   applicationScope--%>
    <br/>
    password:${requestScope.password}
    <br/>
    loginMsg:${requestScope.loginMsg}
</head>
<body>

</body>
</html>
