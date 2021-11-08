package com.revature.sadat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


import com.revature.sadat.models.SystemAdmin;

class AdminTest {

	private SystemAdmin adm = new SystemAdmin(1, 500000.00, "Level 5");
	
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
		adm = new SystemAdmin(1, 500000.00, "Level 5");
	}
	
	@After
	public void after() {
		System.out.println("After Test!");
	}
	
	
	@Test
	public void testAdminID() {
		System.out.println("Admin ID Test");		
		int expectedID = 1;		
		int adminID = adm.getAdmin_ID();
		
		assertEquals(expectedID, adminID);
	}
	
	@Test
	public void testAdminLevel() {
		System.out.println("Admin Level Test");		
		
		String expectedLvl = "Level 5";		
		String adminLvl = adm.getAdmin_level();
		
		assertTrue(expectedLvl.equals(adminLvl));
	}
	
	@Test
	public void testAdminSalary() {
		System.out.println("Admin Salary Test");		
		
		Double salary         = 500000.00;	
		Double expectedSalary = adm.getAdmin_salary();
		
		assertEquals(expectedSalary, salary);
	}

}
