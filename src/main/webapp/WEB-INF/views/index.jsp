<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Manager</title>
    <link href="<c:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="main">
        <h2 class="title"><span>User Manager</span></h2>
        <table class="tab">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>photo</th>
                <th>operation</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.description}</td>
                    <td><img src="<c:url value="/photos/${user.photo}"/>" title="${user.name}" alt="${user.name}" style="height: 36px"/></td>
                    <td>
                        <a class="abtn" href="<c:url value="/edit/${user.id}"/>">Edit</a>
                        <a class="abtn" href="<c:url value="/upPhoto/${user.id}"/>">UpPhoto</a>
                        <a class="abtn" href="<c:url value="/delete/${user.id}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>
            <a class="abtn" href="<c:url value="/add"/>">add</a>
        </p>
    </div>
</body>
</html>
