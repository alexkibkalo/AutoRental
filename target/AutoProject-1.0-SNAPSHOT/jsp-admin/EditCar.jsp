<%@ page import="ua.nure.kibkalo.beans.Car" %>
<%@ page import="ua.nure.kibkalo.database.DAO.Car.CarDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 25.01.2018
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>EditCar</title>
</head>
<body>
    <%List<Car> list = new CarDaoImpl().findAllCar();
    request.setAttribute("list", list);%>
    <form action="/app/edit-car" method="POST">
        <br><b>Old Model: </b><select name="old_model">
        <c:forEach items="${list}" var="car">
            <option><c:out value="${car.model}"/></option>
        </c:forEach>
        </select></br>
        <br><b>New Model: </b><input type="text" name="new_model"><br>
        <br><b>New Price: </b><input type="number" min="1" name="new_price"> UAH<br>
        <br><input type="submit" value="Edit car" formaction="/app/edit-car">
    </form>
</body>
</html>
