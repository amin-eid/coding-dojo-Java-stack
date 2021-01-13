<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
<title>Questions</title>
</head>
<body>
	<div class="container">
		<h1>Questions and Answers</h1>
		<hr />
		<h2>Add a Question</h2>
		<form:form action="/questions" method="post" modelAttribute="questiontag">
			<div class="form-group">
		        <form:label path="question">Question</form:label>
		        <form:errors path="question"/>
		        <form:input class="form-control" path="question"/>
		    </div>
		    <div class="form-group">
		        <form:label path="tags">Tags</form:label>
		        <form:errors path="tags"/>
		        <form:input class="form-control" path="tags"/>
		    </div>
		    <button>Add Question</button>
		</form:form>
	</div>
</body>
</html>