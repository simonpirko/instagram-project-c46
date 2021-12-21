<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Feed</title>
</head>
<body>
<p>allPosts</p>
<c:forEach var="postList"  items="${requestScope.allPosts}" >
    <div>
        <a href="/post?id=${postList.getId()}"><c:out value="${postList.title}"/></a>
        <c:out value="${postList.user.userName}   ${postList.description}    ${postList.dateOfCreation}"/>
    </div>
</c:forEach>
</body>
</html>