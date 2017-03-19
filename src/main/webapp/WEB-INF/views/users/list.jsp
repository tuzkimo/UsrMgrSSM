<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>users</title>
</head>
<body>
    <h2>Users</h2>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
