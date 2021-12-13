<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12.12.2021
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="../style/style.css"/>
    <title>User Profile</title>
</head>
<body>
<section class="profile">
    <header class="header">
        <div class="details">
            <h1 class="heading">@${sessionScope.user.userName}</h1>
            <img src="https://phonoteka.org/uploads/posts/2021-05/1620660677_10-phonoteka_org-p-fon-gori-ozero-12.jpg" alt="John Doe" class="profile-pic">
            <h2>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h2>
            <h4>${sessionScope.user.biography}</h4>
            <div class="location">
                <svg width="18" height="18" viewBox="0 0 24 24" fill="currentColor">
                    <path d="M12,11.5A2.5,2.5 0 0,1 9.5,9A2.5,2.5 0 0,1 12,6.5A2.5,2.5 0 0,1 14.5,9A2.5,2.5 0 0,1 12,11.5M12,2A7,7 0 0,0 5,9C5,14.25 12,22 12,22C12,22 19,14.25 19,9A7,7 0 0,0 12 ,2Z"></path>
                </svg>
                <p>${sessionScope.user.country}</p>
            </div>
            <div class="stats">
                <div class="col-4">
                    <h4>0</h4>
                    <p>Posts</p>
                </div>
                <div class="col-4">
                    <h4>0</h4>
                    <p>Followers</p>
                </div>
                <div class="col-4">
                    <h4>0</h4>
                    <p>Follows</p>
                </div>
            </div>
        </div>
        <div class="ref">
            <p><a href="<c:url value="/account"/>">Account</a></p>
            <p><a href="<c:url value="/editUserProfile?id=${sessionScope.user.id}"/>">Edit profile</a></p>
        </div>
    </header>
</section>
</body>
</html>
