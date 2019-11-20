package Login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Login.model.User;
import Login.util.CommonConstantsUser;
import Login.util.CommonUtilUser;
import Login.util.DBConnectionUtilUser;
import Login.util.QueryUtilUser;



public class UserServiceImpl  implements LoginService{
	
	
	
	private static Connection con;

	private static Statement statement;

	private PreparedStatement pStatement;

	
	public static void createUserTable() {

		try {
			con = DBConnectionUtilUser.getDBConnection();
			statement = con.createStatement();
			statement.executeUpdate(QueryUtilUser.queryByID(CommonConstantsUser.CREATE_TABLE));

		} catch (Exception e) {
			System.out.println("Error from createUserTable " + e);
		}
	}

	
	@Override
	public void addUser(User user) {

		String userID = CommonUtilUser.generateIDs(getUserIDs());
		
		try {
			con = DBConnectionUtilUser.getDBConnection();
			
			
			pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.INSERT_USER));
			con.setAutoCommit(false);
		
			user.setUserID(userID);
			pStatement.setString(CommonConstantsUser.CI_ONE, user.getUserID());
			pStatement.setString(CommonConstantsUser.CI_TWO, user.getName());
			pStatement.setString(CommonConstantsUser.CI_THREE, user.getAddress());
			pStatement.setString(CommonConstantsUser.CI_FOUR, user.getEmail());
			pStatement.setString(CommonConstantsUser.CI_FIVE, user.getUserName());
			pStatement.setString(CommonConstantsUser.CI_SIX, user.getPassword());
			 
		
			pStatement.execute();
			con.commit();

		} catch (Exception e) {
			System.out.println("Error from generateIDs " + e);
		}finally {
			
			try {
				if (pStatement != null) {
					pStatement.close();
				}
				if (pStatement != null) {
					con.close();
				}
			} catch (SQLException e) {
				
			}
		}
			
	}

	@Override
	public User getUserByID(String userID) {

		return actionOnUser(userID).get(0);
	}
	
	@Override
	public ArrayList<User> getUsers() {
		
		return actionOnUser(null);
	}


	@Override
	public void removeUser(String userID) {

		
		if (userID != null && !userID.isEmpty()) {
			
			try {
				con = DBConnectionUtilUser.getDBConnection();
				pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.REMOVE_USER));
				pStatement.setString(CommonConstantsUser.CI_ONE, userID);
				pStatement.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("Error from removeUser " + e);
			}
		}
	}

	
	private ArrayList<User> actionOnUser(String userID) {

		ArrayList<User> userList = new ArrayList<User>();
		try {
			con = DBConnectionUtilUser.getDBConnection();
			
			if (userID != null && !userID.isEmpty()) {
				
				pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.GET_USER));
				pStatement.setString(CommonConstantsUser.CI_ONE, userID);
			}
			
			else {
				pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.ALL_USER));
			}
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setUserID(resultSet.getString(CommonConstantsUser.CI_ONE));
				user.setName(resultSet.getString(CommonConstantsUser.CI_TWO));
				user.setAddress(resultSet.getString(CommonConstantsUser.CI_THREE));
				user.setEmail(resultSet.getString(CommonConstantsUser.CI_FOUR));
				user.setUserName(resultSet.getString(CommonConstantsUser.CI_FIVE));
				user.setPassword(resultSet.getString(CommonConstantsUser.CI_SIX));
				userList.add(user);
			}

		} catch (Exception e) {
			System.out.println("Error from actionOnUser " + e);
		}
		return userList;
	}

	
	@Override
	public User updateUser(String userID, User user) {

		
		if (userID != null && !userID.isEmpty()) {
			
			try {
				con = DBConnectionUtilUser.getDBConnection();
				pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.UPDATE_USER));
				
				
				pStatement.setString(CommonConstantsUser.CI_ONE, user.getName());
				pStatement.setString(CommonConstantsUser.CI_TWO, user.getAddress());
				pStatement.setString(CommonConstantsUser.CI_THREE, user.getEmail());
				pStatement.setString(CommonConstantsUser.CI_FOUR, user.getUserName());
				pStatement.setString(CommonConstantsUser.CI_FIVE, user.getPassword());
				pStatement.setString(CommonConstantsUser.CI_SIX, user.getUserID());
				
				pStatement.executeUpdate();

			} catch (Exception e) {
				System.out.println("Error from updateUser " + e);
			} 
		}
		
		return getUserByID(userID);
	}
	
	
	private ArrayList<String> getUserIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			con = DBConnectionUtilUser.getDBConnection();
			pStatement = con.prepareStatement(QueryUtilUser.queryByID(CommonConstantsUser.GET_USER_IDS));
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstantsUser.CI_ONE));
			}
		} catch (Exception e) {
			System.out.println("Error from getUserIDs " + e);
		}
		return arrayList;
	}

}
