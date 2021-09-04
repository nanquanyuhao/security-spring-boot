<%--
  Created by IntelliJ IDEA.
  User: nanquanyuhao
  Date: 2021/9/4
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    登录成功！
    <a href="<%=path %>/logout">退出</a>
</body>
</html>
