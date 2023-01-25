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
<% Integer counter = (Integer) session.getAttribute("counter"); %>
	<p> you have visited http://localhost:8080/ <%= counter %> times </p>
	<a href="/">Test another Visit?</a>
</body>
</html>