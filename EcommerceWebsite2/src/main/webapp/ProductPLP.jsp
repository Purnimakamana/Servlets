<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.ecommerce.product.ProductsDao"%>  
      <%@page import="com.ecommerce.product.Products"%>  
<jsp:useBean id="p" class="com.ecommerce.product.Products"/>
<jsp:setProperty  name="p" property="*"/> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String cat = request.getParameter("cat");
List<Products> list = ProductsDao.getProduct(cat);
request.setAttribute("mylist", list);
System.out.println(list);
%>
<div class="main">
<c:forEach items="${mylist}" var="data">
<div class="child">
<a href="ProductPDP.jsp?id=${data.getProductId()}"><img
alt="image" src="${data.getProductUrl()}"></a>
<p>price: ${data.getProductPrice()}</p>

<button>Buy now</button>
<button>Add to cart</button>

</div>
</c:forEach>
</div>
</body>
</html>