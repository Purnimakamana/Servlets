<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.ecommerce.cart.CartDao" %>
     <%@ page import = "com.ecommerce.product.Products" %>
     <%@ page import = "java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Getting Cart Details</title>
</head>
<body>
<%
List<Products> list = CartDao.getCartDetails();
request.setAttribute("list", list);
System.out.print(list);
System.out.println("Hiiii");

%>
<div class="main">
<c:forEach items="${list}" var="data">
<div class="child">
<a href="ProductPDP.jsp?id=${data.getProductId()}"><img
alt="image" src="${data.getProductUrl()}"></a>
<p>price: ${data.getProductPrice()}</p>

<button><a href ="Order.jsp?id=${data.getProductId()}">Order</a></button>
<button><a href ="Delete.jsp?id=${data.getProductId()}">Remove</button>

</c:forEach>
</div>
</body>
</html>