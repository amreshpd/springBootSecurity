<%@page import="java.util.Random"%>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red;">Approved Loan Page</h1>
	<b>u r approved for loan amount:: <%=new Random().nextInt(1000000)%></b><br>
	<a href="./">home</a><br>
	<a href="logout">Logout</a><br>
</body>
</html>