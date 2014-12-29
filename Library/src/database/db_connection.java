package database;

import java.sql.*;
//db_connection db=new db_connection();
public class db_connection {
	Connection conn = null;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/lms";
	private static Connection con;
	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public Connection getConnection() {
		

		try {
		
			Class.forName("com.mysql.jdbc.Driver");

		
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connecting to database...");
		} catch (Exception e) {
		}
		return conn;
	}
	public ResultSet select(String query) {
		ResultSet rs = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Connecting to database...");
		} catch (Exception e) {

		}
		return rs;
	}

	public boolean execute(String query) {
		System.out.println("1234");
		Statement stmt = null;
	conn = getConnection();
		try {
			stmt = conn.createStatement();
			return stmt.execute(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
}
	


