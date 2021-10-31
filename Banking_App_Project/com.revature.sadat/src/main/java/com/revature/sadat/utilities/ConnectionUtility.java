package com.revature.sadat.utilities;

import java.sql.*;

public class ConnectionUtility {
	
	public static Connection getConnection(String user, String password) throws SQLException {
		
		String url      = "jdbc:postgresql://localhost:5432/postgres";
//		String user     = "employee";
//		String password = "pass";
		return DriverManager.getConnection(url, user, password);
		
	}

}
