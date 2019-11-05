<%@ page import="Classes.Flight" %><%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 03/10/2019
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="username" value="${username}" scope="session"/>

<html>
<head class="w3-container w3-red w3-center" style="padding:128px 16px">
    <title>Book flight</title>
</head>



<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }

    String departureName = request.getParameter("departureName");
    String arrivalName = request.getParameter("arrivalName");
    String departureTime = request.getParameter("departureTime");
    String arrivalTime = request.getParameter("arrivalTime");
    String airplaneName = request.getParameter("airplaneName");
    String flightID = request.getParameter("flightID");
    String user = request.getParameter("username");
    String radio = request.getParameter("radio");

    out.print(departureName + "<br>");
    out.print(arrivalName + "<br>");
    out.print(departureTime + "<br>");
    out.print(arrivalTime + "<br>");
    out.print(airplaneName + "<br>");
    out.print(flightID + "<br>");
    out.print(radio);
%>



    <meta charset="UTF-8">
    <title>CSS Boarding Pass</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="./Style/booking.css">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>

</head>
<body>

<div class="wrapper">
    <div class="qr_code">
        <img src="./images/mountains-hero.jpg" alt="QR_code">
    </div>
    <div class="content">
        <div class="location">
            <div class="item">
                <h1><% out.print(departureName);%> </h1>
                <p><% out.print(departureTime); %></p>
            </div>
            <div class="path">
                <i class="fas fa-plane"></i>
            </div>
            <div class="item">
                <h1><%out.print(arrivalName); %></h1>
                <p><% out.print(arrivalTime); %></p>
            </div>
        </div>

        <div class="info">
            <div class="item">
                <h4>passenger</h4>
                <p>${username}</p>
            </div>
            <div class="item">
                <h4>flight</h4>
                <p><% out.print("FG - " + flightID); %></p>
            </div>
            <div class="item">
                <h4>Class</h4>
                <p><% out.print(radio); %></p>
            </div>
            <div class="item">
                <h4>seat</h4>
                <p>18W</p>
            </div>
            <div class="item">
                <h4>airplane</h4>
                <p><% out.print(airplaneName); %> </p>
            </div>
        </div>
    </div>
</div>

<%--
Form which takes the user from confirmation page to Controller servlet to add database values to
a reservation.
 --%>
<form action="BookingController" method="post">

    <input type="submit" class="btn btn-primary btn-lg" value="Bekreft bestilling!">
    <input type="hidden" name="depName" value="<%out.print(departureName);%>">
    <input type="hidden" name="flightID" value="<%out.print(flightID);%>">
    <input type="hidden" name="userName" value="${username}">

    <input type="hidden" value="book" name="action">
</form>


</body>
</html>
