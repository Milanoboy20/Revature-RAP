package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Customer;
import com.revature.sadat.models.Employee;

public class DAOtest {

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		CustomerDAO cdao = new CustomerDAOImpl();
//		Employee e = edao.selectByID(2);
//		System.out.println(e);
		
		
//		Employee add = new Employee(2, 150000.00, "Tester", "Level 5");
//		Employee ad = new Employee(3, 150000.00, "Tester", "Level 5");
//		add.setEmp_level("lvl 3");
		
		Customer cus = new Customer(1234,"456ABC", 5555);
		Customer cus2 = new Customer(5678,"123ABC", 4545);
		
//		if(cdao.createAccount(cus2, 200.00, "Savings")) {
//			System.out.println("Success!");
//		} else
//			System.out.println("Failed!");
		
//		if(cdao.withdraw(cus, "Checking", 100.00)) {
//			System.out.println("Success!");
//		} else
//			System.out.println("Failed!");
		
		
//		List<Employee> eList = edao.allEmployees();
//		for(Employee emp : eList) {
//			System.out.println(emp);
//		}
		
//		cdao.deleteAccount(cdao.getAccount(cus, "Savings"), cus, 1700.00);
//		cdao.send(cus, cus, 100.00, "Savings");
		
		List<Account> acc = cdao.allAccounts(cus.getCus_ID());
		for(Account ac : acc) {
			System.out.println(ac);
		}
		
//		Employee add = new Employee(2, 150000.00, "Tester", "Level 5");
//		if(edao.removeEmployee(2)) {
//			System.out.println("Success!");
//		} else
//			System.out.println("Failed!");

	}

}
