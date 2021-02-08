<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="styles/Main.css">
<meta charset="UTF-8">
<title>JDplex</title>
</head>
<body>
<table>
<tr>

<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>UserName</th>
</tr>
<c:forEach var="theUser" items="${users}">
<tr>
<%-- <c:url var="ticket" value="ticketController">
<c:param name="Movie" value="${theMovie.id}" />
</c:url> --%>
<td>${theUser.fName}</td>
<td>${theUser.lName}</td>
<td>${theUser.email}</td>
<td>${theUser.userName}</td>
<%-- <td><a href="${ticket}">-></a></td> --%>
</tr>
</c:forEach>
</table>
<form action = "admin.jsp">
<input type= "submit" name = "submit" value = "go back" class = "button">
</form>
</body>
</html>