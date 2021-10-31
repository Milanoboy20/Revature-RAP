package com.revature.sadat.models;



public class Employee {
	private Integer emp_ID, login_ID;
	private Double emp_salary;
	private String emp_title, emp_level;
	
	public Employee() {
		super();
	}				

	public Employee(Integer emp_ID, Double emp_salary, String emp_title, String emp_level) {
		super();
		this.emp_ID = emp_ID;
//		this.login_ID = login_ID;
		this.emp_salary = emp_salary;
		this.emp_title = emp_title;
		this.emp_level = emp_level;
	}

	public Integer getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(Integer emp_ID) {
		this.emp_ID = emp_ID;
	}

	public Integer getLogin_ID() {
		return login_ID;
	}

	public void setLogin_ID(Integer login_ID) {
		this.login_ID = login_ID;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_title() {
		return emp_title;
	}

	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}

	public String getEmp_level() {
		return emp_level;
	}

	public void setEmp_level(String emp_level) {
		this.emp_level = emp_level;
	}

	@Override
	public String toString() {
		return "Employee [emp_ID=" + emp_ID + ", login_ID=" + login_ID + ", emp_salary=" + emp_salary + ", emp_title="
				+ emp_title + ", emp_level=" + emp_level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_ID == null) ? 0 : emp_ID.hashCode());
		result = prime * result + ((emp_level == null) ? 0 : emp_level.hashCode());
		result = prime * result + ((emp_salary == null) ? 0 : emp_salary.hashCode());
		result = prime * result + ((emp_title == null) ? 0 : emp_title.hashCode());
		result = prime * result + ((login_ID == null) ? 0 : login_ID.hashCode());
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
		Employee other = (Employee) obj;
		if (emp_ID == null) {
			if (other.emp_ID != null)
				return false;
		} else if (!emp_ID.equals(other.emp_ID))
			return false;
		if (emp_level == null) {
			if (other.emp_level != null)
				return false;
		} else if (!emp_level.equals(other.emp_level))
			return false;
		if (emp_salary == null) {
			if (other.emp_salary != null)
				return false;
		} else if (!emp_salary.equals(other.emp_salary))
			return false;
		if (emp_title == null) {
			if (other.emp_title != null)
				return false;
		} else if (!emp_title.equals(other.emp_title))
			return false;
		if (login_ID == null) {
			if (other.login_ID != null)
				return false;
		} else if (!login_ID.equals(other.login_ID))
			return false;
		return true;
	}
	

}
