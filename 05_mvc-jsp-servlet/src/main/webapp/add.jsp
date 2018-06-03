<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new greeting name!</title>
</head>
<body>
    <h4>Give me next name of person who needs to be welcomed!</h4>
    <form name="name-collector-form" method="post" action="/mvc-jsp-servlet/">
        Name <input type="text" name="name"/> <br/>
        <input type="submit" value="Add to greeting list" />
    </form>
    <a href="/mvc-jsp-servlet/">Invite more people!</a>
</body>
</html>
