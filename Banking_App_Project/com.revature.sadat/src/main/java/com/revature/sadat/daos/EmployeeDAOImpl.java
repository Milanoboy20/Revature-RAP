package com.revature.sadat.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.models.Employee;
import com.revature.sadat.utilities.ConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public boolean insertEmployee(Employee emp) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try(Connection con = ConnectionUtility.getConnection("samad", "milan")){
			String query = "INSERT INTO bankapp.employees VALUES(2,?,?,?);";
			ps = con.prepareStatement(query);
			
			ps.setString(1, emp.getEmp_title());
			ps.setString(2, emp.getEmp_level());
			ps.setDouble(3, emp.getEmp_salary());
			
			ps.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public Employee selectByID(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Employee emp = null;
		
		try (Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "SELECT * FROM bankapp.employees WHERE emp_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			res = ps.executeQuery();
			
			while(res.next()) {
				emp = new Employee();
				emp.setEmp_ID(res.getInt(1));
				emp.setEmp_title(res.getString(2));
				emp.setEmp_level(res.getString(3));
				emp.setEmp_salary(res.getDouble(4));
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "UPDATE bankapp.employees SET" 				
				+ " emp_title=?,"
				+ " emp_level=?,"
				+ " emp_salary=?"
				+ " WHERE emp_id=?";
			ps = connect.prepareStatement(query);
						
			ps.setString(1, emp.getEmp_title());
			ps.setString(2, emp.getEmp_level());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setInt(4, emp.getEmp_ID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		return true;		
		
	}

	@Override
	public boolean removeEmployee(Integer id) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "DELETE FROM bankapp.employees WHERE emp_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		return true;		
		
	}

	@Override
	public List<Employee> allEmployees() {
		Statement st = null;
		ResultSet res = null;
		List<Employee> empList = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "SELECT * FROM bankapp.employees";
			st = connect.createStatement();
			res = st.executeQuery(query);
			empList = new ArrayList<Employee>();
			
			while(res.next()) {
				Employee emp = new Employee();
				emp.setEmp_ID(res.getInt(1));
				emp.setEmp_title(res.getString(2));
				emp.setEmp_level(res.getString(3));
				emp.setEmp_salary(res.getDouble(4));
				
				empList.add(emp);
			}
			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return empList;
	}

}
