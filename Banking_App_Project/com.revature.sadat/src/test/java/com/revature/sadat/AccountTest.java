package com.revature.sadat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.sadat.models.Account;



public class AccountTest {
	
private Account acc; // = new Account(1234, "Checking", 2500.00, 1056);
	
	@BeforeClass
	public static void beforClass() {
		System.out.println("Before Mlass Method!");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class Method!");
	}
	
	@Before
	public void before() {
		System.out.println("Before Test!");
		acc = new Account(1234, "Checking", 2500.00, 1056);
	}
	
	@After
	public void after() {
		System.out.println("After Test!");
	}
	
	
	@Test
	public void testAccountID() {
		System.out.println("Account ID Test");		
		int expectedID = 1056;		
		int accID = acc.getAcc_ID();
		
		assertEquals(expectedID, accID);
	}
	
	@Test
	public void testAccountType() {
		System.out.println("Customer StateID Test");		
		
		String expectedID = "Checking";		
		String accType = acc.getAccType();
		
		assertTrue(expectedID.equals(accType));
	}
	
	@Test
	public void testAccountBalance() {
		System.out.println("Account Balance Test");		
		
		Double cusB      = 2500.00;	
		Double balance = acc.getStartBalance();
		
		assertEquals(balance, cusB);
	}
	
	@Test
	public void testAccountCusID() {
		System.out.println("Account Customer ID Test");		
		
		int cussID      = 1234;	
		int cus_ID = acc.getCus_ID();
		
		assertEquals(cus_ID, cussID);
	}

}
