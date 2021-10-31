package com.revature.sadat.models;

public class AppUser {
	private String name, phone, address, title, email;
	private Integer user_ID;
	
	public AppUser() {
		super();
	}
	
	public AppUser(String name, String phone, String address, String title, String email, Integer user_ID) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.title = title;
		this.email = email;
		this.user_ID = user_ID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getUser_ID() {
		return user_ID;
	}


	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}


	@Override
	public String toString() {
		return "AppUser [name=" + name + ", phone=" + phone + ", address=" + address + ", title=" + title + ", email="
				+ email + ", user_ID=" + user_ID + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user_ID == null) ? 0 : user_ID.hashCode());
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
		AppUser other = (AppUser) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_ID == null) {
			if (other.user_ID != null)
				return false;
		} else if (!user_ID.equals(other.user_ID))
			return false;
		return true;
	}
	
	

}
