package com.revature.sadat.utilities;

import java.sql.*;

public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException {
		
		String url      = "jdbc:postgresql://localhost:5432/postgres";
		String user     = "samad";
		String password = "milan";
		return DriverManager.getConnection(url, user, password);
		
	}

}
