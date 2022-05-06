<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ecommerce.product.ProductsDao"%>  
<jsp:useBean id="p" class="com.ecommerce.product.Products"/>
<jsp:setProperty  name="p" property="*"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int status =ProductsDao.save(p);  
if(status>0){  
	System.out.println("added successfully");
}  
else  
{  
out.print("Sorry, did'nt added");
response.sendRedirect("Registration.html");  
}
%>  
</body>
</html>