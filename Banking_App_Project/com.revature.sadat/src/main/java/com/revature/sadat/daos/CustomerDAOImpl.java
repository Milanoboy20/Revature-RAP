package com.revature.sadat.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.revature.sadat.models.Customer;
import com.revature.sadat.utilities.ConnectionUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean insertCustomer(Customer cus) {
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.customers VALUES(?,?,?);";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, cus.getCus_ID());
			ps.setString(2, cus.getStateID());
			ps.setInt(3, cus.getSocialSec());
			
			ps.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	@Override
	public Customer selectByID(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Customer cus = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.customers WHERE cus_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			res = ps.executeQuery();
			
			while(res.next()) {
				cus = new Customer();
				cus.setCus_ID(res.getInt(1));
				cus.setStateID(res.getString(2));
				cus.setSocialSec(res.getInt(3));				
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return cus;
	}

	@Override
	public boolean updateCustomer(Customer cus) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.customers SET" 				
				+ " cus_stateid=?,"
				+ " cus_ss=?"
				+ " WHERE cus_id=?";
			ps = connect.prepareStatement(query);
						
			ps.setString(1, cus.getStateID());
			ps.setInt(2, cus.getSocialSec());
			ps.setInt(3, cus.getCus_ID());			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean removeCustomer(Integer id) {
PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "DELETE FROM bankapp.customers WHERE cus_id=?";
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
	public List<Customer> allCustomers() {
		Statement st = null;
		ResultSet res = null;
		List<Customer> cusList = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.customers";
			st = connect.createStatement();
			res = st.executeQuery(query);
			cusList = new ArrayList<Customer>();
			
			while(res.next()) {
				Customer cus = new Customer();
				cus.setCus_ID(res.getInt(1));
				cus.setStateID(res.getString(2));
				cus.setSocialSec(res.getInt(3));				
				
				cusList.add(cus);
			}			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return cusList;
	}

	
	

}
