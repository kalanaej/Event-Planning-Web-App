package Login.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login.model.User;
import Login.service.LoginService;
import Login.service.UserServiceImpl;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.setContentType("text/html");
		
			//create a object in user class
		User user = new User();
		
		
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("userAddress"));
		user.setEmail(request.getParameter("e_mail"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("uPassword"));
		
		
		 
		LoginService LoginService = new UserServiceImpl();
		LoginService.addUser(user);
		
	
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginSucessefullMg.jsp");  //"/WEB-INF/views/MyAcc.jsp"
		dispatcher.forward(request, response);
	}

}
