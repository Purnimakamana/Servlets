<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcom</title>
</head>
<body>
<%   
String nam=request.getParameter("uname");
out.print("Example"+nam);  
  
 String student=config.getInitParameter("student");  
out.print("student name is="+student);   
%> 

</body>
</html>