package com.revature.sadat.models;



public class SystemAdmin {
	private Integer admin_ID, admin_salary;
	private String admin_level;
	
	
	public SystemAdmin() {
		super();
	}
	
	public SystemAdmin(Integer admin_ID, Integer admin_salary, String admin_level) {
		super();
		this.admin_ID = admin_ID;
		this.admin_salary = admin_salary;
		this.admin_level = admin_level;
	}

	public Integer getAdmin_ID() {
		return admin_ID;
	}

	public void setAdmin_ID(Integer admin_ID) {
		this.admin_ID = admin_ID;
	}

	public Integer getAdmin_salary() {
		return admin_salary;
	}

	public void setAdmin_salary(Integer admin_salary) {
		this.admin_salary = admin_salary;
	}

	public String getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}

	@Override
	public String toString() {
		return "Admin [admin_ID=" + admin_ID + ", admin_salary=" + admin_salary + ", admin_level=" + admin_level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_ID == null) ? 0 : admin_ID.hashCode());
		result = prime * result + ((admin_level == null) ? 0 : admin_level.hashCode());
		result = prime * result + ((admin_salary == null) ? 0 : admin_salary.hashCode());
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
		SystemAdmin other = (SystemAdmin) obj;
		if (admin_ID == null) {
			if (other.admin_ID != null)
				return false;
		} else if (!admin_ID.equals(other.admin_ID))
			return false;
		if (admin_level == null) {
			if (other.admin_level != null)
				return false;
		} else if (!admin_level.equals(other.admin_level))
			return false;
		if (admin_salary == null) {
			if (other.admin_salary != null)
				return false;
		} else if (!admin_salary.equals(other.admin_salary))
			return false;
		return true;
	}
	

}
