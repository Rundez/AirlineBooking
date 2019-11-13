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
    <link rel="stylesheet" type="text/css" href="Style/style.css">
    <title>Welcome to Airline Booking!</title>
</head>

<body>
<div class="login-page">
    <div class="form">
        <form action="Login" method="post" class="login-form">
            <input type="text" placeholder="Name" name="FirstName"/>
            <input type="password" placeholder="Password" name="PasswordLogin"/>
            <button>Login</button>

            <form action="createAccount.jsp">
                <p class="message">Not registered? <a href="createAccount.jsp">Create an account</a></p>
            </form>
        </form>
    </div>
</div>
</body>
</html>

