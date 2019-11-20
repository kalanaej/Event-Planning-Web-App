<%@page import="Login.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Login.service.UserServiceImpl"%>
<%@page import="Login.service.LoginService"%>
<%@page import="Login.util.connectDb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>


	  <div style="background-color: transparent; color: black; font-family: 'Calibri'; padding-left: 30px">
		<table border="5" bordercolor="#008CBA" align="center" cellpadding="25px"  style= " color:#008CBA; border-collapse: collapse;font-size: 18px ">
		 <caption><h2>User Account</h2></caption>
		 
		  <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>E-mail</th>
                <th>User Name</th>
                <th>Password</th>
             
                <th>You Want Edit</th>
                <th>You Want Delete</th>
         
            </tr>
            
      
			
			<tr>
			

            
            <%
           
            LoginService loginService = new UserServiceImpl();
			ArrayList<User> arrayList = loginService.getUsers(); // balanna
			
			for(User user : arrayList){
			%>
			 <tr>
				<td> <%=user.getUserID() %> </td>
				<td> <%=user.getName() %> </td>
				<td> <%=user.getAddress() %> </td>
				<td> <%=user.getEmail() %> </td>
				<td> <%=user.getUserName() %> </td>
				<td> <%=user.getPassword() %> </td>
				
				
		
				<td> 
				<form method="POST" action="GetUserServlet">
				<input type="hidden" name="userID" value="<%=user.getUserID()%>"/>
				 <input type="submit" value= "Select User" class="select-button" style = "margin-left:30px; width:150px; background-color: #4CAF50; text-align: center;  color: white; padding: 16px 32px; text-align: center; text-decoration: none;  font-size: 16px; margin: 4px 2px; cursor: pointer;:hover{background-color: green; color:white} " /> 
				 </form>
				 </td>	
				 <td>
				<form method="POST" action="DeleteUserServlet">
					<input type="hidden" name="userID"
						value="<%=user.getUserID()%>" /> <input type="submit"
						value="Delete Account" class="delete-button" style = "margin-left:30px; width:250px; background-color: #4CAF50;
							 text-align: center;  color: white; padding: 16px 20px; text-align: center; text-decoration: none; 
							 font-size: 16px; margin: 4px 2px; cursor: pointer;:hover{background-color: green; color:white} "/>
				</form>
			</td>
				</tr>	
				<tr>
			
		</tr>		
			<%	
			   }
            %>     
            
            
			
            
		</table>
				<!-- <p style="padding-left: 30px; font-family: Arial;font-size: 20px;">
				Create a new <a href="CreateAcc.jsp">USER ACCOUNT?</a></p> -->
		</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>