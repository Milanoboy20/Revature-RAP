package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Employee;

public interface EmployeeDAO {
	
	public boolean insertEmployee(Employee emp);
	public Employee selectByID(Integer id);
	public boolean updateEmployee(Employee emp);
	public boolean removeEmployee(Integer id);
	public List<Employee> allEmployees();

}
