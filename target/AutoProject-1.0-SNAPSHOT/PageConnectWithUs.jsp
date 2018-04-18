<%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 18.01.2018
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>AutoRENTAL.ua</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/user.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>
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
<div class="mail">
    <form action="/app/connectWithUs" method="POST">
        <h3>For connect with us (enter message and your email):</h3><br>
        <b>Your Email: </b><input type="text" name="email"><br><br>
        <b>Your Password from Email: </b><input type="password" name="password"><br><br>
        <b>Subject: </b><input type="text" name="subject"><br><br>
        <b>Text: </b><textarea type="text" name="text"  rows=5 cols=45></textarea><br><br>
        <input type="submit" value="Send Message"><br>
    </form>
    <br><br>
</div>
<div class="title-damaged">
    <h3>Send a letter to the manager about the return of the damaged car:</h3>
</div>
<div class="mail-damaged">
    <form action="/app/connectWithManager" method="POST">
        <b>Your name (as a user): </b><br>
        <br><label>
        <input type="text" name="username" value="<%=session.getAttribute("username")%>">
    </label><br>
        <br><b>Select the state of the car:</b><br>
        <br><label>
        <select name="returnCar">
            <option>Scratch on the car</option>
            <option>Spotlight rear/front</option>
            <option>Crash in the side</option>
            <option>Accident</option>
        </select>
    </label><br><br>
        <input type="submit" value="Enter">
    </form>
</div>
</body>
</html>