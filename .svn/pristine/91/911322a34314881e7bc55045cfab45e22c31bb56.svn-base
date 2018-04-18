<%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 24.01.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String name = request.getParameter("Model");
    request.setAttribute("name", name);
    int amount_of_day = Integer.parseInt(request.getParameter("amount_of_day"));
    request.setAttribute("amount_of_day", amount_of_day);
%>
<html>
<head>
    <title>Info</title>
    <link rel="icon" type="Images/CAR.png" href="../Images/CAR.png"/>
</head>
<body>
<h2>Successfully registered! Your car: <c:out value="${name}"></c:out> is taken for
    <c:out value="${amount_of_day}"></c:out> days! Pleasant use!</h2>
</body>
</html>
