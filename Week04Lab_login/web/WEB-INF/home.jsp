<%-- 
    Document   : home
    Created on : Oct 8, 2020, 11:31:57 PM
    Author     : 818396
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Home Page</h1>
            <h3>Hello ${user.username}</h3>
            <br>
            <a href="login?logout">Log out</a>
<!--            <form action="login" method="get">
                <input type="submit" name="action" value="Logout">
            </form>-->
            <p>${message}</p>
    </body>
</html>
