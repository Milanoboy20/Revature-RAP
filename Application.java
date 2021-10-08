package week6_excersice;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		List<Account> acc = Account.createAccounts(6);
		
		
		for(Account ac : acc) {
			
			System.out.println("ID: " + ac.getId() + " Account Type: " + ac.getAccountType());
		}
		
		

	}

}
