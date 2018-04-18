<%@ page import="ua.nure.kibkalo.beans.Car" %>
<%@ page import="ua.nure.kibkalo.database.DAO.Car.CarDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 25.01.2018
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DeleteCar</title>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>
<%List<Car> list = new CarDaoImpl().findAllCar();
    request.setAttribute("list", list);%>
<form action="/app/delete-car" method="POST">
    <br><b>Model: </b><select name="model">
        <c:forEach items="${list}" var="car">
            <option><c:out value="${car.model}"/></option>
        </c:forEach>
</select></br>
    <br><input type="submit" value="Delete Car" formaction="/app/delete-car">
</form>
</body>
</html>
