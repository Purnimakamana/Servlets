<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.ecommerce.cart.CartDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to cart</title>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
if(CartDao.saveAllDetails(id)>0){
	response.sendRedirect("CartSuccess.jsp");
}
%>
</body>
</html>