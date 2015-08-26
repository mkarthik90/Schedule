package com.amber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConenction {

	public Connection getConnection() {
		String url = "jdbc:mysql://db4free.net:3306/schedule1";
		String username = "schedule1";
		String password = "schedule1";
		System.out.println("Connecting database...");
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
		} catch (Exception e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}

		return connection;
	}
	
	public static void main(String arr[]){
		DAOConenction connection = new DAOConenction();
		connection.getConnection();
	}
}
