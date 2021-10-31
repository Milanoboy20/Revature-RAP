package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Customer;

public interface CustomerDAO {
	public Account getAccount(Customer cus, String accType);
	public boolean createAccount(Customer cus, Double startBalance, String accType);
	public boolean deposit(Customer cus, String accType, Double amount);
	public boolean withdraw(Customer cus, String accType, Double amount);
	public void send(Customer acc, Customer acc2, Double amount, String accType);
	public List<Account> allAccounts(Integer id);
	public boolean deleteAccount(Account acc, Customer cus, Double balance);

}
