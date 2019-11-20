<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Login, Sign up Header</title>

	<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/header-login-signup.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
</head>
<body>
<header class="header-login-signup">

	<div class="header-limiter">

		<h1><a href="#">FUNCTION<span>JUNCTION</span></a></h1>

		<nav>
			<a href="Home.jsp">Home</a>
			<a href="listevent&items.jsp" class="selected">Our Events</a>
			<a href="#">About Us</a>
			<a href="#">Gallery</a>
			<a href="#">Contact us</a>
		</nav>

		<ul>
			<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if((session.getAttribute("username") == null) || (!session.getAttribute("type").equals("admin")) && (!session.getAttribute("type").equals("user")))
	{
		response.sendRedirect("Login.jsp");
	}


%>

<form method="post" action="logoutPage">
		<table align="right">
			<tr>
				<td style = "font-size: 16px;color: #FFFFFF; ">Logged In: ${username}</td><td><input type="submit" value="Logout" 
				style = "position: relative; background-color: #4CAF50; border: none; font-size: 12px;color: #FFFFFF;padding: 10px;
				width: 80px;text-align: center;-webkit-transition-duration: 0.4s; /* Safari */transition-duration: 0.4s;
				text-decoration: none;overflow: hidden;cursor: pointer;"></td>
			</tr>

		</table>
	</form>
		</ul>

	</div>

</header>

</body>
</html>