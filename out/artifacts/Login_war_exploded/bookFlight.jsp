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
<head>
    <title>Book flight</title>
</head>



<%
    String departureName = request.getParameter("departureName");
    String arrivalName = request.getParameter("arrivalName");
    String departureTime = request.getParameter("departureTime");
    String arrivalTime = request.getParameter("arrivalTime");
    String airplaneName = request.getParameter("airplaneName");
    String flightID = request.getParameter("flightID");


    out.print(departureName + "<br>");
    out.print(arrivalName + "<br>");
    out.print(departureTime + "<br>");
    out.print(arrivalTime + "<br>");
    out.print(airplaneName + "<br>");
    out.print(flightID + "<br>");
%>


    <meta charset="UTF-8">
    <title>CSS Boarding Pass</title>
    <link rel="stylesheet" href="./Style/booking.css">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>
<body>

<div class="welcome">
   <h4>Din bestilling: </h4>
</div>

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
                <h4>gate</h4>
                <p>12</p>
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

<form action="/src/Controllers/BookingController.java">

    <input type="submit" value="Bekreft bestilling!">
</form>


</body>
</html>
