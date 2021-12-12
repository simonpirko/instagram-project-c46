<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 10.12.2021
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-in</title>
</head>
<body>
<form action="sign-in" method="post">
    <div>
        <input name="email" type="email" placeholder="Email">
        <input name="password" type="password" placeholder="Password">
        <button>Submit</button>
    </div>
</form>
<p>${requestScope.signInErrorMessage}</p>
</body>
</html>
