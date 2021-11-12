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
import com.revature.sadat.models.SystemAdmin;
import com.revature.sadat.utilities.ConnectionUtility;

public class SysAdminDAOImpl implements SystemAdminDAO {

	@Override
	public boolean insertAdmin(SystemAdmin adm) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection()){
			String query = "INSERT INTO bankapp.sysAdmin VALUES(?,?,?);";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, adm.getAdmin_ID());
			ps.setString(2, adm.getAdmin_level());
			ps.setDouble(3, adm.getAdmin_salary());
			
			ps.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		BankAppLogger.getLogger().trace("System admin info added to datatbase.");
		return true;
	}
	
	

	@Override
	public SystemAdmin selectByID(Integer id) {
		PreparedStatement ps = null;
		ResultSet res = null;
		SystemAdmin adm = null;
		
		try (Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.sysAdmin WHERE admin_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			res = ps.executeQuery();
			
			while(res.next()) {
				adm = new SystemAdmin();
				adm.setAdmin_ID(res.getInt(1));
				adm.setAdmin_level(res.getString(2));
				adm.setAdmin_salary(res.getDouble(3));
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		BankAppLogger.getLogger().trace("Admin info retrieved from datatbase.");
		return adm;
	}

	@Override
	public boolean updateAdmin(SystemAdmin adm) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "UPDATE bankapp.sysAdmin SET" 				
				+ " admin_level=?,"				
				+ " admin_salary=?"
				+ " WHERE admin_id=?";
			ps = connect.prepareStatement(query);
						
			ps.setString(1, adm.getAdmin_level());			
			ps.setDouble(2, adm.getAdmin_salary());
			ps.setInt(3, adm.getAdmin_ID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		return true;		
	}
	

	@Override
	public boolean removeAdmin(Integer id) {
		PreparedStatement ps = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "DELETE FROM bankapp.sysAdmin WHERE admin_id=?";
			ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
			return false;
		}
		
		BankAppLogger.getLogger().trace("Admin removed from datatbase.");
		return true;
	}

	@Override
	public List<SystemAdmin> allAdmins() {
		Statement st = null;
		ResultSet res = null;
		List<SystemAdmin> adminList = null;
		
		try(Connection connect = ConnectionUtility.getConnection()){
			String query = "SELECT * FROM bankapp.sysAdmin";
			st = connect.createStatement();
			res = st.executeQuery(query);
			adminList = new ArrayList<SystemAdmin>();
			
			while(res.next()) {
				SystemAdmin adm = new SystemAdmin();
				adm.setAdmin_ID(res.getInt(1));
				adm.setAdmin_level(res.getString(2));				
				adm.setAdmin_salary(res.getDouble(3));
				
				adminList.add(adm);
			}
			
			
		} catch (SQLException e){
			System.out.println("Connection Unsuccessful!");
			e.printStackTrace();
		}
		
		BankAppLogger.getLogger().trace("All admins retrieved from datatbase.");
		return adminList;
	}

}
