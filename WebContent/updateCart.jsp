<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
    <jsp:include page="WEB-INF/views/header2.jsp"></jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EventPlanning/updateCart</title>
        <link href="css/main.css" rel="stylesheet" type="text/css">
       <style>
body {
	background:url(img/back.jpg) no-repeat center fixed;
	background-size: cover; 
	
}
table,th,td {
	color:black;
	text-align: left;
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
img {
  border-radius: 5%;
}
div.ex2{
    background-color: rgba(0,0,0,0.5);
	width: 1000px;
      
    
}
</style>
    </head>
    <body>
        
            <center>
            	<h1 style=font-size:50px>Update Event List</h1>
            </center>
<center>
<div class=ex2 > 
        <form method="post" action="UpdateController" onsubmit="return validate();">
              
         <table align="center">	        
            <%
            if(request.getParameter("edit_id")!=null) //get edit_id from index.jsp page with href link and check not null after continue
            {
                int eventId=Integer.parseInt(request.getParameter("edit_id")); //get edit_id store in "id" variable
                
                String url="jdbc:mysql://localhost/event"; //database connection url string
                String username="root"; //database connection username
                String password=""; //database password
                
                try
                {
                    Class.forName("com.mysql.jdbc.Driver"); //load driver
                    Connection con=DriverManager.getConnection(url,username,password); //create connection
                    
                    PreparedStatement pstmt=null; //create statement
                    
                    pstmt=con.prepareStatement("select * from cart where eventId=?"); //sql select query 
                    pstmt.setInt(1,eventId);
                    ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
                    
                    while(rs.next())
                    {
            %>    
	<tr>
		<td>
  		
  			<p>
    			<h1>Weddings</h1><input type="hidden" name="description" value="Wedding">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Full Package 		- Rs.800000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="1" ><br>
      				Partial Package 	- Rs.750000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="2" ><br>
      				On The Day 			- Rs.500000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity" value="<%=rs.getString("quantity")%>">
			</p>
			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value="<%=rs.getString("sDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value="<%=rs.getString("eDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 
    		<input type="submit" class="button" name="btn_edit" value="Update">
    		

  		</td>
  		<td><img src="img/wedding.jpg" width="600" height="300" /></td>
  	</tr>
  	
  	<tr>
		<td>
  		
  			<p>
    			<h1>Private Parties</h1><input type="hidden" name="description" value="Private Party">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Birthday Parties 		- Rs.20000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="1" ><br>
      				Get together Parties 	- Rs.50000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="2" ><br>
      				Private Events 			- Rs.75000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked" tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity" value="<%=rs.getString("quantity")%>">
			</p>
			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value="<%=rs.getString("sDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value="<%=rs.getString("eDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 
    		<input type="submit" class="button" name="btn_edit" value="Update">
  
  	
  		</td>
  		<td><img src="img/bdayparty.jpg" width="600" height="300" /></td>
  	</tr>
  	
  	<tr>
		<td>
  		
  			<p>
    			<h1>Corporate Events</h1><input type="hidden" name="description" value="Corporate Event">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Conferences 		- Rs.300000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked"tabindex="1" ><br>
      				Corporate Parties 	- Rs.150000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked"tabindex="2" ><br>
      				Employee Fun Days 	- Rs.70000.00 <input type="radio" name="price" value="<%=rs.getString("price")%>" checked="checked"tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity" value="<%=rs.getString("quantity")%>">
			</p>
			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value="<%=rs.getString("sDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value="<%=rs.getString("eDate")%>" min="2018-01-01" max="2018-12-31" />
			</p>
 
    		<input type="submit" class="button" name="btn_edit" value="Update">
  
  		
  		</td>
  		<td><img src="img/corporate.jpg" width="600" height="300" /></td>
  	</tr>
  	
  	
                
                    <input type="hidden" name="hidden_id" value="<%=rs.getInt("eventId")%>">
            <%
                    }
                    
                    pstmt.close(); //close statement

                    con.close(); //close connection
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            %>
            </table>
            
           	<center>
                <h3 style="color:red;">
                    <%
                        if(request.getAttribute("UpdateErrorMsg")!=null)
                        {
                            out.print(request.getAttribute("UpdateErrorMsg")); //get update record fail error message from EditController.java
                        }
                    %>
                </h3>
                
                <a href="viewCart.jsp"><input type="button" class="button" name="addToCart" value="Go Back"></a>
            </center>					
										
        </form>
		
	</div>
	</center>
	
       
<jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>
    </body>
</html>
