<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<p>Post</p>
<form action="/post" method="get">
    <div>
        <p>${requestScope.post}</p>
    </div>
</form>
</body>
</html>