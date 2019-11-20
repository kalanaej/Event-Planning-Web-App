<%@page import="event.util.EditEventDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Items</title>
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.css'>
		<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style99.css">
                <script type="text/javascript"> 
        function validate()
        {
            var name_pattern= /^[a-z A-Z]+$/;  
            var category_pattern= /^[a-z A-Z]+$/; 
            var description_pattern= /^[a-z A-Z]+$/; 
            var place_pattern= /^[a-z A-Z]+$/; 
            var price_pattern= /^[0-9]+$/;
       
   
            var name = document.getElementById("name"); 
            var category = document.getElementById("category"); 
            var description = document.getElementById("description"); 
            var place = document.getElementById("place"); 
            var price = document.getElementById("price");
              
            if(!name_pattern.test(name.value) || name.value=='') 
            {
              alert("Enter Name Alphabet Only....!"); 
              name.focus();
              name.style.background = '#f08080'; 
              return false;                    
            }
            if(!category_pattern.test(category.value) || category.value=='') 
            {
              alert("Enter Category Alphabet Only....!"); 
              category.focus();
              category.style.background = '#f08080'; 
              return false;                    
            }
            if(!description_pattern.test(description.value) || description.value=='') 
            {
              alert("Enter Description Alphabet Only....!"); 
              description.focus();
              description.style.background = '#f08080'; 
              return false;                    
            }
            if(!place_pattern.test( place.value) ||  place.value=='')  
            {
              alert("Enter Place Alphabet Only....!"); 
              place.focus();
              place.style.background = '#f08080'; 
              return false;                    
            }
            if(!price_pattern.test( price.value) ||  price.value=='') 
            {
              alert("Enter Price Numbers Only....!"); 
              price.focus();
              price.style.background = '#f08080'; 
              return false;                    
            }
        }
 </script>
       
    </head>
    <body>
        <jsp:include page="WEB-INF/views/header1.jsp"></jsp:include>
    <div class="signupSection">
  <div class="info">
    <h2>Function Junction</h2>
    <i class="icon ion-ios-ionic-outline" aria-hidden="true"></i>
    <p>Add Events Admin </p>
  </div>
   <form method="post" action="EditItemsServlet" onsubmit="return validate();">
    <ul class="noBullet">
      <li>
        <div class="main">
            <center>
             <h1>Update Event</h1>
            </center>
  
            
              <table>         
            <%
            if(request.getParameter("edit_id")!=null) 
            {
                int id=Integer.parseInt(request.getParameter("edit_id")); 
                
                String url="jdbc:mysql://localhost:3306/event"; 
                String username="root"; 
                String password=""; 
                
                try
                {
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection(url,username,password); //create connection
                    
                    PreparedStatement pstmt=null; //create statement
                    
                    pstmt=con.prepareStatement("select * from items where eventID=?"); //sql select query 
                    pstmt.setInt(1,id);
                    ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
                    
                    while(rs.next())
                    {
            %>    <tr>

				<td>Event name :</td>
				<td><input type="text" name="name" placeholder="Event Name" id="name" value="<%=rs.getString("eventName")%>"><br><br></td>
			</tr>
			
			<tr>
				<td>Category</td>
				<td><input type="radio" name="category" value="Birthday"  id="category" value="<%=rs.getString("category")%>"
					checked="checked" tabindex="1" /> Birthday Celebration</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category" value="Wedding" id="category" value="<%=rs.getString("category")%>"
					tabindex="2" /> Wedding Ceremony</td>
			</tr>
				<tr>
				<td></td>
				<td><input type="radio" name="category"value="Entertainment" id="category" value="<%=rs.getString("category")%>"
					tabindex="3" /> Entertainment Event</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category"  value="Anniversary" id="category" value="<%=rs.getString("category")%>"
					tabindex="4" /> Anniversary Party</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category" value="Other" id="category" value="<%=rs.getString("category")%>
					tabindex="5" /> Other Event/Party</td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><input type="text" name="description" placeholder="Description" id="description" value="<%=rs.getString("description")%>"><br><br></td>
			</tr>
			<tr>
				<td>Place :</td>
				 <td><input type="text" name="place" placeholder="Place" id="place" value="<%=rs.getString("place")%>"><br><br></td>
			</tr>
			<tr>
				<td>Price Start from :</td>
				<td><input type="text" name="price" placeholder="Price" id="price" value="<%=rs.getString("price")%>"><br><br></td>
			</tr>
			
					<tr>
				<td>Addition Things :</td>
				<td><input type="checkbox" name="dj" value="dj" value="<%=rs.getString("dj")%>">DJ</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="checkbox" name="cake" value="cake" checked value="<%=rs.getString("cake")%>"> CAKE</td>
			</tr>
				
				<tr>
				<td></td>
			<td><input type="checkbox" name="flower" value="flower" checkedvalue="<%=rs.getString("category")%>"> Flower Decorating</td>
			</tr>
			
			<tr>
			     <li id="center-btn">
        <td><input type="submit" id="join-btn" name="btn_edit" alt="Join" value="Update Event"></td>
      </li>
			</tr>
			 <input type="hidden" name="hidden_id" value="<%=rs.getInt("eventID")%>">
 
       		
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
                
                <h1><a href="Item.jsp">Back</a></h1>
            </center>
    
        </form>
  
 </div>
 
 </div>
  </div>
   </div>
    </div>
<jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>

    </body>
</html>