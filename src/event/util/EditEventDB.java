package event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import event.model.EditEvent;

public class EditEventDB {

	public String checkUpdate(EditEvent editEvent) {
	
	        String name_up=editEvent.getName_up(); 
	        String category_up=editEvent.getCategory_up(); 
	        String description=editEvent.getDescription_up(); 
	        String place=editEvent.getPlace_up(); 
	        double price=editEvent.getPrice_up();
	        String eventID_up=editEvent.getEventID_up();
	        
	       /* String url="jdbc:mysql://localhost:3306/event"; //database connection url string
	        String username="root"; //database connection username
	        String password=""; //database password*/
	        
	        try
	        {
	            //Class.forName("com.mysql.jdbc.Driver"); //load driver
	           // Connection con=DriverManager.getConnection(url,username,password); //create connection
	            //PreparedStatement pstmt=null; //create statement
	            
	        	DBConnection db = new DBConnection();
	        	Connection con = null;
	        	con=db.getConnection();
	        	
		        PreparedStatement pstmt=null; //create statement
	            
	            pstmt=con.prepareStatement("update events set eventName=?,category=?,description=?,place=?,price=? where eventID=? "); //sql update query
	            pstmt.setString(1,name_up);
	            pstmt.setString(2,category_up);
	            pstmt.setString(3,description);
	            pstmt.setString(4,place);
	            pstmt.setDouble(5,price);
	            pstmt.setString(6,eventID_up);
	            pstmt.executeUpdate(); //execute query
	            
	            pstmt.close(); //close statement
	            
	            con.close(); //close connection
	            
	            return "UPDATE SUCCESS"; // "UPDATE SUCCESS" MESSAGE
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("Not connected");
	        }
	        
	        return "FAIL UPDATE"; //"FAIL UPDATE" MESSAGE
	}

	
}
