<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<@ taglib %>
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
        <button type="submit" value="Create"></button>
    </form>

    <form action="AirplaneController" method="post">
        Legg til et fly:
        <input type="text" name="airplaneName" placeholder="Flynavn">
        <input type="number" name="economy" placeholder="Økonomiplasser">
        <input type="number" name="business" placeholder="Businessplasser">
        <input type="hidden" name="action" value="createplane">
        <button type="submit" value="Create"></button>
    </form>


    <form action="FlightController" method="post">
        Legg til en flight:
        <input type="text" name="departureTime" placeholder="YYYY-MM-DD hh:mm:ss">
        <input type="text" name="arrivalTime" placeholder="YYYY-MM-DD hh:mm:ss">
        <input type="hidden" name="action" value="createFlight">
        <button type="submit" name="Create" value="Create"></button>

    </form>



${notification}


</body>
</html>
