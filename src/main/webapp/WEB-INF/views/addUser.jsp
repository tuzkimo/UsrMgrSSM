<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add User</title>
    <link href="<c:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <h2 class="title"><span>Add User</span></h2>
    <form:form action="addSave" modelAttribute="user">
        <fieldset>
            <legend>user</legend>
            <p>
                <label for="name">Name: </label>
                <form:input path="name"/>
            </p>
            <p>
                <label for="password">Password: </label>
                <form:password path="password"/>
            </p>
            <p>
                <label for="description">Description: </label>
                <form:textarea path="description"/>
            </p>
            <p>
                <input class="btn out" type="submit" value="save">
            </p>
        </fieldset>
    </form:form>
    <p>
        <a class="abtn out" href="<c:url value="/"/>">Return</a>
    </p>
</div>
</body>
</html>
