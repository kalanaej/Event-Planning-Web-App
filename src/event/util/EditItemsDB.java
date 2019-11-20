package event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import event.model.EditEventWithPackages;

public class EditItemsDB {
	public String checkUpdate(EditEventWithPackages editItem) { 
	
		
        String name_up= editItem.getName_up(); //get name through Event object and store in temporary variable "name"
        String category_up= editItem.getCategory_up(); //get owner through Event object and store in temporary variable "owner"
        String description= editItem.getDescription_up(); //get name through Event object and store in temporary variable "name"
        String place= editItem.getPlace_up(); //get owner through Event object and store in temporary variable "owner"
        double price= editItem.getPrice_up(); //get owner through Event object and store in temporary variable "owner"
        String eventID_up= editItem.getEventID_up();
        String dj_up=editItem.getDj_up();
        String cake_up=editItem.getCake_up(); 
        String flower_up=editItem.getFlower_up();
        
       /* String url="jdbc:mysql://localhost:3306/event"; //database connection url string
        String username="root"; //database connection username
        String password=""; //database password*/
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver"); //load driver
            //Connection con=DriverManager.getConnection(url,username,password); //create connection
            
            //PreparedStatement pstmt=null; //create statement
        	
        	DBConnection db = new DBConnection();
        	Connection con = null;
        	con=db.getConnection();
        	
	        PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("update items set eventName=?,category=?,description=?,place=?,price=?,dj=?,cake=?,flower=? where eventID=? "); //sql update query
            pstmt.setString(1,name_up);
            pstmt.setString(2,category_up);
            pstmt.setString(3,description);
            pstmt.setString(4,place);
            pstmt.setDouble(5,price);
            pstmt.setString(6,dj_up);
            pstmt.setString(7,cake_up);
            pstmt.setString(8,flower_up);
            pstmt.setString(9,eventID_up);
            pstmt.executeUpdate(); //execute query
            
            pstmt.close(); //close statement
            
            con.close(); //close connection
            
            return "UPDATE SUCCESS"; //if valid return "UPDATE SUCCESS" string
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Not connected");
        }
        
        return "FAIL UPDATE"; //if invalid return "FAIL UPDATE" string
}

	


}
