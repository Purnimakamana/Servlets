<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= "welcome to jsp" %><br>  
Current Time: <%= java.util.Calendar.getInstance().getTime() %>  
<h2>Hello JSP</h2>
<%out.print("Hello"); %><br>
<%! int a=10; %>  
<%= "Value of the variable is:"+a %>  
</body>
</html>