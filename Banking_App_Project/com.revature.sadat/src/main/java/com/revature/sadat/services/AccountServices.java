package com.revature.sadat.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Activity;
import com.revature.sadat.models.Customer;
import com.revature.sadat.models.Employee;
import com.revature.sadat.utilities.ConnectionUtility;

public class AccountServices {
	
	
	
	public boolean createAccount(Integer id, Double startBalance, String accType) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.accounts VALUES(DEFAULT, ?, ?, ?);";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);			
			ps.setString(2, accType);
			ps.setDouble(3, startBalance);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}		
		
		return true;
	}
	
	
	public Double balance(Integer accID) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Double balance = 0.0;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.accounts WHERE acc_ID=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, accID);
			res = ps.executeQuery();
			
			while(res.next()) {
				balance = res.getDouble(4);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
		
	}
	
	
	public boolean deleteAccount(Integer acc) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "DELETE FROM bankapp.accounts WHERE acc_ID=?;";
			ps = con.prepareStatement(query);
			ps.setInt(1, acc);			
			ps.executeUpdate();
			
		}catch(SQLException e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public boolean deposit(Integer cusID, Integer id, Double amount) {
		PreparedStatement ps = null;
		String str ="";
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.accounts SET "				
				
				+ "startBalance=startBalance + ? "
				+ "WHERE acc_ID=?";
			
			ps = connect.prepareStatement(query);			
			ps.setInt(2, id);
			ps.setDouble(1, amount);						
			ps.executeUpdate();
			
			Date dt = new Date(System.currentTimeMillis());
			str += "Deposited:   $" + amount; 
			
			String date = "INSERT INTO bankapp.activities VALUES(?, ?, ?, ?);";
			ps = connect.prepareStatement(date);
			ps.setInt(1, cusID);
			ps.setInt(2, id);
			ps.setString(3, str);
			ps.setDate(4, dt);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
					
	
	
	public boolean withdraw(Integer cusID, Integer id, Double amount) {
		PreparedStatement ps = null;
		String str = "";
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.accounts SET "				
				
				+ "startBalance=startBalance - ? "
				+ "WHERE acc_ID=?";
			
			ps = connect.prepareStatement(query);			
			ps.setInt(2, id);
			ps.setDouble(1, amount);						
			ps.executeUpdate();
			
			Date dt = new Date(System.currentTimeMillis());
			str += "Withdrawed:   $" + amount; 
			
			String date = "INSERT INTO bankapp.activities VALUES(?, ?, ?, ?);";
			ps = connect.prepareStatement(date);
			ps.setInt(1, cusID);
			ps.setInt(2, id);
			ps.setString(3, str);
			ps.setDate(4, dt);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public void send(Integer cus1_accID, Integer cus2_accID, Double amount) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String remove = "UPDATE bankapp.accounts SET "
					+ "startBalance= startBalance - ? "
					+ "WHERE acc_id=?";
			
			ps = connect.prepareStatement(remove);
			ps.setDouble(1, amount);
			ps.setInt(2, cus1_accID);
			ps.executeUpdate();
			
			String add = "UPDATE bankapp.accounts SET "
					+ "startBalance= startBalance + ? "
					+ "WHERE acc_id=?";
			
			ps = connect.prepareStatement(add);
			ps.setDouble(1, amount);
			ps.setInt(2, cus2_accID);
			ps.executeUpdate();
			
			Date dt = new Date(System.currentTimeMillis());
			String str  = "Sent:   $" + amount + "   To:  " + cus2_accID; 
			String str2 = "Recieved:   $" + amount + "   From:  " + cus1_accID;
			
			//get cus_ID sender
			String query = "SELECT * FROM bankapp.accounts WHERE acc_ID=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, cus1_accID);
			res = ps.executeQuery();
			
			//Add to activities table for customer sending
			String date = "INSERT INTO bankapp.activities VALUES(?, ?, ?, ?);";
			ps = connect.prepareStatement(date);
			
			while(res.next()) {
				ps.setInt(1, res.getInt(2));
			}
			
			ps.setInt(2, cus1_accID);
			ps.setString(3, str);
			ps.setDate(4, dt);			
			ps.executeUpdate();
			
			
			//get cus_ID receiver
			String query2 = "SELECT * FROM bankapp.accounts WHERE acc_ID=?";
			ps = connect.prepareStatement(query2);
			ps.setInt(1, cus2_accID);
			res = ps.executeQuery();
			
			//Add to activities table for customer receiving 
			String date2 = "INSERT INTO bankapp.activities VALUES(?, ?, ?, ?);";
			ps = connect.prepareStatement(date2);
			
			while(res.next()) {
				ps.setInt(1, res.getInt(2));
			}
			
			ps.setInt(2, cus2_accID);
			ps.setString(3, str2);
			ps.setDate(4, dt);			
			ps.executeUpdate();	
			
		} catch(SQLException e) {
			e.printStackTrace();			
		}	
	}
	
	
	
	public Account getAccount(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Account ac = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.accounts WHERE acc_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			res = ps.executeQuery();
			
			while(res.next()) {
				ac = new Account();
				ac.setAcc_ID(res.getInt(1));
				ac.setCus_ID(res.getInt(2));
				ac.setAccType(res.getString(3));
				ac.setStartBalance(res.getDouble(4));
			}			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}		
		return ac;
	}
	
	
	
	public List<Account> allAccounts(Integer id) {
		PreparedStatement st = null;
		ResultSet res = null;
		List<Account> acc = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.accounts WHERE cus_ID=?";
			st = connect.prepareStatement(query);
			st.setInt(1, id);
			
			res = st.executeQuery();
			acc = new ArrayList<Account>();
			
			while(res.next()) {
				Account ac = new Account();
				ac.setAcc_ID(res.getInt(1));
				ac.setCus_ID(res.getInt(2));
				ac.setAccType(res.getString(3));
				ac.setStartBalance(res.getDouble(4));				
				acc.add(ac);
			}					
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}		
		return acc;		
	}
	
	
	
	public List<Activity> actions(Integer id){
		PreparedStatement st = null;
		ResultSet res = null;
		List<Activity> act = null;
		Activity ac = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.activities WHERE cus_id=?";
			st = connect.prepareStatement(query);
			st.setInt(1, id);
			
			res = st.executeQuery();
			act = new ArrayList<Activity>();
			
			while(res.next()) {
				ac = new Activity();
				ac.setCus_id(res.getInt(1));
				ac.setAcc_id(res.getInt(2));
				ac.setAct(res.getString(3));
				ac.setDt(res.getDate(4));				
				act.add(ac);
			}		
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return act;
		
	}

}
