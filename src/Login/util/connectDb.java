package Login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDb {

	public Statement st;
	public Connection con;
	public ResultSet rs;
	
	public ResultSet rs1;
	public Statement st1;
	
	public connectDb() {

		try {

			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/event";
			String username="root";
			String password="";
			Class.forName(driver);
			
			
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("connected to database");
			 st=con.createStatement();
			st1=con.createStatement();
		

	}catch(Exception e) {
		System.out.println("ERROR" +e);
	}
	
	}
}
