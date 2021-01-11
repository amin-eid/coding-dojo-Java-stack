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
<h1>All Licenses</h1>
<table>
    <thead>
        <tr>
        	<th>license #</th>
            <th>license State</th>
            <th>license Expiration Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${licenses}" var="license">
        <tr>
        	<td><c:out value="${license.number}"/></td>
            <td><c:out value="${license.state}"/></td>
            <td><c:out value="${license.expiration_date}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/licenses/new">New License</a>
</body>
</html>