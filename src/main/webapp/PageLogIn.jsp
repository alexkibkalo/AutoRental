<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auto Shop</title>
    <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="Images/CAR.png" href="Images/CAR.png"/>
</head>
<body>

<%if (request.getParameter("session")!=null && request.getParameter("session").equals("0")) {
    session.invalidate();
    request.getSession(true);
} %>

<style>
    body {
        background: #bc854b;
        color: #000000;
    }
</style>

<div class="login">
    <p class="title">Enter your login and password:</p>
    <form class="login_form" action="/app/enter" method="POST">
        Login: <pre><input type="text" name="username"></pre>
        Password: <pre><input type="password" name="userpass"/></pre>
        <input type="submit" value="Sign in">
        <input type="submit" formaction="/app/registration.do" value="Registration">
    </form>
</div>
<div class="footer">
    Developer: Alex Kibkalo, 2018
</div>
</div>
</body>
</html>

