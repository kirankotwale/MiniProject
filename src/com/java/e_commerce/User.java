package com.java.e_commerce;

public class User {

	private String userName;
	private String password;
	private String mailId;

	public User(String userName, String password, String mailId) {
		super();
		this.userName = userName;
		this.password = password;
		this.mailId = mailId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", mailId=" + mailId + "]";
	}

}
