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
    <title>Add new Animal</title>
</head>
<body>

  <h1>Add new Animal</h1>

  <form method="post" action="/animal-servlet/">
    <label>Name of animal</label>
    <input type="text" name="animalName" />
    <input type="submit" value="Add animal to list" />
  </form>
</body>
</html>
