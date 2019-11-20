<%@page import ="event.util.AddEventDB" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import ="event.util.DBConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java MVC Add, Edit, Delete Using JSP & Servlet With MySQL</title>
        <link href="main.css" rel="stylesheet" type="text/css"> 
        <title>Table V03</title>-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>


	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main1.css">
<!--===============================================================================================-->
    </head>
    
    <body background="img/table.jpg">
        <jsp:include page="WEB-INF/views/header1.jsp"></jsp:include>
        
            
              
        
  
          <!--   <table>    
                
                <tr>
                    <th>Event ID</th>
                    <th>Event Name</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Place</th>
                    <th>Price</th>
                </tr> --> 
                
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
								<th class="column100 column6" data-column="column6">Price</th>
								<th class="column100 column4" data-column="column4">DJ</th>
								<th class="column100 column5" data-column="column5">CAKE</th>
								<th class="column100 column6" data-column="column6">FLOWER</th>
								
							</tr>
						</thead>
						 <h1><a href="AddItems.jsp">Add Events</a></h1> 
					
                <%
                    //String url="jdbc:mysql://localhost:3306/event"; //database connection url string
                    //String username="root"; //database connection username
                    //String password=""; //database password
                  
                try
                {
                    //Class.forName("com.mysql.jdbc.Driver"); //load driver
                   // Connection con=DriverManager.getConnection(url,username,password); //create connection
                  
                    //PreparedStatement pstmt=null; //create statement
                 DBConnection db = new DBConnection();
        	     Connection con = null;
        	     con=db.getConnection();
        	
	             PreparedStatement pstmt=null; //create statement
                  
                 pstmt=con.prepareStatement("select * from items"); //sql select query
                 ResultSet rs=pstmt.executeQuery(); //execute query and set in ResultSet object rs.
                    
                    while(rs.next())
                    {
                %>
                <tr>
               
                   <td><div align="center"><%=rs.getString("eventID")%></div></td>
              
                    <td><%=rs.getString("eventName")%></td>
                    <td><%=rs.getString("category")%></td>
                    <td><%=rs.getString("description")%></td>
                    <td><%=rs.getString("place")%></td>
                    <td><%=rs.getDouble("price")%></td>
                    <td><%=rs.getString("dj")%></td>
                    <td><%=rs.getString("cake")%></td>
                    <td><%=rs.getString("flower")%></td>
                   
        
                    <td><a href="EditItems.jsp?edit_id=<%=rs.getInt("eventID")%>">Edit</a></td>
                    <td><a href="DeleteItem.jsp?delete_id=<%=rs.getInt("eventID")%>">Delete</a></td>
                    
               </tr>
                <%
                    }
                    
                    pstmt.close(); //close statement

                    con.close(); //close connection
                }
                catch(Exception e)
                {
                    e.printStackTrace();
          		
                }
                %>
            </table>
  
          
                <h3 style="color:green;">
                <%
                    if(request.getAttribute("InsertSuccessMsg")!=null)
                    {
                        out.println(request.getAttribute("InsertSuccessMsg")); //get record insert success message from AddController.java
                    }
                %>
                
                <%
                    if(request.getAttribute("UpdateSuccessMsg")!=null)
                    {
                        out.println(request.getAttribute("UpdateSuccessMsg")); //get record update success message from EditController.java
                    }
                %>
                </h3>
        
            
 </div>
  </div>
   </div>
    </div>
        <jsp:include page="WEB-INF/views/footer.jsp"></jsp:include> 
    </body>
       
</html>
