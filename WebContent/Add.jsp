<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Events</title>
         <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.css'>
		<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/style99.css">
      <style>
.button {
    background-color: yellow;
    border: none;
    color: blacke;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
      
        <script type="text/javascript"> 
        function validate()
        {
        	//validation part
            var name_pattern= /^[a-z A-Z]+$/; 
            var category_pattern= /^[a-z A-Z]+$/; 
            var description_pattern= /^[a-z A-Z]+$/;
            var place_pattern= /^[a-z A-Z]+$/; 
            var price_pattern= /^[0-9]+$/;
       
          //get textbox id 
            var name = document.getElementById("name"); 
            var category = document.getElementById("category"); 
            var description = document.getElementById("description"); 
            var place = document.getElementById("place");
            var price = document.getElementById("price");
              
            if(!name_pattern.test(name.value) || name.value=='') //check if condition using test
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
    <body background="img/admin.jpg">
   <jsp:include page="WEB-INF/views/header1.jsp"></jsp:include>
    <div class="signupSection">
  <div class="info">
    <h2>Function Junction</h2>
    <i class="icon ion-ios-ionic-outline" aria-hidden="true"></i>
    <p>Add Events Admin </p>
  </div>
   <form method="post" action="AddServlet" onsubmit="return validate();">
    <h2>ADD EVENTS</h2>
    <ul class="noBullet">
      <li>
	  
         	<table>
			<tr>

				<td>Event name :</td>
				<td><input type="text" name="name" placeholder="Event Name" id="name"><br><br></td>
			</tr>
			
			<tr>
				<td>Category</td>
				<td><input type="radio" name="category" id="category" value="Birthday"
					checked="checked" tabindex="1" /> Birthday Celebration</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category" id="category" value="Wedding"
					tabindex="2" /> Wedding Ceremony</td>
			</tr>
				<tr>
				<td></td>
				<td><input type="radio" name="category" id="category" value="Entertainment"
					tabindex="3" /> Entertainment Event</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category" id="category" value="Anniversary"
					tabindex="4" /> Anniversary Party</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="category" id="category" value="Other"
					tabindex="5" /> Other Event/Party</td>
			<tr>
				<td>Description : </td>
				<td><input type="text" name="description" placeholder="Description" id="description"><br><br></td>
			</tr>
			<tr>
				<td>Place :</td>
				 <td><input type="text" name="place" placeholder="Place" id="place"><br><br></td>
			</tr>
			<tr>
				<td>Price Start from :</td>
				<td><input type="text" name="price" placeholder="Price" id="price"><br><br></td>
			</tr>
			<tr>
			     <li id="center-btn">
        <td><input type="submit" id="join-btn" name="btn_add" alt="Join" value="Add Event"></td>
      </li>
			<li id="center-btn">
        <td><input type="reset" id="join-btn" name="btn_add" alt="Join" value="Reset"></td>
      </li>			
			</tr>
		</table>
	
 
    
    </ul>
  </form>
</div>
  
    <script src="js/index.js"></script>
 
               
            <center>
                <h3 style="color:red;">
                <%
                    if(request.getAttribute("InsertErrorMsg")!=null)
                    {
                        out.println(request.getAttribute("InsertErrorMsg")); //get error message
                    }
                %>
                </h3>
             
                
                <a href="index.jsp" class="button">Event List</a>
                
            </center>
    
        </form>
    
 </div>

 
<jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>
       
    </body>
</html>