<%@page import="payment.model.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="payment.service.PaymentHandle"%>
<%@page import="payment.service.IPayment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<div align="center">
		<table border="5" cellpadding="12" class="pay">
		 	<caption><h2>List of Payments</h2></caption>
		 		<a href="Payment.jsp">Back</a>
		  	<tr>
                <th>Card type</th>
                <th>Card name</th>
                <th>Card Number</th>
                <th>CVV</th>
                <th>E-mail</th>
                <th>Select</th>
                <th>Remove</th>
            </tr>
            <%
            	IPayment iPaymentService = new PaymentHandle();
                ArrayList<Payment> arrayList = iPaymentService.listPayments();
                        	
                for(Payment payment : arrayList){
            %>
			 <tr>
				<td> 
					<%=payment.getType() %> 
				</td>
				<td>
					<%=payment.getCard() %> 
				</td>
				<td> 
					<%=payment.getNumber() %> 
				</td>
				<td> 
					<%=payment.getCvv() %> 
				</td>
				<td> 
					<%=payment.getEmail() %> 
				</td>
				<td> 
					<form method="POST" action="GetPaymentServlet">
						<input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>"/>
				 		<input type="submit" value= "Select Payment" class="select-button" /> 
				 	</form>
				</td>	
				<td colspan="2">
					<form method="POST" action="DeletePaymentServlet">
						<input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>" /> 
						<input type="submit" value="Delete Payment" class="delete-button"/>
					</form>
				</td>
			</tr>			
			<%	
			   }
            %>     
		</table>
	</div>
	<jsp:include page="/WEB-INF/views/footer1.jsp"></jsp:include>
</body>
</html>