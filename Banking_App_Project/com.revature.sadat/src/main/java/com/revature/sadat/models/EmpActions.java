package com.revature.sadat.models;

import java.sql.Date;

public class EmpActions {
	private Integer actNum, cus_SS;
	private String activity, stateID, username, password, status;
	private Date dt;
	
	public EmpActions() {
		super();
	}
	
	
	public EmpActions(Integer actNum, Integer cus_SS, String activity, String stateID, String username, String password,
			String status, Date dt) {
		super();
		this.actNum   = actNum;
		this.cus_SS   = cus_SS;
		this.activity = activity;
		this.stateID  = stateID;
		this.username = username;
		this.password = password;
		this.status   = status;
		this.dt       = dt;
	}


	public Integer getActNum() {
		return actNum;
	}


	public void setActNum(Integer actNum) {
		this.actNum = actNum;
	}


	public Integer getCus_SS() {
		return cus_SS;
	}


	public void setCus_SS(Integer cus_SS) {
		this.cus_SS = cus_SS;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public String getStateID() {
		return stateID;
	}


	public void setStateID(String stateID) {
		this.stateID = stateID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDt() {
		return dt;
	}


	public void setDt(Date dt) {
		this.dt = dt;
	}


	@Override
	public String toString() {
		return "EmpActions [Action#: " + actNum +  ", Action: " + activity + ", CUS_SS: " + cus_SS + ", Cus_StateID: " + stateID
				+ ", Cus_username: " + username + ", Cus_password: " + password + ", Status: " + status + ", Date: " + dt + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actNum == null) ? 0 : actNum.hashCode());
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((cus_SS == null) ? 0 : cus_SS.hashCode());
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((stateID == null) ? 0 : stateID.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		EmpActions other = (EmpActions) obj;
		if (actNum == null) {
			if (other.actNum != null)
				return false;
		} else if (!actNum.equals(other.actNum))
			return false;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (cus_SS == null) {
			if (other.cus_SS != null)
				return false;
		} else if (!cus_SS.equals(other.cus_SS))
			return false;
		if (dt == null) {
			if (other.dt != null)
				return false;
		} else if (!dt.equals(other.dt))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (stateID == null) {
			if (other.stateID != null)
				return false;
		} else if (!stateID.equals(other.stateID))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
