<%@page import ="event.util.AddEventDB" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>
<%@page import ="event.util.DBConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <jsp:include page="WEB-INF/views/header1.jsp"></jsp:include>

        <title>Events</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

 	
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	 <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css"> 

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main1.css">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/Add.css">
    </head>
    
    <body background="img/bogy1.jpg">
       
        
        <%
	String keyword = "";
	if(request.getParameter("txtKeyword") != null) {
		keyword = request.getParameter("txtKeyword");
	}
%>
<form class="example"  method="get" action="HomeEvents.jsp">
   
<input name="txtKeyword" type="text" id="txtKeyword" placeholder="Search here.."value="<%=keyword%>">
  <button type="submit"><i class="fa fa-search" value="Search"></i></button>
   
	     
	     
</form>

<%
	Connection connect = null;
	Statement s = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		connect =  DriverManager.getConnection("jdbc:mysql://localhost/event" +
				"?user=root&password=");
		
		s = connect.createStatement();
		
		
		 
		String sql = "SELECT * FROM  items WHERE category like '%" +  keyword + "%' " +
		" ORDER BY eventID ASC";
		
		System.out.println(sql);
		
		ResultSet rec = s.executeQuery(sql);
		%> 
	  <div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<table data-vertable="ver1">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">Event ID</th>
								<th class="column100 column2" data-column="column2">Event Name</th>
								<th class="column100 column3" data-column="column3">Category</th>
								<th class="column100 column4" data-column="column4">Description</th>
								<th class="column100 column5" data-column="column5">Place</th>
								<th class="column100 column6" data-column="column6">Price Starts From</th>
								<th class="column100 column7" data-column="column7">DJ</th>
								<th class="column100 column8" data-column="column8">CAKE</th>
								<th class="column100 column9" data-column="column9">FLOWER</th>
								
			<%while((rec!=null) && (rec.next())) { %>
				  <tr>
				    <td><div align="center"><%=rec.getString("eventID")%></div></td>
				    <td><%=rec.getString("eventName")%></td>
				    <td><%=rec.getString("category")%></td>
				    <td><%=rec.getString("description")%></td>
				 	<td><%=rec.getString("place")%></td>
				    <td align="right"><%=rec.getInt("price")%></td>
				    <td><%=rec.getString("dj")%></td>
                    <td><%=rec.getString("cake")%></td>
                    <td><%=rec.getString("flower")%></td>
                   
				  </tr>
	       	<%}%>
	  	</table> 
	  	<a href="addCart.jsp"><input type="button" class="button1" name="Payment" value="Book Events"></a>      
	    <%	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
	</div>
	</div>
	</div>
	</div>
	 <jsp:include page="WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>