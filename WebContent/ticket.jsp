<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="styles/Main.css">
<head>
<meta charset="UTF-8">
<title>JDplex</title>
</head>
<body>
<h1>Thank you for booking &#128540</h1>
<section>
<h2>Movie Information:</h2><br>
Total Tickets : ${tt}<br>
Movie : ${movies.name}<br>
Day : ${movies.day}<br>
Timings : ${movies.time}<br>
Total price : $${price}
</section>
</body>
<form action = "MainPage.jsp" id = "thanks">
<input class="button" type = "submit" value="Home Page" name = "submit">
</form>
</html>