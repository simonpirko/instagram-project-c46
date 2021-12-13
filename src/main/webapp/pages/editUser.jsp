<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12.12.2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>Edit User</title>
</head>
<body>
<form action="<c:url value="/editUser?id=${param.id}"/>" method="post">
    <table style="background-color: #e3d6c9; margin-left: 500px; margin-top: 50px">
        <tr>
            <td>
                <h3 style="color: black;">EDIT PAGE...</h3>
            </td>
            <td></td>
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
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<div class="ref">
    <p><a href="<c:url value="/userProfile"/>">RETURN TO USER PROFILE...</a></p>
</div>
</body>
</html>
