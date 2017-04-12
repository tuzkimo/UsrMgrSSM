<%--
  Created by IntelliJ IDEA.
  User: tuzkimo
  Date: 2017-03-24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Upload Photo</title>
    <link href="<c:url value="/style/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <h2 class="title"><span>Upload Photo</span></h2>
    <form action="<c:url value="/upPhotoSave/${user.id}"/>" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Photo</legend>
            <p>
                <label>Name: </label> ${user.name}
            </p>
            <p>
                <label>Description: </label> ${user.description}
            </p>
            <p>
                <label for="photo">Photo: </label><input type="file" name="photo" id="photo"/>
            </p>
            <p>
                <input type="submit" value="upload"/>
            </p>
        </fieldset>
    </form>
    <p class="error">${message}</p>
    <p>
        <a class="abtn" href="<c:url value="/"/>">Return</a>
    </p>
</div>
</body>
</html>
