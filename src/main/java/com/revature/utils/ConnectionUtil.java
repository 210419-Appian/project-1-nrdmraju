package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		//We need to register our driver. this process makes the application aware of what particular Driver class we are using.
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String url = "jdbc:postgresql://neil-appian-210419.cudbss8c7iut.us-east-2.rds.amazonaws.com/postgres";
		String username = "postgres"; //you can use environment variables to hide the raw values to protect this info.
		String password = "password1"; //System.getenv("KeyName")
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void main(String[] args) {
		/*
		 * Finally blocks are so commonly used to close resources (open connections outside of Java)
		 * there is a short to creating a finally block that does that. It is a "try with resources block"
		 * that declares the resource to open and then close the try declaration.
		 */
		
		try(Connection conn=ConnectionUtil.getConnection()){
			
			System.out.println("Connection succesful.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
