package week6_excersice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
	
	private long id;
	private String accountType;
	static Random rand = new Random();
//	private static List<Account> acc;
	
	public Account(long id, String accountType) {		
		this.id          = id;
		this.accountType = accountType;
	}
	
	public static List<Account> createAccounts(int numAccounts) {
		
		List<Account> acc = new ArrayList<>();
		
		for(int i = 0; i < numAccounts; i++) {
			if(rand.nextInt(10) > 5) {
				acc.add(i, new Account(rand.nextInt(10), "Savings account"));
			}
			else {
				acc.add(i, new Account(rand.nextInt(15), "Checking account"));
			}						
		}
				
		return acc;
		
	}
	
		

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
