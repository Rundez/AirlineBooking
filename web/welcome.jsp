<%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 15/09/2019
  Time: 18:29
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

Welcome, ${username}
    <br>
<a href="videos.jsp">Videos here</a> <br>
    <form action="Logout" name="logout">
        <input type="submit" value="Logout">
    </form>

</body>
</html>
