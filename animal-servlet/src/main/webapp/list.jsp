<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>See list of animals</title>
</head>
<body>

  <h1>We have ${animalsList.size()} animals</h1>

  <ul>
      <c:forEach items="${animalsList}" var="animal">
          <li><c:out value="${animal.getName()}"/> of type <c:out value="${animal.getType()}"/></li>
      </c:forEach>
  </ul>

</body>
</html>
