<%--
  Created by IntelliJ IDEA.
  User: nanquanyuhao
  Date: 2021/6/21
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%-- login 地址对照 spring-security 实际验证登录表单的地址，配置于 WebSecurityConfig --%>
<form action="<%=path %>/user/login" method="post">
    用户名：<input type="text" name="username"><br>
    密&nbsp;&nbsp;&nbsp;码:
    <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
