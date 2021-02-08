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
<form action="MoviesController">
<section>Add the Movie Details</section>
<input type = "hidden" name = "hidden" value ="add">
Id    :<input class="input" type = "number" name = "serId"><br>
Movie :<input class="input" type = "text" name = "name"><br>
Day   :<input class="input" type = "text" name = "day"><br>
Time  :<input  class="input" type = "text" name = "time"><br>
Seats  :<input  class="input" type = "number" name = "seats" value = "100"><br>
<input class="button" type = "submit" value ="Add Movie" name = "submit">
</form>

</body>
</html>