<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ecommerce.dao.UserDao"%>  
<jsp:useBean id="user" class="com.ecommerce.dao.User"/>
<jsp:setProperty property="*" name="user"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
boolean value=UserDao.validate(user);  
if(value){  
	response.sendRedirect("Home.html");  
}  
else  
{  
out.print("Sorry, email or password error");
response.sendRedirect("Login.html");  
}
%>  


</body>
</html>