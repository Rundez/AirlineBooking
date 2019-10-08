<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Flight" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 27/09/2019
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="username" value="${username}" scope="session"/>


<head>
    <title>Flights</title>
    <html lang="en">
    <title>Viking Airways</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif;}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        h4{font-size: 30px; padding-left: 20px}

        /*Bakgrunn på toppen*/
        .w3-red, .w3-hover-red:hover {
            color: #fff!important;
            background-image: linear-gradient(to top, #96fbc4 25%, #f9f586 100%);
            height: 750px;

        }

        .w3-black, .w3-hover-black:hover {
            color: #034a06!important;
            background-color: #fff!important;
        }
        .grid-container > div {
            background-color: rgba(255, 255, 255, 0.8);
            border: 1px solid black;
            text-align: center;
            font-size: 20px;
            width: 50%;

        }
        .grid-container {
            display: grid;
            grid-template-columns: auto;
            grid-gap: 10px;
            padding: 10px;

            align-items: center;
        }
        th, td {
            padding: 15px;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

    </style>
<body>


<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white w3-hover-grey">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey w3-grey">Book</a>
        <a href="mybookings.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">My bookings</a>
        <a href="travelinfo.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Travel info</a>
        <a href="contactus.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Contact us</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Login</a>
        <a Welcome class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey"> Welcome ${username}</a>
        <a href="Logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey" name="WelcomeBar">Log out</a>

    </div>



<% /*
    <form action="bookFlight.jsp">
        <div class="grid-container">
            <div>From: ${item.departureName} <br> Date and time: ${item.departureTime} <br> Airplane: ${item.airplaneName} <br><br>
                 To: ${item.arrivalName} <br> Date and time: ${item.arrivalTime} <br> Airplane: ${item.airplaneName} <br> <br>
                <button name="select" type="submit">Select flight</button>
            </div>
        </div>
    </form>
    */
%>


    <body>
    <h2>Available flights from ${from} to ${to}</h2>

    <table>
        <thead>
        <tr>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Takeoff</th>
            <th>Landing</th>
            <th>Airplane</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="item">
            <form action="bookFlight.jsp" method="post">
            <tr>
                <td>${item.departureName}</td>
                <td>${item.arrivalName}</td>
                <td>${item.departureTime}</td>
                <td>${item.arrivalTime}</td>
                <td>${item.airplaneName}</td>

                <c:set var="flight" value="${item.airplaneName}" scope="session"/>
                <td><form><input type="submit" value="Choose"/></form></td>
            </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
    </body>
    </html>




</div>

<script>
    // Used to toggle the menu on small screens when clicking on the menu button
    function myFunction() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>