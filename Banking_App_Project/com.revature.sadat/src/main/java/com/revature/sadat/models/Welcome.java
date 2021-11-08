package com.revature.sadat.models;

import java.util.*;

import com.revature.sadat.daos.*;
import com.revature.sadat.daos.LoginDAOImpl;
import com.revature.sadat.services.AccountServices;
import com.revature.sadat.services.EmployeeServices;
import com.revature.sadat.services.LoginVerification;

public class Welcome {
	
	public static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		
		welcome();
		

	}
	
	public static void welcome() {
		System.out.println("Welcome to BankApp!");
		System.out.println("1.Login     2.SignUp");
		int select = scnr.nextInt();		
		
		if(select == 1) {
			login();
		} else if(select == 2) {
			signUp();
		}
	}
	
	
	public static void login() {
		String user = "";
		String pass = "";
		System.out.println("Enter username:");
		user += scnr.next() + scnr.nextLine();
		
		System.out.println("Enter password:");
		pass += scnr.next() + scnr.nextLine();
		
		
		LoginDAO lg           = new LoginDAOImpl();
		Login uLog            = null;
		AppUserDAO adao       = new AppUserDAOImpl();
		AppUser auser         = null; 
		LoginVerification log = new LoginVerification();
		Customer cus = null;
		CustomerDAO cdao = new CustomerDAOImpl();
		Employee emp = null;
		EmployeeDAO edao = new EmployeeDAOImpl();
		SystemAdmin adm = null;
		SystemAdminDAO admin = new SysAdminDAOImpl();		
		
			
			if(log.verify(user, pass) != null) {
				auser = log.verify(user, pass);
				if(auser.getTitle().equalsIgnoreCase("Customer")) {
//					System.out.println("Verified!");
					uLog = lg.selectByUsername(user, pass);
					cus = cdao.selectByID(uLog.getLoginID());
					customer(cus);
					
				} else if(auser.getTitle().equalsIgnoreCase("Employee")) {
//					System.out.println("Verified!");
					uLog = lg.selectByUsername(user, pass);
					emp = edao.selectByID(uLog.getLoginID());
					employee(emp, user, pass);
					
				}else if(auser.getTitle().equalsIgnoreCase("System Admin")) {
					uLog = lg.selectByUsername(user, pass);
					adm = admin.selectByID(uLog.getLoginID());
					admin(adm, user, pass);
					
				} else {
					System.out.println("Please register for an account.\n\n");
					welcome();
				}
			} 
			else {
				System.out.println("Invalid username/password. \nPlease enter a valid credential");
				login();
			}						
			
		

	}
	
	
	public static void customer(Customer cus) {

		System.out.println("\n1.Deposit          2.Withdraw            3.Transfer  "
				+ "\n4.View Accounts     5.Create Account      6.Transactions "
				+ "\n7.Logout");	
		int select = scnr.nextInt();
		
		
		if(select == 1) {
			deposit(cus);			
		}
		else if(select == 2) {
			withdraw(cus);
		} 
		else if(select == 3) {
			transfer(cus);
		}
		else if(select == 4) {
			accounts(cus);
		}
		else if(select == 5) {
			create(cus);
		}
		else if(select == 6) {
			actions(cus);
		}else if(select == 7) {
			System.out.println("Logged out!\n\n");
			welcome();
		}

	}
	
	public static void deposit(Customer cus) {
		AccountServices serv = new AccountServices();
		Double amount;
		Integer id;
		
		System.out.println("\nDeposit amount: $");
		amount = scnr.nextDouble();
		System.out.println("\nEnter  Account ID: ");
		id = scnr.nextInt();
		
		if(((amount < 0) || (serv.getAccount(id) == null)) && ((serv.getAccount(id).getCus_ID()) != (cus.getSocialSec()))) {
			System.out.println("Invalid amount/account. \nPlease enter a valid amount and account.");
			deposit(cus);
		}else {
			if(serv.deposit(cus.getSocialSec(), id, amount) == true)
			System.out.println("\nBalance is now: $" + serv.getAccount(id).getStartBalance());
		}
		
		System.out.println("\n1.Main menu   2.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			customer(cus);
		} else if(select == 2) {
			System.out.println("Logout Successful!\n\n");
			welcome();
		}
	}
	
	public static void withdraw(Customer cus) {
		AccountServices serv = new AccountServices();
		Double amount;
		Integer id;
		
		System.out.println("Withdraw amount: $");
		amount = scnr.nextDouble();
		System.out.println("Enter  Account ID: ");
		id = scnr.nextInt();
		
		if((amount < 0 || serv.getAccount(id) == null) && serv.getAccount(id).getAcc_ID() != id) {
			System.out.println("Invalid amount/account. \nPlease enter a valid amount and account.");
			withdraw(cus);
		}else {
			if(serv.withdraw(cus.getSocialSec(), id, amount) == true)
			System.out.println("Balance is now: $" + serv.getAccount(id).getStartBalance());
		}
		
		System.out.println("\n1.Main menu   2.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			customer(cus);
		} else if(select == 2) {
			System.out.println("Logout Successful!\n\n");
			welcome();
		}
	}
	
	public static void transfer(Customer cus) {
		AccountServices serv = new AccountServices();
		Double amount;
		Integer id;
		Integer id2;
		
		System.out.println("Transfer amount: $");
		amount = scnr.nextDouble();
		System.out.println("From  Account ID: ");
		id = scnr.nextInt();
		System.out.println("To Account ID: ");
		id2 = scnr.nextInt();
		
		if((amount < 0 || (serv.getAccount(id) == null)) || (serv.getAccount(id2) == null) 
				&& serv.getAccount(id).getCus_ID() != cus.getSocialSec()) {
			System.out.println("Invalid amount/account IDs. \nPlease enter a valid amount and account IDs.");
			transfer(cus);
		}else {
			serv.send(id, id2, amount);
			System.out.println("Sent: $" + amount + " \nFrom Account:  " + id
					+ "   To Account:   " + id2);
		}
		
		System.out.println("\n1.Main menu   2.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			customer(cus);
		} else if(select == 2) {
			System.out.println("Logout Successful!/n/n");
			welcome();
		}
	}
	
	
	public static void accounts(Customer cus) {
		AccountServices serv = new AccountServices();		
		
		if(serv.allAccounts(cus.getSocialSec()).size() <= 0) {
			System.out.println("\nYou have no registered accounts.");
		}else {
			for(int i = 0; i < serv.allAccounts(cus.getSocialSec()).size(); i++) {
				System.out.println(serv.allAccounts(cus.getSocialSec()).get(i));
			}
		}					
		delete(cus);
		
	}
	
	public static void delete(Customer cus) {
		AccountServices serv = new AccountServices();
		System.out.println("\n1.Delete an account     2.Main menu     3.Logout");
		int select = scnr.nextInt();
		
		if(select == 2) {
			customer(cus);
		} else if(select == 3) {
			System.out.println("Logout Successful!\n\n");
			welcome();
		} else if(select == 1) {
			System.out.println("Enter account ID to remove: ");
			int id = scnr.nextInt();
			
			if(serv.deleteAccount(id) == true) {
				System.out.println("Account " + id + " has been removed." );
				delete(cus);
			}
			
		}
	}
	
	
	public static void create(Customer cus) {
		AccountServices serv = new AccountServices();
		Account ac = null;
		Double amount;
		String type;
		int last = 0;
		
		System.out.println("Account type: ");
		type = scnr.next() + scnr.nextLine();
		
		System.out.println("Start amount(0.0): ");
		amount = scnr.nextDouble();
		
		if(amount < 0) {
			System.out.println("Invalid amount/account. \nPlease enter a valid amount and account.");
			create(cus);
		}else {
			if(serv.createAccount(cus.getSocialSec(), amount, type) == true)
				last = serv.allAccounts(cus.getSocialSec()).size();
					ac = serv.allAccounts(cus.getSocialSec()).get(last - 1);
					System.out.println("\nNew Account: \n" + ac);			
		}
						
		System.out.println("\n1.Main menu   2.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			customer(cus);
		} else if(select == 2) {
			System.out.println("Logout Successful!\n\n");
			welcome();
		}				
	}
	
	
	public static void actions(Customer cus) {
		AccountServices serv = new AccountServices();
		
		for(int i = 0; i < serv.actions(cus.getSocialSec()).size(); i++) {
			System.out.println(serv.actions(cus.getSocialSec()).get(i));
		}
						
		System.out.println("\n1.Main menu   2.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			customer(cus);
		} else if(select == 2) {
			System.out.println("Logout Successful!\n\n");
			welcome();
		}				
	}
	
	
	public static void empMenu(Employee emp, String user, String pass) {
		System.out.println("\n1.Main Menu      2.Logout");
		int choice = scnr.nextInt();
		if(choice == 1) {
			employee(emp, user, pass);
		}else if(choice == 2) {
			System.out.println("Logged out!\n\n");
			welcome();
		}
	}
	
	public static void employee(Employee emp, String user, String pass) {
		EmployeeDAO edao = new EmployeeDAOImpl();
		EmployeeServices eserv = new EmployeeServices();
		CustomerDAO cdao = new CustomerDAOImpl();
		Customer cus = null;
		LoginDAO ldao = new LoginDAOImpl();
		Login lg = null;
		lg = ldao.selectByUsername(user, pass);
		AppUserDAO adao = new AppUserDAOImpl();
		String name = adao.selectByID(lg.getUserID()).getName();
		
		
		System.out.println("Hello " + name + "!");
		System.out.println("\n1.Actions     2.Customers      3.Logout");
		int select = scnr.nextInt();
		
		if(select == 1) {
			System.out.println("All customer actions.");
				List<EmpActions> emact = eserv.allNewCusAccounts();
				for(EmpActions empAct : emact) {
					System.out.println(empAct);
				}
						
			System.out.println("\nEnter Action#:");
			int actNum = scnr.nextInt();
			
			System.out.println("\nApprove/Decline accounts.");
			String act = scnr.next() + scnr.nextLine();
			
			eserv.updateNewCusAccount(actNum, act);
			
			if(act.equalsIgnoreCase("Approve")) {
				List<AppUser> app = adao.allAppUsers();
				for(AppUser au : app) {
					System.out.println(au);
				}
				
				System.out.println("\nEnter Customer userID:");
				int userID = scnr.nextInt();
				
				Login log = eserv.cusLogin(actNum);
				log.setUserID(userID);
				
				if(ldao.insertLogin(log) == true) {
					System.out.println("Customer Login created.");
				} else {
					System.out.println("Error creating login.\n\n");
					empMenu(emp, user, pass);
				}
				
				cus = eserv.getCustomer(actNum);
				if(cdao.insertCustomer(cus)) {
					System.out.println("\nCustomer account created.\n");					
					System.out.println(cus.toString() + "\n\n");
					
					empMenu(emp, user, pass);
					
				} else {
					System.out.println("Error! Restart process.");
					empMenu(emp, user, pass);
				}
			}
			else if(act.equalsIgnoreCase("decline")) {								
				System.out.println("Customer account declined.");	
				empMenu(emp, user, pass);
			}
			
		}
		
		else if(select == 2) {
			System.out.println("\n1.View All Customers     \n2.Check Customer Account Balance    \n3.Create Customer Account\n"
					+ "4.Delete Customer Account");
			int next = scnr.nextInt();
			if(next == 1) {
				cusView(emp, user, pass);
			}
			else if(next == 2) {
				checkBalance();
				empMenu(emp, user, pass);
			}
			else if(next == 3) {
				createCusAccount();
				empMenu(emp, user, pass);
			}
			else if(next == 4) {
				deleteCusAccount();
				empMenu(emp, user, pass);
			}
		} 
		
		else if (select == 3) {
			System.out.println("\nLogged out!\n\n");
			welcome();
		}
	}
	
		
	public static void deleteCusAccount() {
		AccountServices serv = new AccountServices();
		
		System.out.println("Enter Account ID:");
		int accID = scnr.nextInt();
		
		if(serv.deleteAccount(accID) == true) {
			System.out.println("Account deleted.");
		} else {
			System.out.println("Error occured! Retry");
			deleteCusAccount();
		}
	}
	
	
	public static void createCusAccount() {
		EmployeeServices eserv = new EmployeeServices();
		int cusID;
		
		System.out.println("Enter Customer ID:");
		cusID = scnr.nextInt();
		
		System.out.println("Enter Account type:");
		String accType = scnr.next() + scnr.nextLine();
		
		System.out.println("Start amount:");
		Double startBalance = scnr.nextDouble();
		
		if(eserv.createCusAccount(cusID, accType, startBalance) == true) {
			System.out.println("\nCustomer account created successfully.\n");
		} else {
			System.out.println("Error! Restart process\n\n");
			createCusAccount();
		}
	}
	
	
	public static void cusView(Employee emp, String user, String pass) {
		CustomerDAO cdao = new CustomerDAOImpl();
		
		List<Customer> customers = cdao.allCustomers();
		for(Customer cust : customers) {
			System.out.println(cust);				
		}		
		
		System.out.println("\n\n1.Remove Customer Account      2.Main Menu      3.Logout");
		int choice = scnr.nextInt();
		if(choice == 2) {
			employee(emp, user, pass);
		} else if(choice == 3){
			System.out.println("Logged out!\n\n");
			welcome();
		} else if(choice == 1) {
			deleteCus(emp, user, pass);
		}
	}
	
	public static void checkBalance() {
		AccountServices serv = new AccountServices();
		
		System.out.println("Enter Account ID:");
		int accID = scnr.nextInt();
		
		System.out.println("Account Balance: $" + serv.balance(accID));
		
	}
	
	
	public static void deleteCus(Employee emp, String user, String pass) {
		CustomerDAO cdao = new CustomerDAOImpl();
		LoginDAO ldao    = new LoginDAOImpl();
		AppUserDAO adao  = new AppUserDAOImpl();
		Login lg = null;
		
		
		System.out.println("Enter Cus_ID to remove:");
		int id = scnr.nextInt();
		lg = ldao.selectByLoginID(id);
		
		if(cdao.removeCustomer(id)) {
			adao.removeAppUser(lg.getUserID());
			ldao.removeLogin(id);
			System.out.println("Customer: " + id + " removed from database.");
			empMenu(emp, user, pass);
		} else {
			System.out.println("Error occured!");
			empMenu(emp, user, pass);
		}
	}


	public static void admin(SystemAdmin adm, String user, String pass) {
		System.out.println("Admin!");
	}
	
	public static void signUp() {
		AppUserDAO adao = new AppUserDAOImpl();
		AppUser user = new AppUser();
		EmployeeServices emp = new EmployeeServices();
		
		
		System.out.println("Please enter your info to create a new profile.");
		System.out.println("\nFull Name:");
		String name = scnr.nextLine() + scnr.nextLine();
		user.setName(name);
		
		System.out.println("\nAddress:");
		String address = scnr.next() + scnr.nextLine();
		user.setAddress(address);
		
		System.out.println("\nEmail:");
		String email = scnr.next() + scnr.nextLine();
		user.setEmail(email);
		
		System.out.println("\nPhone");
		String phone = scnr.next() + scnr.nextLine();
		user.setPhone(phone);
		
		System.out.println("\nTitle(Employee / Customer)");
		String title = scnr.next() + scnr.nextLine();
		user.setTitle(title);
		
		
		System.out.println("Name: " + name + ",  Address: " + address +",  Phone: " + phone 
				+ ",  Email: " + email + "  Title: " + title);
		
		adao.insertAppUser(user);
		
		for(int i = 0; i < adao.allAppUsers().size(); i++) {
			System.out.println(adao.allAppUsers().get(i));
		}
//		System.out.println(adao.allAppUsers());
		System.out.println("Successfully created profile!");
		
		System.out.println("\nApply for a: \n1.Customer Account    2.Employee Account");
		int select = scnr.nextInt();
		if(select == 1) {
			System.out.println("\nEnter you State ID:");
			String stateID = scnr.next() + scnr.nextLine();
			
			System.out.println("Last four digits of Social Security:");
			int cus_SS = scnr.nextInt();
			
			System.out.println("\nNew username:");
			String username = scnr.next() + scnr.nextLine();
			
			System.out.println("New password:");
			String password = scnr.next() + scnr.nextLine();
			
			if(emp.newCus(stateID, cus_SS, username, password) == true) {
				System.out.println("\nWait for 48hrs for your account to be approved.");
			} else {
				System.out.println("Sign up error!");
			}
			
			System.out.println("\n1.Return to Main      2.Exit");
			int next = scnr.nextInt();
			if(next == 1) {
				welcome();
			} else if(next == 2) {
				System.out.println("Have a wondeful day. GoodBye!");
			} 
			welcome();
		} 
		else if(select == 2) {
			System.out.println("Title: ");
			String empTitle = scnr.nextLine() + scnr.nextLine();
			
			System.out.println("Level:");
			String level = scnr.next() + scnr.nextLine();
			
			System.out.println("Salary: $");
			Double salary = scnr.nextDouble();
			
			System.out.println("New username:");
			String emp_user = scnr.next() + scnr.nextLine();
			
			System.out.println("New password: ");
			String emp_pass = scnr.next() + scnr.nextLine();
			
			if(emp.newEmp(empTitle, level, salary, emp_user, emp_pass) == true) {
				System.out.println("\nYour account will be approved by an employee shortly. "
						+ "\nThank you!");
			} else {
				System.out.println("Sign up error!");
			}
			
			
			System.out.println("\n1.Return to Main      2.Exit");
			int next = scnr.nextInt();
			if(next == 1) {
				welcome();
			} else if(next == 2) {
				System.out.println("Have a wondeful day. GoodBye!\n\n");
			}
			
			welcome();
		}
	}

}
