<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12.12.2021
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>Edit User Profile</title>
</head>
<body>
<form action="<c:url value="/editUserProfile?id=${param.id}"/>" method="post">
    <table style="background-color: #e3d6c9; margin-left: 500px; margin-top: 50px">
        <tr>
            <td>
                <h3 style="color: black;">EDIT PAGE..</h3>
            </td>
            <td></td>
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
            <td><input type="date" name="birthDate" required></td>
        </tr>

        <tr>
            <td>Country: </td>
            <td><input type="text" name="country" required></td>
        </tr>

        <tr>
            <td>Biography: </td>
            <td><input type="text" name="biography" required></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<div class="ref">
    <p><a href="<c:url value="/userProfile"/>">RETURN TO USER PROFILE...</a></p>
</div>
</body>
</html>
