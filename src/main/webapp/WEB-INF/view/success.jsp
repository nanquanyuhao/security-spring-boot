<%@ page import="org.springframework.security.core.context.SecurityContext" %>
<%@ page import="org.springframework.security.core.userdetails.User" %><%--
  Created by IntelliJ IDEA.
  User: nanquanyuhao
  Date: 2021/9/4
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();

    SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
    User user = (User) securityContext.getAuthentication().getPrincipal();
    String username = user.getUsername();
%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%=username %>登录成功！
    <a href="<%=path %>/logout">退出</a>
</body>
</html>
