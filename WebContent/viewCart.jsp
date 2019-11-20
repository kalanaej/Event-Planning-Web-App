<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
	<%@page import="cart.service.*" %>
	

<!DOCTYPE html PUBLIC "-//W3C//33DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="WEB-INF/views/header2.jsp"></jsp:include>

<meta http-equiv="Content-Type"  content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

body {
	background:url(img/back2.jpg) no-repeat center fixed;
	background-size: cover; 
	
}
table {
    border-collapse: collapse;
    width: 80%;
}
thead {color:yellow;}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
div.ex1 {
    background-color: rgba(0,0,0,0.5);
    width: 1000px;
    height: 500px;
    overflow: auto;
}
.button {
	border-radius: 10px;
	background-color: rgba(0,0,0,0.5);
    border: none;
    color: white;
    padding: 5px 10px;
    text-align: center;
    font-size: 15px;
    cursor: pointer;
}
h1 {
    color: white;
}
.button1{
	float: right;
	border-radius: 10px;
	background-color: rgba(0,0,0,0.5);
    border: none;
    color: white;
    padding: 5px 10px;
    text-align: center;
    font-size: 15px;
    cursor: pointer;
} 
</style>

</head>
<body>

<!-- end of space classes -->
	<br><br>
	<br><br>
	
		<form>
		  
		  	<a href="addCart.jsp"><input type="button" class="button" name="addToCart" value="Go Back"></a>
		  
	  	</form>
				<center>	<h1 style=font-size:50px>Booked Event List</h1>	</center>
	<br>
	<center>
	<div class=ex1 >
		<br>
		<br>
	
		<table border="0">
	
	<tr><thead>
		<th>EventID</th>
		<th>Event Description</th>
		<th>Package Price</th>
		<th>No Of Participants</th>
		<th>Start Date</th>
		<th>End Date</th>
		</thead>
	</tr>
	
	<%
	
		DBConnection db = new DBConnection();
		Connection conn = null;
		conn = db.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM cart";
		
		try{
			conn = db.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				%>
				<form>
					<tr>
						<td ><%out.print(rs.getInt(1)); %></td>
						<td ><%out.print(rs.getString(2)); %></td>
						<td ><%out.print(rs.getString(3)); %></td>
						<td ><%out.print(rs.getString(4)); %></td>
						<td ><%out.print(rs.getString(5)); %></td>
						<td ><%out.print(rs.getString(6)); %></td>
					
						<td><a href="updateCart.jsp?edit_id=<%=rs.getString("eventId")%>"><input type = "button" class="button" style="width:100%" value = "Edit"></a></td>
						<td><a href="deleteCart.jsp?delete_id=<%=rs.getString("eventId")%>"><input type = "button" class="button" style="width:100%" value = "Delete"></a></td>
                    
					</tr>
				</form>	
					
			
				<%
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	%>
</table>



</div>
</center>
<br>
<a href="Payment.jsp"><input type="button" class="button1" name="Payment" value="Proceed To Payment"></a>
<jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>