
package Login.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import Login.service.LoginService;


public class CommonUtilUser {

						//Logger object is used to log messages for a specificsystem or application component
	public static final Logger log = Logger.getLogger(LoginService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			
			properties.load(QueryUtilUser.class.getResourceAsStream(CommonConstantsUser.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstantsUser.PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstantsUser.PREFIX + next;
		}
		return id;
	}
}
