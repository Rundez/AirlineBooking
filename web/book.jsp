<%@ page import="java.sql.*, javax.servlet.jsp.jstl.*" %>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<




<html lang="en">
<title>Viking Airways</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
    .w3-bar,h1,button {font-family: "Montserrat", sans-serif}


    /*Bakgrunn på toppen*/
    .w3-red, .w3-hover-red:hover {
        color: #fff!important;
        background-image: linear-gradient(to top, #96fbc4 25%, #f9f586 100%);
        height: 600px;

    }


    .w3-black, .w3-hover-black:hover {
        color: #034a06!important;
        background-color: #fff!important;
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
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">VA</a>
        <a href="book.jsp" class="w3-bar-item w3-button w3-padding-large">Book</a>
        <a href="mybookings.jsp" class="w3-bar-item w3-button w3-padding-large">My bookings</a>
        <a href="travelinfo.jsp" class="w3-bar-item w3-button w3-padding-large">Travel info</a>
        <a href="contactus.jsp" class="w3-bar-item w3-button w3-padding-large">Contact us</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-padding-large">Login</a>
    </div>
</div>



<%--<sql:setDataSource var="ds"--%>
                   <%--driver="com.mysql.jdbc.Driver"--%>
                   <%--url="jdbc:mysql://<localhost:3306>/<java>"--%>
                   <%--user="<root>"--%>
                   <%--password="<gruppe14>"/>--%>

<%--<sql:query dataSource="${ds}" var="result"> //ref  defined 'ds'--%>
<%--SELECT * from <Destination>;--%>
    <%--</sql:query>--%>


<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
    <h1 class="w3-margin w3-jumbo">Book your flight</h1>
    <p class="w3-xxlarge">Choose your destinations</p>

    <div class="container">
        <form>
            <P></P>
            <div class="input-fields">
                <%
                    try{//Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection connection =
                                DriverManager.getConnection
                                        ("jdbc:mysql://localhost/java?user=root&password=");

                        Statement statement = connection.createStatement() ;

                        resultset =statement.executeQuery("select * from java.destination") ;
                %>

                <center>

                <select>
                    <%  while(resultset.next()){ %>
                    <option><%= resultset.getString(2)%></option>
                    <% } %>
                </select>


                </center>

                <%
                        //**Should I input the codes here?**
                    }
                    catch(Exception e)
                    {
                        out.println("wrong entry"+e);
                    }
                %>

            </div>

        </form>


        <p></p>
        <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top">Search flights</button>

</header>




<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
    <div class="w3-content">
        <div class="w3-twothird">
            <h1>Low Fare Calendar</h1>
            <h5 class="w3-padding-32">Discover great flights around the world with reasonable price.</h5>

            <img src="https://www.sapmer.com/wp-content/uploads/2015/12/header-SAPMER-paris-1024x482.jpg" width=1024 height=482>

            <p class="w3-text-grey"> </p>
        </div>

        <div class="w3-third w3-center">

        </div>
    </div>
</div>

<!-- Second Grid -->
<div class="w3-row-padding w3-light-grey w3-padding-64 w3-container">
    <div class="w3-content">
        <div class="w3-third w3-center">
            <img src="http://www.pngmart.com/files/7/Earth-Globe-PNG-File.png" width=293 height=258 >
        </div>

        <div class="w3-twothird">
            <h1>Find your destination</h1>
            <h5 class="w3-padding-32">We offer to fly you to variety of differnet places around the world.</h5>

            <p class="w3-text-grey">Take the next shopping trip to London (hyperlinked)</p>
        </div>
    </div>
</div>

<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Viking Airways - Takes you where you need to go!</h1>
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
    <div class="w3-xlarge w3-padding-32">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">Gruppe14</a></p>
</footer>

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

