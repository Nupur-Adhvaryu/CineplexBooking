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
<th>No.</th>
<th>Movie</th>
<th>Day</th>
<th>Time</th>
<th>Seats Available</th>
</tr>
<c:forEach var="theMovie" items="${movies}">
<tr>
<c:url var="ticket" value="ticketController">
<c:param name="Movie" value="${theMovie.id}" />
</c:url>
<td>${theMovie.id}</td>
<td>${theMovie.name}</td>
<td>${theMovie.day}</td>
<td>${theMovie.time}</td>
<td>${theMovie.seats}</td>
<td><a href="${ticket}" ><span>&#10149</span> </a></td>
</tr>
</c:forEach>
</table>
</body>
</html>