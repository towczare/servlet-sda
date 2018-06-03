<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello People!</title>
</head>
<body>

    <c:if test="${empty greetingList}" >
        <h1>Hello dear Stranger!</h1>
    </c:if>
    <c:forEach items="${greetingList}" var="name">
        <h1>Hello dear <c:out value="${name}" />!</h1>
    </c:forEach>

    <a href="add">Invite more people!</a>
</body>
</html>
