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

<c:forEach items="${list}" var="item">
    ${item}

</c:forEach>

</body>
</html>
