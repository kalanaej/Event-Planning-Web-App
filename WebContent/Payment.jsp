<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "payment.css" />
   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>
	
<div class="frm" >
	<form method="POST" action="AddPaymentServlet">
		<center><caption><h1>Payment</h1></caption>
		<table>
			<tr>
				<td>Select Card type</td>
				<td class="rad"><input type="radio" name="type" value="credit" class="checkmark"/> Credit</td>
				<td class="rad"><input type="radio" name="type" value="debit" class="checkmark"/> Debit</td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>Select Card name</td>
				<td class="rad"><input type="radio" name="card" value="visa" class="checkmark"/> Visa</td>
				<td class="rad"><input type="radio" name="card" value="master" class="checkmark"/> Master</td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" class="txtnumber"/></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvv" class="txtcvv"/></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" class="txtemail"/></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Purchase" class="add-button" /> </td>
				
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
		
	</form>
	
	<form method="POST" action="ListPaymentServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="Your previous payments" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="/WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>