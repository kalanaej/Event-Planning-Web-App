package payment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import payment.util.Constants;
import payment.util.IDHandle;
/*
 * This class use to connect with database and this is child class of IDHandle
 */
public class DBConnect extends Property{
	
	private static Connection con;
	
	//Applying Singleton pattern to connect with database
	private static DBConnect db;
	
	private DBConnect() {
	}
	
	public static DBConnect getInstance() {
		if(db == null) {
			db = new DBConnect();
		}
				
		return db;
	}

	/*
	 * If connection null or connection is closed create database using given url, username and password.
	 * Use try catch for if database or database connection has error catch exception.
	 */
	public static Connection getDBConnection(){
		
		try {
			if (con == null || con.isClosed()) {

				Class.forName(prop.getProperty(Constants.DRIVER));
				con = DriverManager.getConnection(
					prop.getProperty(Constants.URL),
					prop.getProperty(Constants.USERNAME), 
					prop.getProperty(Constants.PASSWORD)
				);
			}
		}catch(Exception e) {
			System.out.println("Error from DBConnect! "+e);
	
		}
		return con;
	}
}
