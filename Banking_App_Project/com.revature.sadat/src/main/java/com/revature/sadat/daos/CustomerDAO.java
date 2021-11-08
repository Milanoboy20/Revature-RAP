package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Customer;
import com.revature.sadat.models.Employee;

public interface CustomerDAO {
	public boolean insertCustomer(Customer cus);
	public Customer selectByID(Integer id);
	public boolean updateCustomer(Customer cus);
	public boolean removeCustomer(Integer id);
	public List<Customer> allCustomers();

}
