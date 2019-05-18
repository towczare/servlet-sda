<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Animal Details</title>
</head>
<body>
    <h1>Animal Details</h1>

    <h2>Presenting details of animal with id ${animalId}</h2>

    <h3>Animal Details : ${animalDetails.name} ${animalDetails.type}</h3>


    <a href="/animal-servlet/" >Back to full list of Animals!</a>
</body>
</html>
