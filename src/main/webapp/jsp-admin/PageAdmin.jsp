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
        <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
    </head>
    <body>
    <h2>Hello, <%=request.getParameter("username")%>! You are logged in as an administrator!</h2>
    <h4>Available actions:</h4>
    <ul>
        <li><a href="jsp-admin/AddCar.jsp">Add car</a></li>
        <li><a href="jsp-admin/DeleteCar.jsp">Delete car</a></li>
        <li><a href="jsp-admin/EditCar.jsp">Edit car</a></li>
        <li><a href="jsp-admin/AddManager.jsp">Add manager</a></li>
        <li><a href="jsp-admin/BlockUser.jsp">Block user</a></li>
        <li><a href="jsp-admin/UnlockUser.jsp">Unlock user</a></li>
    </ul><br>
    <a href="PageLogIn.jsp">Logout</a>
    </body>
    </html>