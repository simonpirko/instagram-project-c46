<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Feed</title>
</head>
<body>
<p>allPosts</p>
<c:forEach items="${requestScope.allPosts}" var="postList">
    <c:out value="${postList.id}${postList.title}${postList.description}${postList.dateOfCreation}${postList.userId}"/>
</c:forEach>
</body>
</html>