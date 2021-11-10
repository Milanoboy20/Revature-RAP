package com.revature.sadat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.sadat.models.Customer;


public class CustomerTest {
	
	private Customer cus = new Customer(3, "1234ABC", 1234);
	
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
		cus = new Customer(3, "1234ABC", 1234);
	}
	
	@After
	public void after() {
		System.out.println("After Test!");
	}
	
	
	@Test
	public void testCustomerID() {
		System.out.println("Customer ID Test");		
		int expectedID = 3;		
		int cusID = cus.getCus_ID();
		
		assertEquals(expectedID, cusID);
	}
	
	@Test
	public void testCustomerStateID() {
		System.out.println("Customer StateID Test");		
		
		String expectedID = "1234ABC";		
		String stateID = cus.getStateID();
		
		assertTrue(expectedID.equals(stateID));
	}
	
	@Test
	public void testCustomerSS() {
		System.out.println("Customer SS Test");		
		
		int cusSS      = 1234;	
		int expectedSS = cus.getSocialSec();
		
		assertEquals(expectedSS, cusSS);
	}

}
