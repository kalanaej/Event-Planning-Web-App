package event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import event.model.Event;

public class AddEventDB {

	public String checkInsert(Event event) {
		String name=event.getName(); //get name through Event object and store in temporary variable "name"
        String category=event.getCategory(); 
        String description=event.getDescription(); 
        String place=event.getPlace(); 
        double price=event.getPrice();
        
       /* String url="jdbc:mysql://localhost:3306/event"; //database connection url string
        String username="root"; //database connection username
        String password=""; //database password*/
       
        try
        {
        	  //Class.forName("com.mysql.jdbc.Driver"); //load driver
	         // Connection con=DriverManager.getConnection(url,username,password); //create connection
	            
        	
        	//DB CONNECT
        	DBConnection db = new DBConnection();
        	Connection con = null;
        	con=db.getConnection();
        	
	        PreparedStatement pstate=null; //create statement //
            
     
            
            pstate=con.prepareStatement("insert into events(eventName,category,description,place,price) values(?,?,?,?,?)"); //sql insert query
            pstate.setString(1,name);
            pstate.setString(2,category);
            pstate.setString(3,description);
            pstate.setString(4,place);
            pstate.setDouble(5,price);
    
            pstate.executeUpdate(); //execute query
            
            pstate.close(); //close statement
            
            con.close(); //close connection
            
            return "INSERT EVENT SUCCESS"; //if valid ,there is  message
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Not connected");
        }
        
        return "FAIL EVENT INSERT"; //if invalid,there is  message
    }
		
	

}
