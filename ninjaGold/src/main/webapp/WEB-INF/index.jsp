<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Your Gold: ${gold}  </h1>
<div class="container">
<div class="place">
<h1>Farm</h1>
<h2>Earns 10-20 Gold</h2>
<form method="POST" action="/">
<input name="farm" type="submit" value="Find a Gold!">
</form>
</div>


<div class="place">
<h1>Cave</h1>
<h2>Earns 5-10 Gold</h2>
<form method="POST" action="/">
<input name="cave" type="submit" value="Find a Gold!">
</form>
</div>

<div class="place">
<h1>House</h1>
<h2>Earns 2-5 Gold</h2>
<form method="POST" action="/">
<input name="house" type="submit" value="Find a Gold!">
</form>
</div>
<div class="place">
<h1>Casino</h1>
<h2>Earns 0-50 Gold</h2>
<form method="POST" action="/">
<input name="casino" type="submit" value="Find a Gold!">
</form>
</div>
</div>

<div class="activ">
<c:forEach var="activity" items="${act} ">
<h2>${activity}</h2>
</c:forEach>
</div>
</body>
</html>