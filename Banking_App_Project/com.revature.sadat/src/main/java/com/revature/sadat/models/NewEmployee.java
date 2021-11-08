package com.revature.sadat.models;

import java.sql.Date;

public class NewEmployee {
	
	private Integer actNum;
	private String activity, title, level;
	private Double salary;
	private String username, password, status;
	private Date date;
	
	
	public NewEmployee() {
		super();
	}
	
	
	public NewEmployee(Integer actNum, String activity, String title, String level, Double salary, String username,
			String password, String status, Date date) {
		super();
		this.actNum = actNum;
		this.activity = activity;
		this.title = title;
		this.level = level;
		this.salary = salary;
		this.username = username;
		this.password = password;
		this.status = status;
		this.date = date;
	}


	public Integer getActNum() {
		return actNum;
	}


	public void setActNum(Integer actNum) {
		this.actNum = actNum;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "NewEmployee [Action#: " + actNum + ", Action: " + activity + ", Title: " + title + ", Level: " + level
				+ ", Salary: " + salary + ", Emp_username: " + username + ", Emp_password: " + password + ", Status: " + status
				+ ", Date: " + date + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actNum == null) ? 0 : actNum.hashCode());
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		NewEmployee other = (NewEmployee) obj;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
