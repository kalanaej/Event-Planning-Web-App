<%@page import="Login.model.User"%>
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



<div style="background-color: transparent; color: black; font-family: 'Calibri Light'; padding-left: 30px">
		
		<table>
			<tr>
				<td style="font-size: 30px; color: black; text-align: center;" ><h3>Update Customer Details</h3></td>
			</tr>
	<br>
	<br>
	<%
	User user = (User) request.getAttribute("user");
	%>

	<form method="POST" action="UpdateUserServlet" >
		<table>
			<tr>
				<td><br></td>
			</tr>
			 <tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">User ID</td>
				<td><input type="text" name="userID" disabled="disabled"
					value="<%=user.getUserID()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove"/></td>
			</tr> 
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">Name</td>
				<td><input type="text" name="name"
					value="<%=user.getName()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove"/></td>
					<span id = "msg1" style = " color: black; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">Address</td>
				<td><input type="text" name="userAddress"
					value="<%=user.getAddress()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove" /></td>
					<span id = "msg2" style = " color: black; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">E_MAIL</td>
				<td><input type="text" name="e_mail"
					value="<%=user.getEmail()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove"/></td>
					<span id = "msg3" style = " color: black; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">User Name</td>
				<td><input type="text" name="userName" 
					value="<%=user.getUserName()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove"/></td>
					<span id = "msg4" style = " color: black; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large">Password</td>
				<td><input type="text" name="uPassword" 
					value="<%=user.getPassword()%>" style="border-radius: 5px; width: 400px; height: 25px; border-style: groove"/></td>
					<span id = "msg5" style = " color: black; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			
			<tr>
				<td style="font-family: Calibri; width: 200px; font-size: large"><input type="hidden" name="userID"
					value="<%=user.getUserID()%>" />
							 <input type="submit" value="Update User" class="update-button" style = "margin-left:30px; width:250px; background-color: #4CAF50;
							 text-align: center;  color: white; padding: 16px 20px; text-align: center; text-decoration: none; 
							 font-size: 16px; margin: 4px 2px; cursor: pointer;:hover{background-color: green; color:white} "/></td>
			</tr>
		</table>
	</form>

	<%-- <table>
		<tr>
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
	</table> --%>
	</table>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


<script type="text/javascript"> 
        function val()
        {
          
            var name = document.getElementById("name").value;
            var userAddress = document.getElementById("userAddress").value; 
            var email = document.getElementById("email").value;
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            var re_password = document.getElementById("re_password").value;
            
              
            //name validation
            if(name=="")
            {
            	document.getElementById("msg1").innerHTML="**	Please Fill Name";
        		return false;
            }
            if(!isNaN(name))
            {
            	document.getElementById("msg1").innerHTML="**	Only Characters Allowed";
        		return false;
            }
            
          	//userAddress validation
            if(userAddress=="")
            {
            	document.getElementById("msg2").innerHTML="**	Please Fill User Address";
        		return false;
            }
            
            
            //email validation
            if(email=="")
            {
            	document.getElementById("msg3").innerHTML="**	Please Fill E-Mail";
        		return false;
            }
            if(email.indexOf('@') <= 0)
            {
            	document.getElementById("msg3").innerHTML="** 	@ Invalid Position";
        		return false;
            }
            if((email.charAt(email.length -4)!= '.') && (email.charAt(email.length -3)!= '.'))
            {
            	document.getElementById("msg3").innerHTML="** 	. Invalid Position";
        		return false;	
            }
            
            
            //userName validation
            if(userName=="")
            {
            	document.getElementById("msg4").innerHTML="**	Please Fill User Name";
        		return false;
            }
            if((userName.length <= 2) || (userName.length > 20)){
            	document.getElementById("msg4").innerHTML="** 	User Name Must Be Between 2 and 20 Characters";
        		return false;
            }
            if(!isNaN(userName))
            {
            	document.getElementById("msg4").innerHTML="** 	Only Characters Allowed";
        		return false;
            }
            
            
            //password validation
            if(password=="")
            	{
            		document.getElementById("msg5").innerHTML="** 	Please Fill Password";
            		return false;
            	}
            if(password.length < 8)
            {
            	document.getElementById("msg5").innerHTML="** 	Password Length Must Be Greter Than 8 Characters";
        		return false;
            }
            if(password.length > 15)
            {
            	document.getElementById("msg5").innerHTML="** 	Password Length Must Be Smaler Than 15 Characters";
        		return false;
            }
            if(password!=re_password)
            {
            	document.getElementById("msg5").innerHTML="** 	Passwords Are Not Same";
        		return false;
            }
            
        }
 </script> 
    


</body>
</html>