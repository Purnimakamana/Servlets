<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "com.ecommerce.cart.CartDao" %>
      <%@ page import = "java.util.*" %>
   <%@ page import = "com.ecommerce.product.Products" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Products> list = CartDao.getOrderDetails();
request.setAttribute("list", list);
%>
<div>
<c:forEach items="${ll}" var="information">

<img alt="image" src="${information.getProductImageUrl()}" style="width:150px;height:150px">
${information.getProductPrice()}
${information.getProductName()}
<button>remove</a></button>


</c:forEach>
</div>
</body>
</html>