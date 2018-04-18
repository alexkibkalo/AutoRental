<%--
  Created by IntelliJ IDEA.
  User: Alex_WORKOUT
  Date: 25.01.2018
  Time: 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCar</title>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>
    <form action="/app/add-car" enctype="multipart/form-data" method="POST">
        <br><b>Model: </b><input type="text" name="model"> ;</br>
        <br><b>Price: </b><input type="text" name="price"> UAH;</br>
        <br><b>Power: </b><input type="text" name="power"> l;</br>
        <br><b>Fuel Consumption: </b><input type="text" name="fc"> l/100km</br>
        <br><b>Quality class: </b><select name="qc">
            <option selected="selected">Econom</option>
            <option>Medium</option>
            <option>Business</option>
        </select>;</br>
        <br><b>Image: </b><input type="file" name="img"/></br>
        <br><input type="submit" value="Add Car" formaction="/app/add-car">
    </form>
</body>
</html>
