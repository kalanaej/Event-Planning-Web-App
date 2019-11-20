package event.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	/*private static Connection conn = null;

	public static Connection getDBConnection() {
		try {
			if(conn == null || conn.isClosed()) {
				try {
					conn = getConnection();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Connection getConnection()throws SQLException, ClassNotFoundException {
		Connection con=null;
		try {
			if(conn ==  null) {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "");
				System.out.println("connected");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return con;
	}*/
	public Connection getConnection()throws SQLException,ClassNotFoundException{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "");
			System.out.println("connected");
		return con;
		
	}
}

