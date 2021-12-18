<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>

<form action="/editpost?id=${requestScope.post.id}" method="post">
    <input name="title" type="text" placeholder="title">
    <input name="description" type="text" placeholder="description">
    <button>Edit</button>
</form>

<div>
    <p><a href="/feed">">return to feed</a></p>
</div>
</body>
</html>