<%--
  Created by IntelliJ IDEA.
  User: martinruud
  Date: 22/10/2019
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="username" value="${username}" scope="session"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
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




<table>
<thead>
     <tr>
         <th>Departure</th>
         <th>Arrival</th>
         <th>Takeoff</th>
         <th>Landing</th>
         <th>Airplane</th>
         <th>FlightID</th>
    </tr>
</thead>

<tbody>
<c:forEach items="${list}" var="item">
    <tr>
    <td>${item.departureName}</td>
    <td>${item.arrivalName}</td>
    <td>${item.departureTime}</td>
    <td>${item.arrivalTime}</td>
    <td>${item.airplaneName}</td>
    <td>${item.flightID}</td>
    </tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
