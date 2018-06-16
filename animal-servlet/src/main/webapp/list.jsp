<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>See list of animals</title>
</head>
<body>
<c:if test="${not empty msgToUser}">
    <h3><c:out value="${msgToUser}"/></h3>
</c:if>

  <h1>We have ${animalsList.size()} animals</h1>

  <table class="w3-table">
      <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Type</th>
          <th>Details</th>
          <th>Remove</th>
      </tr>
      <c:forEach items="${animalsList}" var="animal">
          <tr>
              <td><c:out value="${animal.getId()}"/></td>
              <td><c:out value="${animal.getName()}"/></td>
              <td><c:out value="${animal.getType()}"/></td>
              <td><a href="edit?animalId=${animal.getId()}" >Edit animal</a> </td>
              <td><a href="details?animalId=${animal.getId()}" >See details</a> </td>
              <td><a href="remove?animalId=${animal.getId()}" >Remove</a> </td>
          </tr>
      </c:forEach>
  </table>

    <a href="add" >Add new animal</a>

</body>
</html>
