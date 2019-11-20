package event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import event.model.Event;
import event.util.AddEventDB;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		if(request.getParameter("btn_add")!=null) //check button click event not null 
		{
			
			//get text boxes name
            String name=request.getParameter("name"); 
            String category=request.getParameter("category"); 
            String description=request.getParameter("description"); 
            String place=request.getParameter("place"); 
            double price=Double.parseDouble(request.getParameter("price")); 
            
            
            Event event =new Event(name, category, description, place, price); //this class is receiving values from add.jsp page to setters and getter 
            
          //set values through event object
            event.setName(name); 
            event.setCategory(category); 
            event.setDescription(description); 
            event.setPlace(place); 
            event.setPrice(price); 
          
            
            AddEventDB addEventDb =new AddEventDB(); 
            
            String insertValidate= addEventDb.checkInsert(event); 
            
            if(insertValidate.equals("INSERT EVENT SUCCESSFULLY")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("Add.jsp");
                rd.include(request, response);
            }
        }
	}

}
