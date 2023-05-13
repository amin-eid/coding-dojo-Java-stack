<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${onedojo.name} Location Ninjas:</h1>
<c:forEach var="nj" items="${onedojo.ninjas}">

	<p><c:out value="${nj.firstName}"></c:out> <c:out value="${nj.lastName}"></c:out></p>

        
    </c:forEach>
</body>
</html>