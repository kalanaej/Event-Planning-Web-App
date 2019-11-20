package Login.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import Login.model.User;


public interface LoginService {
		
					//
	public static final Logger log = Logger.getLogger(LoginService.class.getName());

	public void addUser(User user);

	public User getUserByID(String userID);

	public ArrayList<User> getUsers();
	
	public User updateUser(String userID, User user);

	public void removeUser(String userID);
}
