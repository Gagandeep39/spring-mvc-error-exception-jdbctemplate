<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>  
<head>  
<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<form:form action="helloagain.obj" modelAttribute="emp">  
Username: <form:input path="name"/> <br><br>  
<form:errors path="name" cssClass="error"/> <br><br>
Password(*): <form:password path="pass"/> <br><br> 
<form:errors path="pass" cssClass="error"/><br><br>  
<input type="submit" value="submit">  
</form:form>  
</body>  
</html>  