<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 16/09/2019
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Style/style.css">
    <title>Register</title>
</head>
<body>
        <div class="login-page">
            <div class="form">
              <form action="Registration" method="post" class="login-form">
                  <input type="text" placeholder="Name" name="name"/>
                  <input type="password" placeholder="Password" name="pass"/>
                   <button>create</button>
              </form>
            </div>
        </div>

</body>
</html>
