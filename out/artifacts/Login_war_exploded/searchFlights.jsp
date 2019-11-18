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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="username" value="${username}" scope="session"/>


<head>
    <title>Flights</title>
    <html lang="en">
    <title>Viking Airways</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    //Bootstrap test
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

        .w3-red, .w3-hover-red:hover {
            color: #ffffff !important;
            background-color: #ffffff !important;
            /*background-image: url(https://source.unsplash.com/1920x1080?landscape);*/
            background-image: url(http://www.graciaviva.cat/png/big/4/45364_beautiful-sky-background.png);
            height: 1000px;
        }

        .table1 {
            background: rgba(255, 255, 255, 0.5);
            position: absolute;
            top: 50%;
            left: 50%;
            margin-right: -50%;
            transform: translate(-50%, -50%)
        }

    </style>

<body>


<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
           href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i
                class="fa fa-bars"></i></a>
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white w3-hover-grey">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey w3-grey">Book</a>
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


<header class="w3-container w3-red w3-center" style="padding:128px 16px">
    <h1 class="w3-margin w3-xxlarge" style="text-shadow:1px 1px 0 #444">Available flights from ${from} to ${to}</h1>
    <H2 class="w-3-margin w3-xlarge"></H2>
    <table class="w3-table-all w3-card-4 w3-hoverable">

        <table class="w3-table-all w3-card-4 w3-hoverable">
            <thead>
            <tr>
                <th>Departure</th>
                <th>Arrival</th>
                <th>Takeoff</th>
                <th>Landing</th>
                <th>Airplane</th>
                <th>Price</th>
                <th>Class</th>
                <th>Baggage</th>

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
                        <td>${item.price * 2} kr <br> ${item.price} kr</td>
                        <td><input type="radio" name="radio" value="Business">Business <br> <input type="radio" name="radio"
                                                                                                   value="Economy">Economy
                        </td>
                        <td>
                            <select name="baggage">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </td>

                        <input type="hidden" name="departureName" value="${item.departureName}">
                        <input type="hidden" name="arrivalName" value="${item.arrivalName}">
                        <input type="hidden" name="departureTime" value="${item.departureTime}">
                        <input type="hidden" name="arrivalTime" value="${item.arrivalTime}">
                        <input type="hidden" name="airplaneName" value="${item.airplaneName}">
                        <input type="hidden" name="flightID" value="${item.flightID}">
                        <input type="hidden" name="airplaneID" value="${item.airplaneID}">
                        <input type="hidden" name="price" value="${item.price}">
                        <input type="hidden" name="businessPrice" value="${item.price * 2}">


                        <td>
                            <form><input type="submit" name="knapp" class="btn btn-primary" value="Choose"/></form>
                        </td>

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