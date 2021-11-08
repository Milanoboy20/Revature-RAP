package com.revature.sadat.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.sadat.daos.AppUserDAO;
import com.revature.sadat.daos.AppUserDAOImpl;
import com.revature.sadat.daos.LoginDAO;
import com.revature.sadat.daos.LoginDAOImpl;
import com.revature.sadat.models.AppUser;
import com.revature.sadat.models.Login;
import com.revature.sadat.utilities.ConnectionUtility;

public class LoginVerification {
	
	private LoginDAO ldao = new LoginDAOImpl();
	private AppUserDAO adao = new AppUserDAOImpl();
	
	private Login log = null;
	private AppUser auser = null;
	
	public AppUser verify(String username, String password) {
		log = ldao.selectByUsername(username, password);
		
		if(log != null) {
			auser = adao.selectByID(log.getUserID());
		} else {
			System.out.println("Login Failled!");
		}
		
		return auser;
	}
	
	

}
