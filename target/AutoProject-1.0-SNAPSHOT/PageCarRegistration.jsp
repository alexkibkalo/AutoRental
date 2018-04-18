<%@ page import="ua.nure.kibkalo.beans.Car" %>
<%@ page import="ua.nure.kibkalo.database.DAO.Car.CarDaoImpl" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 18.01.2018
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>AutoRENTAL.ua</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/user.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>

<%
    List<Car> list_car = new CarDaoImpl().findAllCar();
%>
<div class="localization">
    <select name="local">
        <option selected="selected">English</option>
        <option>Русский</option>
    </select>
</div>
<div class="header">
    <div class="descr">
        <h1>AutoRENTAL.ua</h1>
    </div>
    <div class="cars">
        <h5> Welcome, <%=session.getAttribute("username")%>,
            <br><h5>your count: <%=session.getAttribute("count")%> UAH</h5></br>
            <h5><a href="PageLogIn.jsp">Logout</a></h5>
        </h5>
    </div>
</div>

<div class="top-menu">
    <ul>
        <li><a href="PageCarPark.jsp"><b>CAR PARK</b></a></li>
        <li><a href="PageCarRegistration.jsp"><b>CAR REGISTRATION</b></a></li>
        <li><a href="PageConnectWithUs.jsp"><b>CONNECT WITH US</b></a></li>
    </ul>
</div>
<h3>Please, enter info about you:</h3>
<div class="registration-car">
    <form action="/app/reg_car" method="POST">
        <b>Model: </b><select name="Model">

        <%
            session.setAttribute("currentCarList", list_car);
            for(Car car : list_car){
                if(car.getModel().equals(request.getParameter("Model"))){
        %>
            <option selected="selected"><%=car.getModel()%></option><br>
            <% }else{ %>
            <option><%=car.getModel()%></option><br>
            <% } %>
        <% } %>
        </select>
        </br></br>
        <b>Name:</b> <input type="text" name="Name">;</br></br>
        <b>Surname:</b> <input type="text" name="Surname">;</br></br>
        <b>Email:</b> <input type="text" name="Email">;</br></br>
        <b>Passport data (Series and number):</b> <input type="text" name="Passport">;</br></br>
        <b>Driver Availability:</b> <input type="radio" name="driver" value="With driver">With driver
        <input type="radio" name="driver" value="Without driver">Without driver</br></br>
        <b>Term of lease:</b> <input type="number" value="1" min="1" name="amount_of_day"> day;
        </br></br>
        <input type="submit" value="Enter">
        <br><br>
        <h6>If you take a car for 1-3 days, the price is normal,
            if for 4-7 days, a 5% discount,
            if more than 7 days, a 10% discount.
            If with driver + 100 UAH 1 day.
            Pleasant use!</h6>
    </form>
</div>
</body>
</html>