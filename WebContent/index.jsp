<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to Spring MVC

<!--  earlier <form action="login">  -->
<form action="loginCtrl/ValidateLogin.obj">
	Name<input type="text" name="txtName">
	Password<input type="password" name="txtPassword">
	<input type="submit" value="Login">
</form>
<br>
<br>
<br>
  <form action="loginCtrl/RegisterEmployee.obj">
	Name<input type="text" name="txtName">
	Password<input type="password" name="txtPassword">
	Email<input type="email" name="txtEmail">
	<input type="submit" value="Sign up">
</form> 

<br><br><br>
<a href="employee-module/hello.obj">Click here for Validation Example</a>  
</body>
</html>