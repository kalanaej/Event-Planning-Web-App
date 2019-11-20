package cart.service;
import java.sql.*;
public class DBConnection {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/event", "root", "");
		System.out.println("Successfully :) ");
		return conn;
	}


}
