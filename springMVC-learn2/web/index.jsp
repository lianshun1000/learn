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
<form action="upload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="uploadFile"/>
    <br/>
    文件描述：<input type="text" name="desc"/>
    <br/>
    <input type="submit" name="上传"/>
</form>
<br/>

<a href="testDownLoad">testDownLoad</a>
<br/>

<a href="testJson">testJson</a>
<br/>

<a href="testRedirectView">testRedirectView</a>
<br/>

<a href="testViewController">testViewController</a>
<br/>

<a href="testView">testView</a>
<br/>

<a href="testModel">testModel</a>
<br/>

<a href="testMap">testMap</a>
<br/>

<a href="testModelAndView">testModelAndView</a>
<br/>

<a href="springmvc/testServletAPI">testServletAPI</a>
<br/>

<form action="springmvc/testPOJO" method="post">
    用户名称：<input type="text" name="userName"/>
    <br/>
    用户密码：<input type="password" name="passWord"/>
    <br/>
    用户邮箱：<input type="text" name="email"/>
    <br/>
    用户性别：男<input type="radio" name="gender" value="1"/>
    女<input type="radio" name="gender" value="0"/>
    <br/>
    <%--支持级联--%>
    用户省份：<input type="text" name="address.province"/>
    <br/>
    用户城市：<input type="text" name="address.city"/>
    <br/>
    <input type="submit" value="注册"/>
</form>

<br/>
<a href="springmvc/testCookieValue">testCookieValue</a>
<br/>

<a href="springmvc/testRequestHeader">testRequestHeader</a>
<br/>

<a href="springmvc/testRequestParam?username=Tom&age=22">testRequestParam</a>
<br/>

<%--修改订单--%>
<form action="springmvc/order" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="REST PUT "/>
</form>
<%--添加订单--%>
<form action="springmvc/order" method="post">
    <input type="submit" value="REST POST "/>
</form>
<%--删除id 为1001的订单--%>
<form action="springmvc/order/1001" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="REST DELETE "/>
</form>
<br/>
<%--查询id 为1001的订单--%>
<a href="springmvc/order/1001">REST GET </a>
<br/>

<a href="springmvc/testPathVariable/admin/1">testPathVariable</a>
<br/>

<a href="springmvc/testRequestMappingParamsAndHeaders?username=Tom&age=2">testRequestMappingParamsAndHeaders</a>
<br/>


<a href="springmvc/testRequestMappingMethod">testRequestMappingMethod</a>
<br/>

<a href="springmvc/testRequestMapping">testRequestMapping</a>
<br/>
<%--相对路径：不以/开头的路径，相对于当前路径发送请求
    绝对路径：以/开头的路径，直接在http:localhost:8080后面拼接请求
--%>
<a href="hello">Hello SpringMVC</a>
</body>
</html>
