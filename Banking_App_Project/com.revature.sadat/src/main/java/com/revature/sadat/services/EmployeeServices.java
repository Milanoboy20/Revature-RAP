package com.revature.sadat.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.models.Customer;
import com.revature.sadat.models.EmpActions;
import com.revature.sadat.models.Login;
import com.revature.sadat.models.NewEmployee;
import com.revature.sadat.utilities.ConnectionUtility;

public class EmployeeServices {
	
	public boolean newCus(String stID, Integer cus_SS, String username, String password) {
		PreparedStatement ps = null;
		String act = "New Customer Account";
		
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.newAccounts VALUES(DEFAULT,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(query);
			
			Date dt = new Date(System.currentTimeMillis());
			ps.setString(1, act);
			ps.setString(2, stID);
			ps.setInt(3, cus_SS);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setString(6, "Pending");
			ps.setDate(7, dt);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;		
	}
	
	
	public boolean newEmp(String title, String level, Double salary, String username, String password) {
		PreparedStatement ps = null;
		String act = "New Employee Account";
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.newEmp VALUES(DEFAULT,?,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(query);
			
			Date dt = new Date(System.currentTimeMillis());
			ps.setString(1, act);
			ps.setString(2, title);
			ps.setString(3, level);
			ps.setDouble(4, salary);
			ps.setString(5, username);
			ps.setString(6, password);
			ps.setString(7, "Pending");
			ps.setDate(8, dt);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;		
	}
	
	
	
	public boolean createCusAccount(Integer cusID, String accType, Double startBalance) {
		PreparedStatement ps = null;				
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.accounts VALUES(DEFAULT,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, cusID);
			ps.setString(2, accType);
			ps.setDouble(3, startBalance);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	public Login cusLogin(Integer actNum) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Login lg = null;		
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.newAccounts WHERE actnum=?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, actNum);			
			res = ps.executeQuery();			
			
			while(res.next()) {
				lg = new Login();
				lg.setUserName(res.getString(5));
				lg.setPassword(res.getString(6));				
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();			
		}			
		return lg;
	}
	
	public Customer getCustomer(Integer actNum) {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet res = null;
		ResultSet res2 = null;
		Customer cus = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.newAccounts WHERE actnum=?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, actNum);			
			res = ps.executeQuery();
			String user = "";
			String pass = "";
			
			while(res.next()) {
				cus = new Customer();
				cus.setSocialSec(res.getInt(4));
				cus.setStateID(res.getString(3));
				user += res.getString(5);
				pass += res.getString(6);
			}
			
			String query2 = "SELECT * FROM bankapp.login WHERE username=? AND psswd=?";
			
			ps2 = con.prepareStatement(query2);
			ps2.setString(1, user);
			ps2.setString(2, pass);			
			
			res2 = ps2.executeQuery();
			while(res2.next()) {
				cus.setCus_ID(res2.getInt(1));
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error!");
		}		
		return cus;	
	}
	
	
	public boolean updateNewCusAccount(Integer actNum, String act) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.newAccounts SET "
					+ "status=? "
					+ "WHERE actNum=? ";
			ps = con.prepareStatement(query);
			ps.setString(1, act);
			ps.setInt(2, actNum);
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean updateNewEmpAccount(Integer actNum, String act) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.newEmp SET "
					+ "status=? "
					+ "WHERE actNum=? ";
			ps = con.prepareStatement(query);
			ps.setString(1, act);
			ps.setInt(2, actNum);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;		
	}
	
	
	
	public List<EmpActions> allNewCusAccounts(){
		PreparedStatement ps = null;
		ResultSet res = null;
		List<EmpActions> acts = new ArrayList<EmpActions>();
		EmpActions ac = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.newAccounts";
			ps = con.prepareStatement(query);
			res = ps.executeQuery();
			
			while(res.next()) {
				ac = new EmpActions();
				ac.setActNum(res.getInt(1));
				ac.setActivity(res.getString(2));
				ac.setStateID(res.getString(3));
				ac.setCus_SS(res.getInt(4));
				ac.setUsername(res.getString(5));
				ac.setPassword(res.getString(6));
				ac.setStatus(res.getString(7));
				ac.setDt(res.getDate(8));
				acts.add(ac);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();					
		}		
		return acts;		
	}
	
	
	public List<NewEmployee> allNewEmpAccounts(){
		PreparedStatement ps = null;
		ResultSet res = null;
		List<NewEmployee> emps = null;
		NewEmployee emp = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.newEmp";
			ps = con.prepareStatement(query);
			res = ps.executeQuery();
			
			while(res.next()) {
				emp = new NewEmployee();
				emp.setActNum(res.getInt(1));
				emp.setActivity(res.getString(2));
				emp.setTitle(res.getString(3));
				emp.setLevel(res.getString(4));
				emp.setSalary(res.getDouble(5));
				emp.setUsername(res.getString(6));
				emp.setPassword(res.getString(7));
				emp.setStatus(res.getString(8));
				emp.setDate(res.getDate(9));
				emps.add(emp);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();					
		}		
		return emps;		
	}

}
