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
    <li><b>Id:</b> ${animalDetails.getId()}</li>
    <li><b>Name:</b> ${animalDetails.getName()}</li>
    <li><b>Type:</b> ${animalDetails.getType()}</li>
    <li><b>Age:</b> ${animalDetails.getAge()}</li>
    <li><b>Picture:</b> <img src="${animalDetails.getImageUrl()}" width="500" /></li>
    <li><b>Description:</b> ${animalDetails.getDescription()}</li>
  </ul>

  <a href="/animal-servlet/" >Back to list</a>

</body>
</html>
