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
    <title>Edit User</title>
    <link href="<c:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
    <base href="<c:url value="/"/>">
</head>
<body>
<div class="main">
    <h2 class="title"><span>Edit User</span></h2>
    <form:form action="editSave" modelAttribute="user">
        <fieldset>
            <legend>user</legend>
            <form:hidden path="id"/>
            <p>
                <label for="name">Name: </label>
                <form:input path="name"/>
                <form:errors path="name" cssClass="error"/>
            </p>
            <p>
                <label for="password">Password: </label>
                <form:password path="password"/>
                <form:errors path="password" cssClass="error"/>
            </p>
            <p>
                <label for="description">Description: </label>
                <form:textarea path="description"/>
                <form:errors path="description" cssClass="error"/>
            </p>
            <p>
                <input class="btn out" type="submit" value="save">
            </p>
        </fieldset>
    </form:form>
    <p>
        <a class="abtn out" href="/">Return</a>
    </p>
    <script src="<c:url value="/scripts/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/scripts/validator.js"/>"></script>
</div>
</body>
</html>
