<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
		<h1>${ question.question }?</h1>
		<h3>Tags:</h3>
		<ul>
		<c:forEach items="${ question.tags }" var="tag">
			<li>${ tag.subject }</li>
		</c:forEach>
		</ul>
			<hr />
<h2>Answers</h2>
		<ul>
		<c:forEach items="${ question.answers }" var="ans">
			<li>${ ans.answer }</li>		
		</c:forEach>
		</ul>

	<hr />
	
	<h3>Add your answer:</h3>
		<form:form action="/answers" method="post" modelAttribute="answer">
			 <div class="form-group">
		        <form:label path="answer">Answer</form:label>
		        <form:errors path="answer"/>
		        <form:textarea class="form-control" path="answer"></form:textarea>
		    </div>
		    <form:hidden path="question" value="${ question.id }"/>
		    <button class="btn btn-primary">Answer it!</button>
		</form:form>
	</div>
	
	
	
</body>
</html>