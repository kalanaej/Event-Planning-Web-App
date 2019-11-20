<%@page import="payment.model.Payment"%>
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
	
	<%
		Payment payment = (Payment) request.getAttribute("payment");
	%>

	<div class="frm">
	<form method="POST" action="UpdatePaymentServlet">
		<center><caption><h1>Payment</h1></caption>
		<table>
			<tr>
				<td>Select Card type</td>
				<td><input type="radio" name="type" value="credit" checked="checked" tabindex="1" /> Credit</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="type" value="debit"tabindex="2" /> Debit</td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>Select Card name</td>
				<td><input type="radio" name="card" value="visa" checked="checked" tabindex="1" /> Visa</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="card" value="master" tabindex="2" /> Master</td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" value="<%=payment.getNumber()%>" /></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvv" value="<%=payment.getCvv()%>" /></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" value="<%=payment.getEmail()%>" /></td>
			</tr>
			
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td colspan="2">
					<input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>" /> 
					<input type="submit" value="Purchase" class="update-button"/>
				</td>
			</tr>
		</table>
	</form>
	</div>

	<jsp:include page="/WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>