package payment.util;

import java.util.Properties;

/*
 * Load all properties from jdbc.properties
 */
public class Property {

	//Use to get data from properties file and store data into properties file
	public static final Properties prop = new Properties();

	static {
		try {
			
			// Read the jdbc.properties
			prop.load(QueryLocation.class.getResourceAsStream(Constants.PROPERTIES));
			
		} catch (Exception e) {
			System.out.println("Error from IDHandle "+e);
		}
	}
}
