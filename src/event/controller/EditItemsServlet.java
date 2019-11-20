package event.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.EditEventWithPackages;
import event.util.EditItemsDB;

/**
 * Servlet implementation class EditItemsServlet
 */
@WebServlet("/EditItemsServlet")
public class EditItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemsServlet() {
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
		if(request.getParameter("btn_edit")!=null) //check button click event not null form edit.jsp page after continue
        {
           
            String name_up=request.getParameter("name"); //get textbox name "txt_name"
            String category_up=request.getParameter("category"); //get textbox name "txt_owner"
            String description_up=request.getParameter("description"); //get textbox name "txt_name"
            String place_up=request.getParameter("place"); //get textbox name "txt_owner"
            double price_up=Double.parseDouble(request.getParameter("price"));
            String eventID_up=request.getParameter("hidden_id"); //get hidden id name "hidden_id"
            String dj_up=request.getParameter("dj"); 
            String cake_up=request.getParameter("cake"); 
            String flower_up=request.getParameter("flower"); 
            
            EditEventWithPackages editItem=new EditEventWithPackages(name_up, category_up, description_up,place_up, eventID_up, price_up, 0, dj_up, cake_up,flower_up); //this class contain setting up all receive values from edit.jsp page to seeter and getter method for application require effectively
            
            editItem.setName_up(name_up); 
            editItem.setCategory_up(category_up);
            editItem.setDescription_up(description_up); 
            editItem.setPlace_up(place_up);
            editItem.setPrice_up(price_up);
            editItem.setEventID_up(eventID_up);
            editItem.setDj_up(dj_up);
            editItem.setCake_up(cake_up);
            editItem.setFlower_up(flower_up);
            
            EditItemsDB editEventDB=new EditItemsDB(); //this class contain main logic to perform function calling and database operation
            
            String updateValidate=editEventDB.checkUpdate(editItem); //send editBean object values into checkUpdate() function in EditDao class
            
            if(updateValidate.equals("UPDATE SUCCESS")) //check calling checkUpdate() function receive string "UPDATE SUCCESS" after redirect to index.jsp page and display update record
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); //setAttribute value is "UpdateSuccessMsg" for update successfully message
                RequestDispatcher rd=request.getRequestDispatcher("Item.jsp");
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); //setAttribute value is "UpdateErrorMsg" for update fail message
                RequestDispatcher rd=request.getRequestDispatcher("EditItems.jsp");
                rd.include(request, response);
            }
        }
        
        }
}