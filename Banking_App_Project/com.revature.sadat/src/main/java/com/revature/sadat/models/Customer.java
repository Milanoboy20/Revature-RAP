package com.revature.sadat.models;

public class Customer {
	private Integer cus_ID;
	private String stateID;
	private Integer socialSec;
	
	public Customer(){
		super();
	}

	public Customer(Integer cus_ID, String stateID, Integer socialSec) {
		super();
		this.cus_ID = cus_ID;
		this.stateID = stateID;
		this.socialSec = socialSec;
	}

	public Integer getCus_ID() {
		return cus_ID;
	}

	public void setCus_ID(Integer cus_ID) {
		this.cus_ID = cus_ID;
	}

	public String getStateID() {
		return stateID;
	}

	public void setStateID(String stateID) {
		this.stateID = stateID;
	}

	public Integer getSocialSec() {
		return socialSec;
	}

	public void setSocialSec(Integer socialSec) {
		this.socialSec = socialSec;
	}

	@Override
	public String toString() {
		return "Customer [cus_ID=" + cus_ID + ", stateID=" + stateID + ", socialSec=" + socialSec + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cus_ID == null) ? 0 : cus_ID.hashCode());
		result = prime * result + ((socialSec == null) ? 0 : socialSec.hashCode());
		result = prime * result + ((stateID == null) ? 0 : stateID.hashCode());
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
		Customer other = (Customer) obj;
		if (cus_ID == null) {
			if (other.cus_ID != null)
				return false;
		} else if (!cus_ID.equals(other.cus_ID))
			return false;
		if (socialSec == null) {
			if (other.socialSec != null)
				return false;
		} else if (!socialSec.equals(other.socialSec))
			return false;
		if (stateID == null) {
			if (other.stateID != null)
				return false;
		} else if (!stateID.equals(other.stateID))
			return false;
		return true;
	}
	
	

}
