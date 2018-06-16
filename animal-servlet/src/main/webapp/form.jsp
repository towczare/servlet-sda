<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomic
  Date: 10.06.18
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title><c:out value="${not empty action ? 'Edit Animal' : 'Add Animal'}" />
    </title>
</head>
<body>

  <h1>
    <c:out value="${edit ? 'Edit Animal' : 'Add Animal'}" />
  </h1>

  <form method="post" action="/animal-servlet/" class="w3-container">
    <label>Name of animal</label>
    <input type="text" name="animalName" class="w3-input" value="${not empty animal ? animal.getName() : ''}" />

    <select name="animalType" class="w3-input">
      <c:forEach items="${animalTypes}" var="animalType">
        <c:choose>
          <c:when test="${not empty animal and not empty animal.getType()}">
            <option value="${animalType}" selected>${animalType.getName()}</option>
          </c:when>
          <c:otherwise>
            <option value="${animalType}">${animalType.getName()}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select>

    <label>Url to picture of animal</label>
    <c:if test="${not empty animal and not empty animal.getImageUrl()}">
      <img src="${animal.getImageUrl()}" width="250" height="250" />
    </c:if>
    <input type="text" name="animalUrl" class="w3-input" value="${not empty animal ? animal.getImageUrl() : ''}"/>

    <label>Description of animal</label>
    <textarea name="animalDescription" rows="4" cols="50" class="w3-input" >
      <c:out value="${not empty animal and not empty animal.getDescription() ? animal.getDescription() : ''}" />
    </textarea>

    <label>Age of animal</label>
    <input type="number" step="1" name="animalAge" class="w3-input" value="${not empty animal ? animal.getAge() : ''}"/>

    <input type="submit" value="${edit ? 'Save Changes' : 'Add Animal'}" class="w3-btn"/>
    <a href="/animal-servlet" class="w3-btn w3-blue-grey">Back to list</a>
  </form>
</body>
</html>
