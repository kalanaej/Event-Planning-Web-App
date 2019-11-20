package Login.model;

public class User {
	
	private String UserID;

	private String Name;

	private String Address;
	
	private String Email;
	
	private String UserName;

	private String Password;
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String userAddress) {
		Address = userAddress;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String e_mail) {
		Email = e_mail;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String uPassword) {
		Password = uPassword;
	}
	
public String toString() {
		
		return "UserID = " + UserID + "Name = " + Name + "\n" + "Address = " + Address + "\n" + "Email = " + Email + "\n"
				+ "UserName = " + UserName + "\n" + "Password = " + Password;
	}

}
