<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13.12.2021
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>Account</title>
</head>
<body>
<h1 align="center"> ACCOUNT PAGE</h1><br><br>

<div class="ref">
    <p><a href="<c:url value="/editUser?id=${sessionScope.user.id}"/>">Edit confidential date</a></p>
    <p><a href="<c:url value="/userProfile"/>">RETURN TO USER PROFILE...</a></p><br><br>

    <p><a href="<c:url value="/logout"/>">LOGOUT...</a></p>
</div>
</body>
</html>
