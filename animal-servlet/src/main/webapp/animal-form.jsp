<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Animal Form</title>
</head>
<body>
    <h4>Add new Animal</h4>
    <form name="name-collector-form" method="post" action="/animal-servlet/">
        Animal Name <input type="text" name="animalName"/> <br/>
        Animal Type
        <select name="animalType">
            <c:forEach items="${animalTypes}" var="type">
                <option value="${type}">${type.label}</option>
            </c:forEach>
        </select><br/>
        <input type="submit" value="Add animal" />
    </form>

    <a href="/animal-servlet/" >Back to animal list!</a>
</body>
</html>
