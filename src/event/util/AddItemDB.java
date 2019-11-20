package event.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import event.model.EventwithPackages;

public class AddItemDB {

	public String checkInsert(EventwithPackages eventi) {
		String name=eventi.getName(); //get name through Event object and store in temporary variable "name"
        String category=eventi.getCategory(); //get owner through Event object and store in temporary variable "owner"
        String description=eventi.getDescription(); //get name through Event object and store in temporary variable "name"
        String place=eventi.getPlace(); //get owner through Event object and store in temporary variable "owner"
        double price=eventi.getPrice(); //get owner through Event object and store in temporary variable "owner"
        String dj=eventi.getDj();
        String cake=eventi.getCake();
        String flower=eventi.getFlower();
        
        /*String url="jdbc:mysql://localhost:3306/event"; //database connection url string
        String username="root"; //database connection username
        String password=""; //database password*/
      
        try
        {
        	 // Class.forName("com.mysql.jdbc.Driver"); //load driver
	          //Connection con=DriverManager.getConnection(url,username,password); //create connection
	            
	            //PreparedStatement pstmt=null; //create statement
        	
	            DBConnection db = new DBConnection();
	        	Connection con = null;
	        	con=db.getConnection();
	        	
		        PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into items(eventName,category,description,place,price,dj,cake,flower) values(?,?,?,?,?,?,?,?)"); //sql insert query
            pstmt.setString(1,name);
            pstmt.setString(2,category);
            pstmt.setString(3,description);
            pstmt.setString(4,place);
            pstmt.setDouble(5,price);
            pstmt.setString(6,dj);
            pstmt.setString(7,cake);
            pstmt.setString(8,flower);
    
            pstmt.executeUpdate(); //execute query
            
            pstmt.close(); //close statement
            
            con.close(); //close connection
            
            return "INSERT EVENT SUCCESS"; //if valid return "INSERT SUCCESS" string
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Not connected");
        }
        
        return "FAIL EVENT INSERT"; //if invalid return "FAIL INSERT" string
    }
		
	


}
