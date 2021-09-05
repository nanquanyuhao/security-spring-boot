<%--
  Created by IntelliJ IDEA.
  User: nanquanyuhao
  Date: 2021/9/5
  Time: 10:55
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
    <div>
        <span>${_csrf.token}</span>
    </div>
</body>
</html>
