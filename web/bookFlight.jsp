<%@ page import="Classes.Flight" %><%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 03/10/2019
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="username" value="${username}" scope="session"/>

<html>
<meta charset="UTF-8">
<title>CSS Boarding Pass</title>

<link rel="stylesheet" href="./Style/booking.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body, h1, h2, h3, h4, h5, h6 {
        font-family: "Lato", sans-serif
    }

    .w3-bar, h1, button {
        font-family: "Montserrat", sans-serif
    }

    /*Bakgrunn på toppen*/
    .w3-red, .w3-hover-red:hover {
        color: #ffffff !important;
        background-color: #ffffff !important;
        /*background-image: url(https://source.unsplash.com/1920x1080?landscape);*/
        background-image: url(http://cdn.cnn.com/cnnnext/dam/assets/181128110146-12-norway-skiing-travel.jpg);
        height: 700px;
    }

    /*Button*/
    .w3-black, .w3-hover-black:hover {
        color: #034a06 !important;
        background-color: #fff !important;
    }

    th, td {
        padding: 15px;
    }

    .buttom {
        margin: 0;
        position: absolute;
        top: 70%;
        left: 45%;
    }
</style>



<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
           href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i
                class="fa fa-bars"></i></a>
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white w3-hover-grey w3-grey">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey ">Book</a>
        <a href="listMyFlights.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">My
            bookings</a>
        <a href="travelinfo.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Travel
            info</a>
        <a href="contactus.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Contact
            us</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Login</a>
        <a Welcome class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey"> Welcome ${username}</a>
        <a href="Logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey" name="WelcomeBar">Log
            out</a>
        <a href="myProfile.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey"
           name="WelcomeBar">My profile</a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-padding-large">Book</a>
        <a href="listMyFlights.jsp" class="w3-bar-item w3-button w3-padding-large">My bookings</a>
        <a href="travelinfo.jsp" class="w3-bar-item w3-button w3-padding-large">Travel info</a>
        <a href="contactus.jsp" class="w3-bar-item w3-button w3-padding-large">Contact us</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-padding-large">Login</a>
    </div>
</div>




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
    String airplaneID = request.getParameter("airplaneID");
    String price = request.getParameter("price");
    String businessPrice = request.getParameter("businessPrice");
    int baggage = Integer.parseInt(request.getParameter("baggage"));

//    out.print(departureName + "<br>");
//    out.print(arrivalName + "<br>");
//    out.print(departureTime + "<br>");
//    out.print(arrivalTime + "<br>");
//    out.print(airplaneName + "<br>");
//    out.print(flightID + "<br>");
//    out.print(radio + "<br>");
//    out.print(airplaneID + "<br>");
//    out.print(price + "<br>");
//    out.print(businessPrice + "<br>");
//    out.print(baggage);
%>

<style>
    body, h1, h2, h3, h4, h5, h6 {
        font-family: "Lato", sans-serif
    }

    .w3-bar, h1, button {
        font-family: "Montserrat", sans-serif
    }

    /*Bakgrunn på toppen*/
    .w3-red, .w3-hover-red:hover {
        color: #ffffff !important;
        background-color: #ffffff !important;
        /*background-image: url(https://source.unsplash.com/1920x1080?landscape);*/
        background-image: url(http://cdn.cnn.com/cnnnext/dam/assets/181128110146-12-norway-skiing-travel.jpg);
        height: 700px;
    }

    /*Button*/
    .w3-black, .w3-hover-black:hover {
        color: #034a06 !important;
        background-color: #fff !important;
    }

    th, td {
        padding: 15px;
    }

    .buttom {
        margin: 0;
        position: absolute;
        top: 70%;
        left: 45%;
    }

</style>

<body class="w3-red">

<div class="wrapper">
    <div class="qr_code">
        <img src="./images/mountains-hero.jpg" alt="QR_code">
    </div>
    <div class="content">
        <div class="location">
            <div class="item">
                <h1><% out.print(departureName);%></h1>
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
                <h4 class="w3-small" style="color: dimgrey">passenger</h4>
                <p class="w3-small" style="color: dimgrey">${username}</p>
            </div>
            <div class="item">
                <h4 class="w3-small" style="color: dimgrey">flight</h4>
                <p class="w3-small" style="color: dimgrey"><% out.print("FG - " + flightID); %></p>
            </div>
            <div class="item">
                <h4 class="w3-small" style="color: dimgrey">Class</h4>
                <p class="w3-small" style="color: dimgrey"><% out.print(radio); %></p>
            </div>
            <div class="item">
                <h4 class="w3-small" style="color: dimgrey">Baggage</h4>
                <p class="w3-small" style="color: dimgrey"><% out.print(baggage); %></p>
            </div>
            <div class="item">
                <h4 class="w3-small" style="color: dimgrey">airplane</h4>
                <p class="w3-small" style="color: dimgrey"><% out.print(airplaneName); %></p>
            </div>
        </div>
    </div>
</div>


<%--
Form which takes the user from confirmation page to Controller servlet to add database values to
a reservation.
 --%>
<div>
<form action="BookingController" method="post" class="buttom" style="">

    <input type="submit" class="w3-button w3-white w3-xxlarge w3-auto " value="Confirm and pay!">
    <input type="hidden" name="depName" value="<%out.print(departureName);%>">
    <input type="hidden" name="flightID" value="<%out.print(flightID);%>">
    <input type="hidden" name="userName" value="${username}">
    <input type="hidden" name="airplane" value="<% %>">
    <input type="hidden" name="radio" value="<%out.print(radio);%>">
    <input type="hidden" name="airplaneID" value="<% out.print(airplaneID); %>">
    <input type="hidden" name="price" value="<% out.print(price); %>">
    <input type="hidden" name="arrival" value="<% out.print(arrivalName); %>">
    <input type="hidden" name="businessPrice" value="<% out.print(businessPrice); %>">
    <input type="hidden" name="baggage" value="<% out.print(baggage); %>">

    <input type="hidden" value="book" name="action">
</form>
</div>

</body>
</html>
