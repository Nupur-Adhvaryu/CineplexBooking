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
<h1>Welcome to JDplex &#9832</h1>
<br>
<br>

<div id = "container">
<div id = "user">
<form  action="userController" method = "post">
<p>User Login </p> <br>
<input type = "hidden" name = "hidden" value ="user">
<input type = "hidden" name = "discount" value ="20">
UserName<input class="input" type = "text" name = "uname" ><br>
Password<input class="input" type = "password" name = "pass" ><br>
<input class="button" type = "submit" value ="Login" name = "submit">
</form>
</div>

<br>
<br>
<div id = "admin">
<form id="admin" action="userController" method = "post">
<p>Administrator Login</p><br>
<input  type = "hidden" name = "hidden" value ="admin">
UserName<input class="input" type = "text" name = "name" ><br>
Password<input class="input" type = "password" name = "pass" ><br>
<input class="button" type = "submit" value ="Login" name = "submit">
</form>
</div>
</div>

<br><br><br>

<div id ="guest">
<form  action="userController">
<!-- <input type = "hidden" name = "hidden" value ="user"> -->
To Register-->
<input class="button" type = "submit" value ="Register" name = "submit">
</form><br>

<form action="MoviesController" >
For Guest login-->
<input type = "hidden" name = "hidden" value ="list">
<input class="button" type = "submit" value="Guest Login" name = "submit">

</form>
</div>

</body>
</html>