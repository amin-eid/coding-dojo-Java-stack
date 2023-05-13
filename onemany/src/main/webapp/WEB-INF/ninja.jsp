<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/ninjas" method="post" modelAttribute="ibrahim">
<p>

Dojo:<form:select  path="dojo">
 <c:forEach var="dj" items="${alldojos}">
    <form:option value="${dj.id}">${dj.name}</form:option>
   </c:forEach>
  </form:select>
        
        </p>

    <p>
        <p><form:label path="firstName">First Name</form:label></p>
        <p><form:errors path="firstName"/></p>
        <p><form:input path="firstName"/></p>
    </p>
    <p>
        <p><form:label path="lastName">Last Name</form:label></p>
        <p><form:errors path="lastName"/></p>
        <p><form:input path="lastName"/></p>
    </p>
        <p>
        <p><form:label path="age">Age</form:label></p>
        <p><form:errors path="age"/></p>
        <p><form:input path="age"/></p>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>