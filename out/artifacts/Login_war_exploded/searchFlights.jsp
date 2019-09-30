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

<html>
<head>
    <title>Flights</title>

    <c:forEach items="${list}" var="item">
        ${item.departureTime}<br>
    </c:forEach>


</head>
<body>

</body>
</html>
