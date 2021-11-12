package com.revature.sadat.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.sadat.logging.BankAppLogger;
import com.revature.sadat.models.Employee;
import com.revature.sadat.models.Login;
import com.revature.sadat.utilities.ConnectionUtility;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean insertLogin(Login lg) {
		PreparedStatement ps = null;		
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.login VALUES(DEFAULT,?,?,?);";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, lg.getUserID());
			ps.setString(2, lg.getUserName());
			ps.setString(3, lg.getPassword());			
			ps.executeUpdate();			
			
		} catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		BankAppLogger.getLogger().trace("Login info for " + lg.getUserName() + ", added to datatbase.");
		return true;
	}

	
	@Override
	public Login selectByUsername(String username, String password) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Login log = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.login WHERE username=? AND psswd=?";
			ps = connect.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			res = ps.executeQuery();
			
			while(res.next()) {
				log = new Login();				
				log.setLoginID(res.getInt(1));
				log.setUserID(res.getInt(2));
				log.setUserName(res.getString(3));
				log.setPassword(res.getString(4));
			}			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}	
		
		BankAppLogger.getLogger().trace("Login info for "+ log.getUserName() + ", retrieved from datatbase.");
		return log;
	}
	
	
	@Override
	public Login selectByLoginID(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		Login log = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.login WHERE login_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);			
			res = ps.executeQuery();
			
			while(res.next()) {
				log = new Login();				
				log.setLoginID(res.getInt(1));
				log.setUserID(res.getInt(2));
				log.setUserName(res.getString(3));
				log.setPassword(res.getString(4));
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}	
		
		BankAppLogger.getLogger().trace("Login info for "+ log.getUserName() + ", retrieved from datatbase.");
		return log;
	}

	
	@Override
	public boolean updateLogin(Login lg) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.login SET" 				
				+ " user_id=?,"
				+ " username=?,"
				+ " psswd=?"
				+ " WHERE login_id=?";
			ps = connect.prepareStatement(query);
						
			ps.setInt(1, lg.getUserID());
			ps.setString(2, lg.getUserName());
			ps.setString(3, lg.getPassword());
			ps.setInt(4, lg.getLoginID());
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}		
		return true;		
	}

	
	@Override
	public boolean removeLogin(Integer id) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "DELETE FROM bankapp.login WHERE login_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();			
		}
		catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}		
		
		BankAppLogger.getLogger().trace("Login info removed from datatbase.");
		return true;
	}

	
	@Override
	public List<Login> allLogins() {
		Statement st = null;
		ResultSet res = null;
		List<Login> logins = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.login";
			st = connect.createStatement();
			res = st.executeQuery(query);
			logins = new ArrayList<Login>();
			
			while(res.next()) {
				Login lg = new Login();
				lg.setLoginID(res.getInt(1));
				lg.setUserID(res.getInt(2));
				lg.setUserName(res.getString(3));
				lg.setPassword(res.getString(4));				
				logins.add(lg);
			}			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}	
		
		BankAppLogger.getLogger().trace("All Login info retrieved from datatbase.");
		return logins;
	}

}
