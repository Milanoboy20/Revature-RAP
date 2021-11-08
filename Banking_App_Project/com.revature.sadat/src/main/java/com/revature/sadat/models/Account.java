package com.revature.sadat.models;

public class Account {
	
	private String accType;
	private Double startBalance;
	private Integer acc_ID;
	private Integer cus_ID;
	
	
	
	public Account() {
		super();
	}
	
	public Account(Integer cus_ID, String accType, Double startBalance, Integer acc_ID) {
		super();
		this.cus_ID = cus_ID;
		this.accType = accType;
		this.startBalance = startBalance;
		this.acc_ID = acc_ID;
	}
	
	

	public Integer getCus_ID() {
		return cus_ID;
	}

	public void setCus_ID(Integer cus_ID) {
		this.cus_ID = cus_ID;
	}

	public Integer getAcc_ID() {
		return acc_ID;
	}

	public void setAcc_ID(Integer acc_ID) {
		this.acc_ID = acc_ID;
	}

	public Double getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(Double startBalance) {
		this.startBalance = startBalance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Account [Type: " + accType + ", Balance: $" + startBalance + ", Account ID: " + acc_ID 
				+ ", Customer ID: "	+ cus_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
		result = prime * result + ((acc_ID == null) ? 0 : acc_ID.hashCode());
		result = prime * result + ((cus_ID == null) ? 0 : cus_ID.hashCode());
		result = prime * result + ((startBalance == null) ? 0 : startBalance.hashCode());
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
		Account other = (Account) obj;
		if (accType == null) {
			if (other.accType != null)
				return false;
		} else if (!accType.equals(other.accType))
			return false;
		if (acc_ID == null) {
			if (other.acc_ID != null)
				return false;
		} else if (!acc_ID.equals(other.acc_ID))
			return false;
		if (cus_ID == null) {
			if (other.cus_ID != null)
				return false;
		} else if (!cus_ID.equals(other.cus_ID))
			return false;
		if (startBalance == null) {
			if (other.startBalance != null)
				return false;
		} else if (!startBalance.equals(other.startBalance))
			return false;
		return true;
	}

	

	

	
	

}
