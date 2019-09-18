<%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 15/09/2019
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");


    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<iframe width="700" height="400"
        src="https://www.youtube.com/embed/agi4geKb8v8">
</iframe>
</body>
</html>
