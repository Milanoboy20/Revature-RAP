package com.revature.sadat.models;

public class Account {
	
	private String accType;
	private Double startBalance;
	
	
	
	public Account() {
		super();
	}
	
	public Account(Double startBalance, String accType) {
		super();
		this.startBalance = startBalance;
		this.accType = accType;
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
		return "Account [Account Type =" + accType + ", Balance =" + startBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
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
		if (startBalance == null) {
			if (other.startBalance != null)
				return false;
		} else if (!startBalance.equals(other.startBalance))
			return false;
		return true;
	}
	
	

}
