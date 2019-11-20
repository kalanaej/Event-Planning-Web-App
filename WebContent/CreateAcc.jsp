<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<jsp:include page="WEB-INF/views/header.jsp"></jsp:include>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ACC Create</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon1/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style1.css">
    
    
    
</head>
<body>



    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" action="AddUserServlet"  id="signup-form" class="signup-form" onsubmit="return val()">
                        <h2 class="form-title">Create account</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="Your Name"/>
                            <span id = "msg1" style = " color: red; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="userAddress" id="userAddress" placeholder="Address"/>
                            <span id = "msg2" style = " color: red; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="e_mail" id="email" placeholder="Your Email"/>
                            <span id = "msg3" style = " color: red; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-input" name="userName" id="userName" placeholder="User Name"/>
                            <span id = "msg4" style = " color: red; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="uPassword" id="password" placeholder="Password"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                           <span id = "msg5" style = " color: red; font-size: 12px; font-weight: bold; font-style: italic; text-transform: uppercase;   font-family: "Times New Roman", Times, serif;" ></span>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="Login.jsp" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>
    
    
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
    
 

    <!-- JS -->
    <script src="vendor/jquery1/jquery.min.js"></script>
    <script src="js/main1.js"></script>
    <jsp:include page="WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>



