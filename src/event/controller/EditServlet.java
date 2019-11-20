package event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import event.model.EditEvent;
import event.util.EditEventDB;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		if(request.getParameter("btn_edit")!=null) 
        {
           
            String name_up=request.getParameter("name"); //get textbox name "txt_name"
            String category_up=request.getParameter("category"); 
            String description_up=request.getParameter("description"); 
            String place_up=request.getParameter("place"); 
            double price_up=Double.parseDouble(request.getParameter("price"));
            String eventID_up=request.getParameter("hidden_id"); 
            
            EditEvent editEvent=new EditEvent(name_up, category_up, description_up, place_up, eventID_up, price_up, 0); //receive values from edit.jsp page to seetter and getter 
            
            editEvent.setName_up(name_up); 
            editEvent.setCategory_up(category_up);
            editEvent.setDescription_up(description_up); 
            editEvent.setPlace_up(place_up);
            editEvent.setPrice_up(price_up);
            editEvent.setEventID_up(eventID_up);
            
            EditEventDB editEventDB=new EditEventDB(); //  function calling 
            
            String updateValidate=editEventDB.checkUpdate(editEvent); //send object values into checkUpdate()
            
            if(updateValidate.equals("UPDATE EVENT SUCCESS"))  //update msg
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); //  update successfully message
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); //update fail message
                RequestDispatcher rd=request.getRequestDispatcher("trialedit.jsp");
                rd.include(request, response);
            }
        }
        
        }
}

