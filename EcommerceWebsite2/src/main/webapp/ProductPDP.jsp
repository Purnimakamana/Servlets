<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerce.product.ProductsDao"%>
<%@page import="com.ecommerce.product.Products"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:useBean id="p" class="com.ecommerce.product.Products" />
<jsp:setProperty name="p" property="*" />
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Desc page</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	List<Products> list = ProductsDao.getProductDetails(id);
	request.setAttribute("mylist", list);
	%>
	<div class="main">
		<c:forEach items="${mylist}" var="data">
			<div class="child">
		 <img alt="image" src="${data.getProductUrl()}"></a>
				<p>name: ${data.getProductName()}</p>
				<p>description: ${data.getProductDesc()}</p>
				<p>price: ${data.getProductPrice()}</p>

				<button>Buy now</button>
				<button> <a href="Addtocart.jsp?id=${data.getProductId()}">add to cart</a></button>

			</div>
		</c:forEach>
		</div>
</body>
</html>