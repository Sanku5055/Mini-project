package com.velocity.ajay.online.shopping.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommanMethodJDBC {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Sanket@5055");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
