<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${viewHeader}</title>
</head>
<body>
    <h1>${viewHeader}</h1>

    <table border="2px">
        <tr>
            <th>Id</th>
            <th>Animal name</th>
            <th>Animal type</th>
            <th>Details</th>
            <th>Edit</th>
        </tr>

        <c:forEach items="${animals}" var="animal" >
            <tr>
                <td>${animal.id}</td>
                <td>${animal.name}</td>
                <td>${animal.type}</td>
                <td><a href="/animal-servlet/animal?animalId=${animal.id}">See details of ${animal.name}</a></td>
                <td><a href="/animal-servlet/edit?animalId=${animal.id}">Edit ${animal.name}</a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/animal-servlet/add" >Add new Animal!</a>
</body>
</html>
