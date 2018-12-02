<%@ page import="ua.nure.kibkalo.beans.Car" %>
<%@ page import="ua.nure.kibkalo.database.DAO.Car.CarDaoImpl" %>
<%@ page import="ua.nure.kibkalo.utils.CarFilter" %>
<%@ page import="ua.nure.kibkalo.utils.SomeActions" %>
<%@ page import="ua.nure.kibkalo.utils.Sorts" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.TreeSet" %><%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 24.01.2018
  Time: 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Car> list = new CarDaoImpl().findAllCar();
    list = new Sorts().sortByName(list);
    if(request.getParameter("select") != null) {
        if (request.getParameter("select").equals("Select by name")) {
            if (request.getParameter("select_n") != null) {
                list = new CarFilter().CarsSelectByName(list, request.getParameter("select_n"));
            }
        } else if (request.getParameter("select").equals("Select by quality class")) {
            if (request.getParameter("select_qc") != null) {
                list = new CarFilter().CarsSelectByQualitClass(list, request.getParameter("select_qc"));
            }
        }
    }
    session.setAttribute("currentCarList", list);
%>
<html>
<head>
    <title>AutoRENTAL.ua</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/user.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>

<%
    if (request.getParameter("username") != null) {
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("count", new SomeActions().getCountAcrossName(request.getParameter("username")));
    }
%>

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
<div class="sort_and_select">
    <form action="EnterForm" method="POST">
        <b>Sort: </b><select name="sort">
        <option value="Sort by price">Sort by price</option>
        <option value="Sort by name">Sort by name</option>
    </select>
        <b>Select: </b><select name="select">
        <option selected="selected"> </option>
        <option>Select by name</option>
        <option>Select by quality class</option>
    </select>
        <b>Select Name: </b><select name="select_n">
        <option selected="selected"> </option>
        <% Set<String> set = new TreeSet<>();
            for(Car car : new CarDaoImpl().findAllCar()) {
                String[] model = car.getModel().split("\\s");
                set.add(model[0]);
            }
        %>
        <%for(String model : set){%>
        <option><%=model%></option><br>
        <%}%>
    </select>
        <b>Select Quality class: </b><select name="select_qc">
        <option selected="selected"> </option>
        <option>Econom</option>
        <option>Medium</option>
        <option>Business</option>
    </select>
        <input type="submit" value="Apply" formaction="/app/sorted-selected"/>
    </form>
</div>
<div class="car-park">
    <h3>Car Park</h3>
</div>
<div class="cars-list">
    <ul>
        <% for(Car car : list){%>
        <div class="cars_info">
            <div class="cars_title">
                <form action="PageCarRegistration.jsp" method="POST">
                    <input type="radio" name="Model" value="<%=car.getModel()%>"><b>Model: <%=car.getModel()%></b>
                    <h4>Price: <%=car.getPrice()%> UAH</h4>
                    <h4>Fuel consumption: <%=car.getFuel_consumption()%> liters/100km</h4>
                    <h4>Power: <%=car.getPower()%> liters;</h4>
                    <input type="submit" value="Go to car registration"></form>
                <a href="PageCarRegistration.jsp">
                    <img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(car)%>" width="600" height="400" alt="Обложка"/>
                </a>
            </div>
        </div>
        <% } %>
    </ul>
</div>

</body>
</html>