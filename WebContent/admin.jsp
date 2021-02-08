<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<style>
form{
margin-left:120px;
margin-top:0px;
padding-top:0px;
}
p{
margin-bottom : 0px;
}
</style>
 <link type="text/css" rel="stylesheet" href="styles/Main.css">
<meta charset="UTF-8">
<title>JDplex</title>
</head>
<body>
<h1>Welcome Admin &#128526</h1>
<p>Add Movie &#10549</p>
<form action="adminAdd.jsp">
<input class = "button" type="submit" name = "submit" value ="Add Movie">
</form>
<p>Movie List &#10549</p>
<form action="MoviesController">
<input type = "hidden" name = "hidden" value="listMovie">
<input class = "button" type="submit" name = "submit" value ="Show">
</form>
<p>User List &#10549</p>
<form action="userController" method = "post">
<input type = "hidden" name = "hidden" value="listUser">
<input class = "button" type="submit" name = "submit" value ="Show">
</form>
<form action = "MainPage.jsp" id = "thanks">
<input class="button" type = "submit" value="Home Page" name = "submit">
</form>

</body>
</html>