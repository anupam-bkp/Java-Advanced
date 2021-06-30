package com.example.dbtest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection(
				"jdbc:h2:C:\\Users\\kanupam\\Desktop\\Databases\\;DB_CLOSE_DELAY=-1", 
				"admin", "admin")) {
			
			final Statement stmt = con.createStatement();
			
			String sql = "CREATE TABLE employee("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "first_name VARCHAR(50),"
					+ "last_name VARCHAR(50)"
					+ ");";
			
			boolean execute = stmt.execute(sql);
			System.out.println("Employee table created : " + execute);
			
			String sql1 = "INSERT INTO employee (first_name, last_name)"
						+ "VALUES ('Anupam', 'Kumar')";
			
			int executeUpdate = stmt.executeUpdate(sql1);
			System.out.println("Inserted Rows: " + executeUpdate);
			
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
