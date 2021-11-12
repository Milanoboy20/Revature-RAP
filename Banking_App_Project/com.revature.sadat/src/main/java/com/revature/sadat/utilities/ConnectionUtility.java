package com.revature.sadat.utilities;

import java.sql.*;

import com.revature.sadat.logging.BankAppLogger;

public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException {
		
		String url      = "jdbc:postgresql://localhost:5432/postgres";
		String user     = "samad";
		String password = "milan";
		
		BankAppLogger.getLogger().trace("Connection to datatbase established.");
		
		return DriverManager.getConnection(url, user, password);
		
	}

}
