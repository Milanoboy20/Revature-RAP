package com.revature.sadat.models;

public class Login {
	
	private Integer userID;
	private String userName, password;
	private Integer loginID;
	
	public Login() {
		super();
	}
	
	public Login(Integer userID, String userName, String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
	}
	
	public Login(Integer userID, String userName, String password, Integer loginID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.loginID = loginID;
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
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


	public Integer getLoginID() {
		return loginID;
	}


	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}

	@Override
	public String toString() {
		return "Login [UserID: " + userID + ", Username: " + userName + ", Password: " + password + ", LoginID: " + loginID
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginID == null) ? 0 : loginID.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (loginID == null) {
			if (other.loginID != null)
				return false;
		} else if (!loginID.equals(other.loginID))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
