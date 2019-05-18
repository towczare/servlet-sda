<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${viewHeader}</title>
</head>
<body>
    <h4>${viewHeader}</h4>
    <form name="name-collector-form" method="post" action="/animal-servlet/">
        Animal Name
        <c:choose>
            <c:when test="${not empty animalFormData}">
                <input type="text" name="animalName"
                       value="${animalFormData.name}" /> <br/>
            </c:when>
            <c:otherwise>
                <input type="text" name="animalName"/> <br/>
            </c:otherwise>
        </c:choose>

        Animal Type:
        <select name="animalType">
            <c:forEach items="${animalTypes}" var="type">
                <c:choose>
                    <c:when test="${(not empty animalFormData) and (animalFormData.type eq type)}">
                        <option value="${type}" selected>${type.label}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${type}">${type.label}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br/>
        <input type="submit" value="${action eq 'edit' ? 'Save animal' : 'Add animal'}" />
    </form>

    <a href="/animal-servlet/" >Back to animal list!</a>
</body>
</html>
