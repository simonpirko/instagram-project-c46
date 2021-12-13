<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 1.12.21
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>Registration</title>
</head>
<body>
<form action="<c:url value="/reg"/>" method="post">
    <table style="background-color: white; margin-left: 450px; margin-top: 80px">
        <tr>
            <td><img src="https://i.imgur.com/zqpwkLQ.png"/></td>
        </tr>

        <tr>
            <td>Username: </td>
            <td><input type="text" name="username" required></td>
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
            <td>First name: </td>
            <td><input type="text" name="firstName" required></td>
        </tr>

        <tr>
            <td>Last name: </td>
            <td><input type="text" name="lastName" required></td>
        </tr>

        <tr>
            <td>Birth date: </td>
            <td><input name="birthDate" type="date" required></td>
        </tr>

        <tr>
            <td>Country: </td>
            <td><input name="country" type="text" required></td>
        </tr>

        <tr>
            <td>About you: </td>
            <td><input name="biography" type="text" required></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="Sign up"></td>
        </tr>
    </table>
    <div class="ref">
        <p><a href="<c:url value="/"/>">RETURN TO AUTHORIZATION PAGE...</a></p>
    </div>
</form>
</body>
</html>
