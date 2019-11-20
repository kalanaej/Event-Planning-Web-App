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
 * Servlet implementation class UpdatePaymentServlet
 */
@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePaymentServlet() {
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
			
			String paymentID = request.getParameter("paymentID");
			
			payment.setPaymentID(paymentID);
			payment.setType(request.getParameter("type"));
			payment.setCard(request.getParameter("card"));
			payment.setNumber(request.getParameter("cardNumber"));
			/*int cvv = Integer.parseInt(request.getParameter("cvv"));
			payment.setCvv(cvv);*/
			payment.setCvv(request.getParameter("cvv"));
			
			String email = request.getParameter("email");	
			payment.setEmail(email);
			
			String balance = request.getParameter("balance");	
			payment.setBalance(balance);
			
			if(request.getParameter("type") == null || request.getParameter("card") == null || request.getParameter("cardNumber") == "" || request.getParameter("cvv") == "" || request.getParameter("email") == "")
			{
				JOptionPane.showMessageDialog(null, "Please fill all the fields");
				response.sendRedirect("Payment.jsp");
			}
			else if(!request.getParameter("cardNumber").matches("^[0-9]+$") || request.getParameter("cardNumber").length() != 16){
				
				JOptionPane.showMessageDialog(null, "Invalid Card Number!");
				response.sendRedirect("Payment.jsp");
			
			}
			else if(!request.getParameter("cvv").matches("^[0-9]+$") || request.getParameter("cvv").length() != 3){
				
				JOptionPane.showMessageDialog(null, "Invalid cvv Number!");
				response.sendRedirect("Payment.jsp");
			
			}
			else if(validateEmail(email)==false) {
				JOptionPane.showMessageDialog(null, "Email Entered Invalid.Please Re-enter");
				response.sendRedirect("Payment.jsp");
			}
			
			IPayment iPaymentService = new PaymentHandle();
			iPaymentService.updatePaymentDetails(paymentID,payment);
			
			JOptionPane.showMessageDialog(null, "Payment successfull");
	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			System.out.println("Error from UpdatePaymentServlet "+e);
			JOptionPane.showMessageDialog(null,"Error from UpdatePaymentServlet " +e);
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

}
