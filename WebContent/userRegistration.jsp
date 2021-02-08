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
<form action="userController" method = "post">
<section>Enter Your details and click Register</section>  <br>
<input type = "hidden" name = "hidden" value ="userRegister">
Enter Your First Name<input type = "text" name = "fname" ><br>
Enter Your Last Name<input type = "text" name = "lname" ><br>
Enter Your Email<input type = "email" name = "email" ><br>
Enter Your UserName<input type = "text" name = "uname" ><br>
Enter Your Password<input type = "password" name = "pass" ><br>
<input class="button" type = "submit" value ="Register" name = "submit">
</form>
</body>
</html>