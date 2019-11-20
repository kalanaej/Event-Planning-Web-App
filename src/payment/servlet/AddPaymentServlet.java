package payment.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import payment.model.Payment;
import payment.service.IPayment;
import payment.service.PaymentHandle;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
			response.setContentType("text/html");

			Payment payment = new Payment();
			
			String type = request.getParameter("type");
			payment.setType(type);
			String card = request.getParameter("card");
			payment.setCard(card);
			String number = request.getParameter("cardNumber");
			payment.setNumber(number);
			String cvv = request.getParameter("cvv");
			payment.setCvv(cvv);
			String email = request.getParameter("email");
			payment.setEmail(email);
			
			if(validateVisaNumber(number) == true){
				
				if(emptyFields(type,card,number,cvv,email) == false){
				
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
					response.sendRedirect("Payment.jsp");
				}
				else if(validateCvv(cvv) == false){
				
					JOptionPane.showMessageDialog(null, "Invalid cvv Number!");
					response.sendRedirect("Payment.jsp");
			
				}
				else if(validateEmail(email) == false) {
					
					JOptionPane.showMessageDialog(null, "Email Entered Invalid.Please Re-enter");
					response.sendRedirect("Payment.jsp");
				}
				else if(emptyFields(type,card,number,cvv,email) == true || validateVisaNumber(number) == true || validateCvv(cvv) == true || validateEmail(email) == true){
					
					IPayment iPaymentService = new PaymentHandle();
					iPaymentService.addPaymentDetails(payment);
			
					request.setAttribute("payment", payment);
					
					JOptionPane.showMessageDialog(null, "Payment successfull");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
				
					dispatcher.forward(request, response);
				}
			}
			
			else if(validateMasterNumber(number) == true){
				
				if(emptyFields(type,card,number,cvv,email) == false){
				
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
					response.sendRedirect("Payment.jsp");
				}
				else if(validateCvv(cvv) == false){
				
					JOptionPane.showMessageDialog(null, "Invalid cvv Number!");
					response.sendRedirect("Payment.jsp");
			
				}
				else if(validateEmail(email) == false) {
					
					JOptionPane.showMessageDialog(null, "Email Entered Invalid.Please Re-enter");
					response.sendRedirect("Payment.jsp");
				}
				else if(emptyFields(type,card,number,cvv,email) == true || validateMasterNumber(number) == true || validateCvv(cvv) == true || validateEmail(email) == true){
					
					IPayment iPaymentService = new PaymentHandle();
					iPaymentService.addPaymentDetails(payment);
			
					request.setAttribute("payment", payment);
					
					JOptionPane.showMessageDialog(null, "Payment successfull");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
				
					dispatcher.forward(request, response);
				}
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Invalid Card Number!");
				response.sendRedirect("Payment.jsp");
		}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error from AddPaymentServlet" +e);
			response.sendRedirect("Payment.jsp");
	
		}
	}
	
	private boolean validateEmail(String email) {
		
		
		int at=email.indexOf("@");
		int dot=email.indexOf(".");
		
		if(at < 1 || dot + 2 >= email.length() ||at + 2 >dot){
			return false;
		}
		else
			return true;
		
	}
	
	private boolean emptyFields(String type, String card, String number, String cvv, String email) {
		if(type == null || card == null || number == "" || cvv == "" || email == "") {
				return false;
		}
		else
			return true;
	}
	
	private boolean validateVisaNumber(String number) {
		if(!number.matches("^4[0-9]{12}(?:[0-9]{3})?$") || number.length() != 16) {
			return false;
		}
		else
			return true;
	}
	
	private boolean validateMasterNumber(String number) {
		if(!number.matches("^5[1-5][0-9]{14}$") || number.length() != 16) {
			return false;
		}
		else
			return true;
	}
	
	private boolean validateCvv(String cvv) {
		if(!cvv.matches("^[0-9]+$") || cvv.length() != 3) {
			return false;
		}
		else
			return true;
	}
}
