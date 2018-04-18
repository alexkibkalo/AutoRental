<%@ page import="ua.nure.kibkalo.beans.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.nure.kibkalo.database.DAO.User.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 26.01.2018
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>UnlockUser</title>
</head>
<body>
<% List<User> users = new UserDaoImpl().getAllUser();
    request.setAttribute("users", users);%>
<form action="/app/unlock-user" method="POST">
    <b>Select user: </b><select name="username">
    <c:forEach items="${users}" var="user">
        <option>
            <c:if test="${user.username != 'admin'}">
                <c:out value="${user.username}"/>
            </c:if>
        </option>
    </c:forEach>
</select><br><br>
    <input type="submit" value="Unlock" formaction="/app/unlock-user">
</form>
</body>
</html>
