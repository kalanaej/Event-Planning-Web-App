package event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.EventwithPackages;
import event.util.AddItemDB;

/**
 * Servlet implementation class AddItemsServlet
 */
@WebServlet("/AddItemsServlet")
public class AddItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemsServlet() {
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
            String dj=request.getParameter("dj"); 
            String cake=request.getParameter("cake"); 
            String flower=request.getParameter("flower"); 
            
            
            EventwithPackages eventi =new EventwithPackages(name, category, description,place, price, dj, cake, flower); //this class is receiving values from add.jsp page to setters and getter 
            
          //set values through event object
            eventi.setName(name); 
            eventi.setCategory(category); 
            eventi.setDescription(description); 
            eventi.setPlace(place); 
            eventi.setPrice(price);
            eventi.setDj(dj);
            eventi.setCake(cake);
            eventi.setFlower(flower);
          
            
            AddItemDB addEventDb =new AddItemDB(); 
            
            String insertValidate= addEventDb.checkInsert(eventi); 
            
            if(insertValidate.equals("INSERT SUCCESS")) 
            {
                request.setAttribute("InsertSuccessMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("InsertErrorMsg",insertValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("AddItems.jsp");
                rd.include(request, response);
            }
        }
	}

}
