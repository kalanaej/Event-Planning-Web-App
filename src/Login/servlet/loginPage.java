package Login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Login.util.connectDb;

/**
 * Servlet implementation class loginPage
 */
@WebServlet("/loginPage")
public class loginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginPage() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{	
			connectDb db = new connectDb();
				
		String uname=request.getParameter("userName");
		String password=request.getParameter("uPassword");
		String username=null;
		String pwd=null;
		String type=null;

		 db.rs=db.st.executeQuery("select * from user where username ='"+uname+"' and Password='"+password+"'");



	 		if(!db.rs.next())
	 		{
	 			JOptionPane.showMessageDialog(null, "Please Enter User Name....");
	 			response.sendRedirect("Login.jsp");
	 		}
	 		else
	 		{
	 			do
	 			{
	 				username = db.rs.getString("username");
	 				pwd = db.rs.getString("Password");
	 				type= db.rs.getString("type");
	 			} while(db.rs.next());
	 			
	 				if(pwd.equals(password))
	 				{
	 					if(type.equals("admin"))
	 					{
	 						HttpSession session = request.getSession();
	 						session.setAttribute("username", username);
	 						session.setAttribute("type", type);
	 						response.sendRedirect("AdminPanal.jsp");
	 					}
	 					else
	 					{
	 						HttpSession session = request.getSession();
	 						session.setAttribute("username", username);
	 						session.setAttribute("type", type);
	 						response.sendRedirect("Home.jsp");
	 					}
	 				}
	 				else
	 				{
	 					JOptionPane.showMessageDialog(null, "Username or Password Incorrect\n Please Re-enter");
						response.sendRedirect("Login.jsp");
	 				}
	 				
	 		}
	 		
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error" +e);
			response.sendRedirect("Login.jsp");

		}

			
			doGet(request, response);
		}
	 						
	 			
}


