package cart.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.UpdateBean;
import cart.service.UpdateDao;


/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btn_edit")!=null) //check button click event not null form edit.jsp page after continue
        {
            String description_up=request.getParameter("description"); //get textbox name "txt_name"
            String price_up=request.getParameter("price");
            String quantity_up=request.getParameter("quantity");
            String sDate_up=request.getParameter("sDate");
            String eDate_up=request.getParameter("eDate");//get textbox name "txt_owner"
            int hidden_id=Integer.parseInt(request.getParameter("hidden_id")); //get hidden id name "hidden_id"
            
            UpdateBean updateBean=new UpdateBean(); //this class contain setting up all receive values from edit.jsp page to seeter and getter method for application require effectively
            
            updateBean.setDescription_up(description_up); 
            updateBean.setPrice_up(price_up); 
            updateBean.setQuantity_up(quantity_up);
            updateBean.setsDate_up(sDate_up);
            updateBean.seteDate_up(eDate_up);//set all value through editBean object
            updateBean.setHidden_id(hidden_id);
            
            UpdateDao editDao=new UpdateDao(); //this class contain main logic to perform function calling and database operation
            
            String updateValidate=editDao.checkUpdate(updateBean); //send editBean object values into checkUpdate() function in EditDao class
            
            if(updateValidate.equals("UPDATE SUCCESS")) //check calling checkUpdate() function receive string "UPDATE SUCCESS" after redirect to index.jsp page and display update record
            {
                request.setAttribute("UpdateSuccessMsg",updateValidate); //setAttribute value is "UpdateSuccessMsg" for update successfully message
                RequestDispatcher rd=request.getRequestDispatcher("viewCart.jsp");
                rd.forward(request, response);
            }
            
            else
            {
                request.setAttribute("UpdateErrorMsg",updateValidate); //setAttribute value is "UpdateErrorMsg" for update fail message
                RequestDispatcher rd=request.getRequestDispatcher("updateCart.jsp");
                rd.include(request, response);
            }
        }	
		
	}

}
