<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreatePost</title>
</head>
<body>
<form action="/createpost" method="post">
    <input type="text" name = "title" placeholder="title">
    <input type="text" name = "description" placeholder="description">
    <button>Do Post</button>
</form>
<form action="/feed" method="get">
    <button>feed</button>
</form>
</body>
</html>