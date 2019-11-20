
package Login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtilUser extends CommonUtilUser {

	private static Connection connection;

	
	private DBConnectionUtilUser() {
	}

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(CommonConstantsUser.DRIVER_NAME));
			connection = DriverManager.getConnection(
			properties.getProperty(CommonConstantsUser.URL),
			properties.getProperty(CommonConstantsUser.USERNAME), 
			properties.getProperty(CommonConstantsUser.PASSWORD));
		}
		return connection;
	}
}










