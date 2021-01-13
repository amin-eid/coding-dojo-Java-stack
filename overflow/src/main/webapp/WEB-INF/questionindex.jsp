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
<title>Questions Assignment-Amin Eid</title>
</head>
<body>
	<div class="container">
		<h1>Questions</h1>
		<hr />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ questions }" var="qtn">
				<tr>
					<td><a href="/questions/${qtn.id}">${ qtn.question } </a></td>
					
					<td><c:forEach items="${ qtn.tags }" var="tg">${ tg.subject }</c:forEach> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a href="/questions/new">New Question</a>
		
	</div>
</body>
</html>