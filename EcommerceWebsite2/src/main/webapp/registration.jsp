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
int i =UserDao.save(user);  
if(i > 0){  
response.sendRedirect("Login.html");  
}else{  
	out.println("Please check your details");
response.sendRedirect("Registration.html");  
}  
%>  

</body>
</html>