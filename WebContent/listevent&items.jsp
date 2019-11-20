<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events & Events With Items</title>
</head>
<body >
<%-- <%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if((session.getAttribute("username") == null) || (!session.getAttribute("type").equals("admin")) && (!session.getAttribute("type").equals("user")))
	{
		response.sendRedirect("Login.jsp");
	}


%>

<form method="post" action="logoutPage">
		<table align="right">
			<tr>
				<td  style = " font-size: 18px; color: black;">Logged In: ${username}</td><td><input type="submit" value="Logout" style = "position: relative; background-color: #4CAF50; border: none; font-size: 15px;color: #FFFFFF;padding: 5px;width: 200px;text-align: center;-webkit-transition-duration: 0.4s; /* Safari */transition-duration: 0.4s;text-decoration: none;overflow: hidden;cursor: pointer;"></td>
			</tr>

		</table>
	</form> --%>
 <jsp:include page="WEB-INF/views/header2.jsp"></jsp:include>
 
 <center>
 	<h1>Events only</h1>
 	<button><a href="HomeEvents.jsp">Click Here </a></button>
	 <h1>Events with Additional Packages</h1>
 	<button><a href="ViewItem.jsp">Click Here </a></button>
  
 </center>

 
 
 <jsp:include page="WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>