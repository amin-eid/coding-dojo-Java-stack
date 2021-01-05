<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><c:out value="${error}"/></p>
<center><strong>What is the Code?</strong></center>
<center>
<form method="POST" action="/code">
<input type="text" name="code">
<input type="submit" value="Try Code">
</form></center>
</body>
</html>