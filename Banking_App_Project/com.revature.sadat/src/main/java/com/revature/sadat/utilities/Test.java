package com.revature.sadat.utilities;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		try(Connection connect = ConnectionUtility.getConnection()) {			
			System.out.println("Connection successful!");
			
		} catch (SQLException e) {
			System.out.println("Error! Connection unsuccessful");
			e.printStackTrace();
		}

	}

}
