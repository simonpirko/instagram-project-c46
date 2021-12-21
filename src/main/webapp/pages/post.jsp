<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<p>Post</p>
<form action="/post" method="get">
    <div>
        <p>${requestScope.post.user.userName} ${requestScope.post.title} ${requestScope.post.description} ${requestScope.post.dateOfCreation}</p>
    </div>
</form>

<c:if test="${sessionScope.user.id == requestScope.post.user.id}">
    <a href="/editpost?id=${requestScope.post.id}">edit this post</a>
</c:if>

<c:if test="${sessionScope.user.id == requestScope.post.user.id}">
    <a href="/deletepost?id=${requestScope.post.id}">delete this post</a>
</c:if>

<a href="/feed">return to feed</a>
</body>
</html>