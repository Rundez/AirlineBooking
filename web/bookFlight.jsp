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


<div class="wrapper">
    <div class="qr_code">
        <img src="QR_Code.png" alt="QR_code">
    </div>
    <div class="content">
        <div class="location">
            <div class="item">
                <h1><% out.print(departureName);%> </h1>
                <p>2:00AM JULY. 10 2019</p>
            </div>
            <div class="path">
                <i class="fas fa-plane"></i>
            </div>
            <div class="item">
                <h1><%out.print(arrivalName); %></h1>
                <p>12:00PM JULY. 11 2019</p>
            </div>
        </div>

        <div class="info">
            <div class="item">
                <h4>passenger</h4>
                <p>Mark Wood</p>
            </div>
            <div class="item">
                <h4>flight</h4>
                <p>GF - 545</p>
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
                <h4>terminal</h4>
                <p>P4</p>
            </div>
        </div>
    </div>
</div>


</body>
</html>
