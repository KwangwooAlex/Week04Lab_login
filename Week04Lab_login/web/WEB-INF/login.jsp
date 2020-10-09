<%-- 
    Document   : login
    Created on : Oct 8, 2020, 11:32:10 PM
    Author     : 818396
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" name = "form" action="home">
            <h3>Username: <input type="text" name="username" value="${user__name}"></h3>
            <h3>Password: <input type="password" name="password" value="${user__password}"></h3>
            <input type="submit" value="Log in">
            <p>${message}</p>
            <p>${message2}</p>
        </form>
    </body>
</html>
