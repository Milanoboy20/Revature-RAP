package com.revature.sadat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.jupiter.api.Test;

import com.revature.sadat.models.*;

class EmployeeTest {

	private Employee emp = new Employee(1,500000.00, "Admin", "Level 5");
	
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
		emp = new Employee(1,500000.00, "Admin", "Level 5");
	}
	
	@After
	public void after() {
		System.out.println("After Test!");
	}
	
	
	@Test
	public void testEmployeeID() {
		System.out.println("Employee ID Test");		
		int expectedID = 1;		
		int empID = emp.getEmp_ID();
		
		assertEquals(expectedID, empID);
	}
	
	@Test
	public void testEmployeeLvl() {
		System.out.println("Employee Level Test");		
		
		String expectedLvl = "Level 5";		
		String empLvl = emp.getEmp_level();
		
		assertTrue(expectedLvl.equals(empLvl));
	}
	
	@Test
	public void testEmployeeTitle() {
		System.out.println("Employee Title Test");		
		
		String expectedTitle = "Admin";		
		String empTitle = emp.getEmp_title();
		
		assertEquals(expectedTitle, empTitle);
	}

}
