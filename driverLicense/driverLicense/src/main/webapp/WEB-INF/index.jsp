<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>    
<h1>All Persons</h1>
<table>
    <thead>
        <tr>
            <th>first name</th>
            <th>last Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${persons}" var="person">
        <tr>
            <td><c:out value="${person.firstName}"/></td>
            <td><c:out value="${person.lastName}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/persons/new">New Person</a>
</body>
</html>