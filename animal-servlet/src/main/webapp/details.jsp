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
    <title>See details of animal</title>
</head>
<body>
  <h2>Details of animal</h2>


  <ul>
    <li>${animalDetails.getId()}</li>
    <li>${animalDetails.getName()}</li>
    <li>${animalDetails.getType()}</li>
  </ul>

  <a href="/animal-servlet/" >Back to list</a>

</body>
</html>
