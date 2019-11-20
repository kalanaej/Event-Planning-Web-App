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
 * Servlet implementation class GetEmployeeServlet
 */
@WebServlet("/GetPaymentServlet")
public class GetPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPaymentServlet() {
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
			
	 		String paymentID = request.getParameter("paymentID");			
	 		
			IPayment iPaymentService = new PaymentHandle();
			Payment payment = iPaymentService.GetPayments(paymentID);
	
			request.setAttribute("payment", payment);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/EditPayment.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error from GetPaymentServlet " +e);
			response.sendRedirect("Payment.jsp");
	
		}
	}

}
