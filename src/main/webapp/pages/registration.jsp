<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 1.12.21
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="reg" method="post">
    <div>
        <input name="userName" type="text" placeholder="Username">
        <input name="email" type="email" placeholder="Email">
        <input name="password" type="password" placeholder="Password">
    </div>
    <div>
        <input name="firstName" type="text" placeholder="First name">
        <input name="lastName" type="text" placeholder="Last name">
        <input name="birthDate" type="date">
        <input name="country" type="text" placeholder="Country">
        <input name="biography" type="text" placeholder="About you">
    </div>
    <button>Submit</button>
</form>
</body>
</html>
