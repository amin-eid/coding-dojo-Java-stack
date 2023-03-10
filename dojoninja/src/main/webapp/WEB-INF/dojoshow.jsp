<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
<title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>Dojos and Ninjas</h1>
		<h3><a href="/dojos">Dojos</a></h3>
		<hr />
		<h2>${ dojo.name } Location Ninjas</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dojo.ninjas }" var="ninja">
				<tr>
					<td>${ ninja.firstName } </td>
					<td>${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>