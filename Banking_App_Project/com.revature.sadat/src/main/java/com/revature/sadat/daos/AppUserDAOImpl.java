package com.revature.sadat.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.models.AppUser;
import com.revature.sadat.models.Employee;
import com.revature.sadat.utilities.ConnectionUtility;

public class AppUserDAOImpl implements AppUserDAO{

	@Override
	public boolean insertAppUser(AppUser user) {
		PreparedStatement ps = null;
		
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.appUsers VALUES(DEFAULT, ?, ?, ?, ?, ?);";
			ps = con.prepareStatement(query);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getTitle());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());			
			
			ps.executeUpdate();			
			
		} catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public AppUser selectByID(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		AppUser user = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.appUsers WHERE user_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			res = ps.executeQuery();
			
			while(res.next()) {
				user = new AppUser();
				user.setUser_ID(res.getInt(1));
				user.setName(res.getString(2));
				user.setTitle(res.getString(3));
				user.setAddress(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhone(res.getString(6));
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean updateAppUser(AppUser user) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.appUsers SET" 									
					+ " user_name=?,"
					+ " user_title=?,"
					+ " user_address=?"
					+ " user_email=?,"
					+ " user_phone=?,"
					+ " WHERE emp_id=?";
			ps = connect.prepareStatement(query);
						
			ps.setString(1, user.getName());
			ps.setString(2, user.getTitle());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(4, user.getUser_ID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		return true;	
	}

	@Override
	public boolean removeAppUser(Integer id) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "DELETE FROM bankapp.appUsers WHERE user_ID=?";
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
	public List<AppUser> allAppUsers() {
		Statement st = null;
		ResultSet res = null;
		List<AppUser> userList = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.appUsers";
			st = connect.createStatement();
			res = st.executeQuery(query);
			userList = new ArrayList<AppUser>();
			
			while(res.next()) {
				AppUser user = new AppUser();
				user.setUser_ID(res.getInt(1));
				user.setName(res.getString(2));
				user.setTitle(res.getString(3));
				user.setAddress(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhone(res.getString(6));
				
				userList.add(user);
			}
			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		return userList;
	}

}
