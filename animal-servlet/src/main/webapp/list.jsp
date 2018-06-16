<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-vml.min.js"></script>
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css" />
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/fonts/css/anychart.min.css"/>
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
          <tr>a
              <td><c:out value="${animal.getId()}"/></td>
              <td><c:out value="${animal.getName()}"/></td>
              <td><c:out value="${animal.getType()}"/></td>
              <td><a href="edit?animalId=${animal.getId()}" >Edit animal</a> </td>
              <td><a href="details?animalId=${animal.getId()}" >See details</a> </td>
              <td><a href="remove?animalId=${animal.getId()}" >Remove</a> </td>
          </tr>
      </c:forEach>
      <tr>
          <td colspan="6">
              <div id="container"></div>
              <script>
                  anychart.onDocumentReady(function() {
                      var chart = anychart.bar(${chartData});
                      chart.title("${chartTitle}");
                      chart.container("container");
                      chart.draw();
                  });
              </script>
          </td>
      </tr>
  </table>
  <a href="add" >Add new animal</a>

</body>
</html>
