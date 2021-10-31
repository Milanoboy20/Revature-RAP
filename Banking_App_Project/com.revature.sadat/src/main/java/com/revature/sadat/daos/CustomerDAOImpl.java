package com.revature.sadat.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.models.Account;
import com.revature.sadat.models.Customer;
import com.revature.sadat.models.Employee;
import com.revature.sadat.utilities.ConnectionUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean createAccount(Customer cus, Double startBalance, String accType) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "INSERT INTO bankapp.accounts VALUES(?, ?, ?);";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, cus.getCus_ID());			
			ps.setString(2, accType);
			ps.setDouble(3, startBalance);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}
//		Account acc = new Account(startBalance, accType);
		
		
		return true;
	}

	@Override
	public boolean deposit(Customer cus, String accType, Double amount) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "UPDATE bankapp.accounts SET "				
				+ "cus_ID=?, "
				+ "startBalance=startBalance + ? "
				+ "WHERE accType=?";
			
			ps = connect.prepareStatement(query);
			ps.setString(3, accType);
			ps.setDouble(2, amount);
			ps.setInt(1, cus.getCus_ID());
						
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean withdraw(Customer cus, String accType, Double amount) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "UPDATE bankapp.accounts SET "				
				+ "cus_ID=?, "
				+ "startBalance=startBalance - ? "
				+ "WHERE accType=?";
			
			ps = connect.prepareStatement(query);
			ps.setString(3, accType);
			ps.setDouble(2, amount);
			ps.setInt(1, cus.getCus_ID());
						
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void send(Customer cus1, Customer cus2, Double amount, String accType) {
		Double sendAmount;
//		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			withdraw(cus1, "Checking", amount);
			deposit(cus2, accType, amount);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
	}

	@Override
	public Account getAccount(Customer cus, String accType) {
		Account acc = null;
		for(int i = 0; i < allAccounts(cus.getCus_ID()).size(); i++) {
			if(allAccounts(cus.getCus_ID()).get(i).getAccType().equalsIgnoreCase(accType))
				acc = allAccounts(cus.getCus_ID()).get(i);
		}
		
		return acc;
	}

	@Override
	public List<Account> allAccounts(Integer id) {
		PreparedStatement st = null;
		ResultSet res = null;
		List<Account> acc = null;
		
		try(Connection connect = ConnectionUtility.getConnection("samad", "milan")){
			String query = "SELECT * FROM bankapp.accounts WHERE cus_ID=?";
			st = connect.prepareStatement(query);
			st.setInt(1, id);
//			st.executeUpdate();
			
			res = st.executeQuery();
			acc = new ArrayList<Account>();
			
			while(res.next()) {
				Account ac = new Account();
				ac.setAccType(res.getString(2));
				ac.setStartBalance(res.getDouble(3));
				
				acc.add(ac);
			}
			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return acc;
		
	}

	@Override
	public boolean deleteAccount(Account acc, Customer cus, Double balance) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection("samad", "milan")){
			String query = "DELETE FROM bankapp.accounts WHERE cus_ID=? AND accType=? AND startBalance=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, cus.getCus_ID());
			ps.setString(2, acc.getAccType());
			ps.setDouble(3, balance);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
