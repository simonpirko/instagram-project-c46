<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>
<form action="<c:url value="/editpost?id=${param.id}"/>" method="post">
            <a>New description:<a/>
            <div>
            <input type="text" name="title" required>
            </div>

            <a>New title:<a/>
            <div>
                <input type="text" name="description" required>
            </div>

            <input type="submit" name="submit" value="Submit">
</form>

<div class="ref">
    <p><a href="<c:url value="/feed"/>">return to feed</a></p>
</div>
</body>
</html>