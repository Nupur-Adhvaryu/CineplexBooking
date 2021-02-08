<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="styles/Main.css">
<meta charset="UTF-8">
<title>JDplex</title>
</head>
<body>
<h1>&#9758 ${selectedMovie.name} &#9756</h1>

<form id = "category" action = "ticketController" method = "post">
<p>Which category of the ticket you want to buy:</p><br>
<input type = "hidden" name="hidden" value = "category">
<input id="gVal" type = "checkbox" name="category" value = "general">General<input type = "number" name ="gVal" value = 0> <br>
<input type = "checkbox" name="category" value = "kid">Kids<input type = "number" name ="kVal" value = 0><br>
<input type = "checkbox" name="category" value ="senior">Senior<input type = "number" name ="sVal" value = 0><br>
<input class="button" type = "submit" name="submit" value = "submit">

</form>
</body>
</html>