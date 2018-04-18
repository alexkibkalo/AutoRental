<%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 26.01.2018
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddManager</title>
</head>
<body>
    <form action="/app/add-manager" method="POST">
        <b>Name of manager: </b><input type="text" name="login"><br>
        <br><input type="submit" value="Add manager" formaction="/app/add-manager">
    </form>
</body>
</html>
