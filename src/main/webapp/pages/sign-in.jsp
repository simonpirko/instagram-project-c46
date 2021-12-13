<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 10.12.2021
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>Sign-in</title>
</head>
<body>

<form action="<c:url value="/"/>" method="post">
    <table style="background-color: white; margin-left: 450px; margin-top: 80px">
        <tr>
            <td><img src="https://i.imgur.com/zqpwkLQ.png"/></td>
        </tr>

        <tr>
            <td>Email: </td>
            <td><input type="email" name="email" required></td>
        </tr>

        <tr>
            <td>Password: </td>
            <td><input type="password" name="password" required></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="Sign in"></td>
        </tr>

        <tr>
            <td>
                <h3 style="color: #171112;">${requestScope.signInErrorMessage}</h3>
            </td>
            <td></td>
        </tr>
    </table>
    <div class="ref">
        <p align="center">Don't have an account?<a href="<c:url value="/reg"/>">Sign up</a></p>
    </div>
</form>
</body>
</html>
