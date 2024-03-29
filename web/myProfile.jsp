<%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 21/10/2019
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<title>Viking Airways</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body, h1, h2, h3, h4, h5, h6 {
        font-family: "Lato", sans-serif
    }

    .w3-bar, h1, button {
        font-family: "Montserrat", sans-serif
    }

    .login-page {
        text-align: center;
    }

    .bookingButton {
        text-align: justify;
    }

    body {
        background: #76b852; /* fallback for old browsers */
        background: -webkit-linear-gradient(right, #76b852, #8DC26F);
        background: -moz-linear-gradient(right, #76b852, #8DC26F);
        background: -o-linear-gradient(right, #76b852, #8DC26F);
        background: linear-gradient(to left, #76b852, #8DC26F);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        background-image: linear-gradient(to top, #96fbc4 0%, #f9f586 100%);
        background-image: url(http://cdn.cnn.com/cnnnext/dam/assets/181128110146-12-norway-skiing-travel.jpg);
    }

</style>

<body>


//Sets the session
<c:set var="username" value="${username}" scope="session"/>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>


<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-white w3-card w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
           href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i
                class="fa fa-bars"></i></a>
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-white w3-hover-grey">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey>Book"> Book </a>
        <a href="travelinfo.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Travel
            info</a>
        <a href="contactus.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Contact
            us</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey">Login</a>
        <a Welcome class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey"> Welcome ${username}</a>
        <a href="Logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey" name="WelcomeBar">Log
            out</a>
        <a href="myProfile.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-grey w3-grey"
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

<div class="bookingButton w3-center ">
    <br> <br>
    <form action="BookingController" method="post">
        <input type="submit" value="My flights" class="w3-button w3-white w3-padding-large w3-large w3-margin-top "
               style="text-shadow:1px 1px 0 #444; width: 20% "/>
        <input type="hidden" value="myFlights" name="action">
        <input type="hidden" name="userName" value="${username}">
    </form>
</div>


<div class="login-page">
    <h1 style="color:whitesmoke; text-shadow:1px 1px 0 #444">Update your profile</h1> <br>
    <form action="CustomerController" method="post" class="login-form">
        <input type="text" placeholder="First name" name="FirstName"/>
        <input type="hidden" value="editFirstName" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>

    <form action="CustomerController" method="post" class="login-form">
        <input type="text" placeholder="Last name" name="LastName"/>
        <input type="hidden" value="editLastName" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>

    <form action="CustomerController" method="post" class="login-form">
        <input type="text" placeholder="Email" name="Email"/>
        <input type="hidden" value="editMail" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>

    <form action="CustomerController" method="post" class="login-form">
        <input type="password" placeholder="Password" name="PasswordLogin"/>
        <input type="hidden" value="editPassword" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>

    <form action="CustomerController" method="post" class="login-form">
        <input type="text" placeholder="DD/MM/YYYY" name="DoB"/>
        <input type="hidden" value="editDOB" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>

    <form action="CustomerController" method="post" class="login-form">
        <input type="text" placeholder="Phone" name="PhoneNumber"/>
        <input type="hidden" value="editPhone" name="action">
        <input type="hidden" name="userName" value="${username}">
        <button>Edit</button>
    </form>

    <br>
    <h4>${notification} </h4>
    <input type="hidden" value="${username}" name="username"/> <br>
    </form>
</div>

</body>
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

</body>
</html>