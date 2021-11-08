package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Activity;
import com.revature.sadat.models.AppUser;
import com.revature.sadat.models.Customer;
import com.revature.sadat.models.Employee;
import com.revature.sadat.models.Login;
import com.revature.sadat.models.SystemAdmin;
import com.revature.sadat.services.AccountServices;

public class DAOtest {

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		
		Employee cdao = new Employee();
		AccountServices ac = new AccountServices();
		AppUserDAO adao = new AppUserDAOImpl();
		LoginDAO ldao = new LoginDAOImpl();
		SystemAdminDAO sdao = new SysAdminDAOImpl();
//		Employee e = edao.selectByID(2);
//		System.out.println(e);
		
		
//		Employee add = new Employee(2, 150000.00, "Tester", "Level 5");
//		Employee ad = new Employee(3, 150000.00, "Tester", "Level 5");
//		add.setEmp_level("lvl 3");
		
		
		
		Customer cus = new Customer(1234,"456ABC", 5555);
		Customer cus2 = new Customer(5678,"123ABC", 4545);
		AppUser us1 = new AppUser("James Taylor", "9295862435", "119 WoodHaven Ave", "Tester" ,"james@gmail.com");
		Login lg = new Login(2, "new_sam", "sam2");
//		lg.setUserName("longjohn");
//		lg.setPassword("johnlong");
//		lg.setUserID(7);
//		lg.setLoginID(5);
//		ldao.insertLogin(lg);
//		ldao.updateLogin(lg);
//		ldao.removeLogin(9);
//		System.out.println(ldao.selectByUsername("mallam", "mallam20"));
//		SystemAdmin sd = new SystemAdmin(5, 125000.00, "2");
//		sd.setAdmin_level("4");
//		sd.setAdmin_salary(200000.00);
//		sdao.insertAdmin(sd);
//		sdao.updateAdmin(sd);
//		List<Login> logs= ldao.allLogins();
//		for(Login logins : logs) {
//			System.out.println(logins);
//		}
		
		
//		adao.insertAppUser(us1);
//		adao.removeAppUser(12);
//		ac.createAccount(5678, 1500.00, "Loan");
//		ac.deleteAccount(5678, 1002);
		
//		if(cdao.createAccount(cus2, 500.00, "Checking")) {
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
//		ac.send(1000, 1006, 50.00);
		
//		Account act = ac.getAccount(1006);
//		System.out.println("Account Searched: " + act);
		
		List<Account> acc = ac.allAccounts(cus2.getCus_ID());
		for(Account acs : acc) {
			System.out.println(acs);
		}
		
//		List<Activity> act = ac.actions(cus2.getCus_ID());
//		for(Activity acts : act) {
//			System.out.println(act);
//		}
		
//		List<AppUser> users = adao.allAppUsers();
//		for(AppUser ap : users) {
//			System.out.println(ap);
//		}
		
//		List<Login> lgs = ldao.allLogins();
//		for(Login log : lgs) {
//			System.out.println(log);
//		}
		
//		List<SystemAdmin> adms = sdao.allAdmins();
//		for(SystemAdmin adm : adms) {
//			System.out.println(adm);
//		}
		
//		Employee add = new Employee(2, 150000.00, "Tester", "Level 5");
//		if(edao.removeEmployee(2)) {
//			System.out.println("Success!");
//		} else
//			System.out.println("Failed!");

	}

}
