<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>  
<p>Fist name:<c:out value="${person.firstName}"/></p>
<p>Last Name: <c:out value="${person.lastName}"/></p>
<p>License Number: <c:out value="${ person.license.number }"/></p>
<p>State: <c:out value="${ person.license.state }"/></p>
<p>Expiration Date: <c:out value="${ person.license.expiration_date }"/></p>
<form action="/persons/${person.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>