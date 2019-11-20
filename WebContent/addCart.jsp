<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="WEB-INF/views/header2.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>EventPlanning/addCart</title>
<style>
body {
	background:url(img/back3.jpg) no-repeat center fixed;
	background-size: cover; 
	
}
table,th,td {
	color:white;
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
h1 {
    color: white;
}
</style>

</head>
<body>
<center><h1 style=font-size:50px>Event List</h1></center>
<form action="viewCart.jsp">
 
  <input type="image" src="img/cartbutton.png" alt="Submit" align="right" width="48" height="48">
</form>
<center>
<div class=ex2 > 
<table style= border="0" align = center >
	<tr>
		<td>
  		<form name="event1" method="POST" action="createCart">
  			<p>
    			<h1>Weddings</h1> <input type="hidden" name="description" value="Wedding">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Full Package 		- Rs.800000.00 <input type="radio" name="price" value="800000" tabindex="1" ><br>
      				Partial Package 	- Rs.750000.00 <input type="radio" name="price" value="750000" tabindex="2" ><br>
      				On The Day 			- Rs.500000.00 <input type="radio" name="price" value="500000" tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity">
			</p>
 			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
    		<input type="submit" class="button" name="addToCart" value="Book Now"/>
			
  		</form>
  		</td>
  		<td><img src="img/wedding.jpg" width="600" height="300"  /></td>
  	</tr>
  	
  	<tr>
		<td>
  		<form name="event2" method="POST" action="createCart">
  			<p>
    			<h1>Private Parties</h1><input type="hidden" name="description" value="Private Party">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Birthday Parties 		- Rs.20000.00 <input type="radio" name="price" value="20000" tabindex="1" ><br>
      				Get together Parties 	- Rs.50000.00 <input type="radio" name="price" value="50000" tabindex="2" ><br>
      				Private Events 			- Rs.75000.00 <input type="radio" name="price" value="75000" tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity">
			</p>
			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
    		<input type="submit" class="button" name="addToCart" value="Book Now">
  
  		</form>
  		</td>
  		<td><img src="img/bdayparty.jpg" width="600" height="300" /></td>
  	</tr>
  	
  	<tr>
		<td>
  		<form name="event3" method="POST" action="createCart">
  			<p>
    			<h1>Corporate Events</h1><input type="hidden" name="description" value="Corporate Event">
  			</p>
    		<p>
    			<strong>Our Packages : </strong><br><br>
    				Conferences 		- Rs.300000.00 <input type="radio" name="price" value="300000" tabindex="1" ><br>
      				Corporate Parties 	- Rs.150000.00 <input type="radio" name="price" value="150000" tabindex="2" ><br>
      				Employee Fun Days 	- Rs.70000.00 <input type="radio" name="price" 	value="70000"  tabindex="3" >
     		</p>
    		<p>
    			<strong>No Of Participants  : </strong> <input type="text" size="2"  name="quantity">
			</p>
 			<p>
    			<strong>Start Date  : </strong> <input type="date" id="start" name="sDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
 			<p>
    			<strong>End Date  : </strong> <input type="date" id="end" name="eDate" value=" " min="2018-01-01" max="2018-12-31" />
			</p>
    		<input type="submit" class="button" name="addToCart" value="Book Now">
  
  		</form>
  		</td>
  		<td><img src="img/corporate.jpg" width="600" height="300" /></td>
  	</tr>
  	
</table>
</div>
</center>
<jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>