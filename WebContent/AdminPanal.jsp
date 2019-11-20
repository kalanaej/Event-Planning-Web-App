<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>ADMIN PANEL</title>

	<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/header-login-signup.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
</head>
<body> 
	<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if((session.getAttribute("username")==null) ||(!session.getAttribute("type").equals("admin") )){
		response.sendRedirect("Login.jsp");
	}
	else
	{%>
	<form method="POST" action="logoutPage">
		<table align="right">
			<tr>
				<td style = "font-size: 16px;color: #FFFFFF; ">Logged In: ${username}</td><td><input type="submit" value="Logout" 
				style = "position: relative; background-color: #4CAF50; border: none; font-size: 12px;color: #FFFFFF;padding: 10px;
				width: 80px;text-align: center;-webkit-transition-duration: 0.4s; /* Safari */transition-duration: 0.4s;
				text-decoration: none;overflow: hidden;cursor: pointer;"></td>
			</tr>

		</table>
	</form>
<%
	}
%>
<header class="header-login-signup">

	<div class="header-limiter">

		<h1><a href="#">FUNCTION<span>JUNCTION</span></a></h1>

		<nav>
			<a href="Home.jsp">Home</a>
			<a href="AdminControl.jsp" class="selected">Events Management</a>
			<a href="UserAccList.jsp">Users Management</a>
			<a href="addCart.jsp">Event Book</a>
			<a href="Payment.jsp">Payment Management</a>
		
		
		</nav>

		<ul>
			</ul>

	</div>

</header>

</body style = " ">
</html>