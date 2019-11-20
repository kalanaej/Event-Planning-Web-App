package cart.servlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.Cart;
import cart.service.cartServices;
/**
 * Servlet implementation class createCart
 */
@WebServlet("/createCart")
public class createCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart c1 = new Cart();
		cartServices c2 = new cartServices();


		//addcart Details Pass
		c1.setDescription(request.getParameter("description"));
		c1.setPrice(request.getParameter("price"));
		c1.setQuantity(request.getParameter("quantity"));
		c1.setsDate(request.getParameter("sDate"));
		c1.seteDate(request.getParameter("eDate"));
		
		
		
		try {
			c2.CreateCart(c1);
			response.sendRedirect("viewCart.jsp");
			return;
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		

		
		
	}

}
