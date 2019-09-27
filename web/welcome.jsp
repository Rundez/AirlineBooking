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
        // Deletes cache if the user have been logged out
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        // Checks if the user is logged in. If not, they are redirected to the login page.
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
    }

        String name =(String)session.getAttribute("username");
        session.setAttribute("username", name);
    %>

Welcome, ${username}
    <br>
<a href="videos.jsp">Videos here</a> <br>
    <form action="Logout" name="logout">
        <input type="submit" value="Logout">
    </form>

   <form action="index.jsp">
       <button>To the index page!</button>
   </form>

    <form action="AirportController" method="post">
         Legg til flyplass:
        <input type="text" name="airportName" placeholder="Navn">
        <input type="hidden" name="action" value="createairport">
        <button type="submit" name="Create"></button>
    </form>

    <form action="AirplaneController" method="post">
        Legg til et fly:
        <input type="text" name="airplaneName" placeholder="Flynavn">
        <input type="number" name="economy" placeholder="Økonomiplasser">
        <input type="number" name="business" placeholder="Businessplasser">
        <input type="hidden" name="action" value="createplane">
        <button type="submit" name="Create"></button>
    </form>

    <div>
        ${notification}
    </div>



</body>
</html>
