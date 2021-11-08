package com.revature.sadat.models;

import java.sql.Date;

public class Activity {
	
	private Integer cus_id, acc_id;
	private Date dt;
	private String act;
	
	
	
	public Activity() {
		super();
	}
	
	
	public Activity(Integer cus_id, Integer acc_id, Date dt, String act) {
		super();
		this.cus_id = cus_id;
		this.acc_id = acc_id;
		this.dt = dt;
		this.act = act;
	}


	public Integer getCus_id() {
		return cus_id;
	}


	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}


	public Integer getAcc_id() {
		return acc_id;
	}


	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}


	public Date getDt() {
		return dt;
	}


	public void setDt(Date dt) {
		this.dt = dt;
	}


	public String getAct() {
		return act;
	}


	public void setAct(String act) {
		this.act = act;
	}


	@Override
	public String toString() {
		return "Activity [Customer:  " + cus_id + "  ACCOUNT:   " + acc_id 
				+ "  DATE:   " + dt + "  ACTION:   " + act + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_id == null) ? 0 : acc_id.hashCode());
		result = prime * result + ((act == null) ? 0 : act.hashCode());
		result = prime * result + ((cus_id == null) ? 0 : cus_id.hashCode());
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
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
		Activity other = (Activity) obj;
		if (acc_id == null) {
			if (other.acc_id != null)
				return false;
		} else if (!acc_id.equals(other.acc_id))
			return false;
		if (act == null) {
			if (other.act != null)
				return false;
		} else if (!act.equals(other.act))
			return false;
		if (cus_id == null) {
			if (other.cus_id != null)
				return false;
		} else if (!cus_id.equals(other.cus_id))
			return false;
		if (dt == null) {
			if (other.dt != null)
				return false;
		} else if (!dt.equals(other.dt))
			return false;
		return true;
	}
	
	
	
	
	

}
