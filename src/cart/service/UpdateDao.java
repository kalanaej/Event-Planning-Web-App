package cart.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import cart.model.UpdateBean;

public class UpdateDao 
{
    public String checkUpdate(UpdateBean updateBean)
    {
        String description_up=updateBean.getDescription_up();
        String price_up=updateBean.getPrice_up();
        String quantity_up=updateBean.getQuantity_up();
        String sDate_up=updateBean.getsDate_up();
        String eDate_up=updateBean.geteDate_up();//get all value through updateBean object and store in temporary variable
        int hidden_id=updateBean.getHidden_id();
        
        String url="jdbc:mysql://localhost/event"; //database connection url string
        String username="root"; //database connection username
        String password=""; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,username,password); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("update cart set eventDes=?,price=?,quantity=?,sDate=?,eDate=? where eventId=? "); //sql update query
            pstmt.setString(1,description_up);
            pstmt.setString(2,price_up);
            pstmt.setString(3,quantity_up);
            pstmt.setString(4,sDate_up);
            pstmt.setString(5,eDate_up);
            pstmt.setInt(6,hidden_id);
            pstmt.executeUpdate(); //execute querys
            
            pstmt.close(); //close statement
            
            con.close(); //close connection
            
            return "UPDATE SUCCESS"; //if valid return "UPDATE SUCCESS" string
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "FAIL UPDATE"; //if invalid return "FAIL UPDATE" string
    }

}
