<%--
  Created by IntelliJ IDEA.
  User: tomic
  Date: 10.06.18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action="/animal-servlet/remove">
  <input type="hidden" name="animalToRemoveId" value="${animalId}"/>

  <h1>Are you sure?</h1>
  <input type="submit" value="YES Remove!" />
  <a href="/animal-servlet">NO</a>
</form>
</body>
</html>
