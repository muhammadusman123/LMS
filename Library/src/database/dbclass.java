package database;
import gui.Authentication.AutoCompleteDBLink;
import gui.Authentication.AutoTextComplete;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
public class dbclass {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "";
	private static Connection con;
	private static String dbName = "lms";
	public String s;
	public static Connection getConnection() {
		url += dbName;
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}
	public ResultSet select(String query) {
		ResultSet rs = null;
		System.out.println("good db starts");
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("done db");
		} catch (Exception e) {
		}
		return rs;
	}
	public void fun1(JTextField textField, String s) {
		con = getConnection();
		AutoTextComplete book = new AutoTextComplete(textField);
		new AutoCompleteDBLink(book, s, con);
	}
	public void insert(String s) {
		con = getConnection();
		System.out.println("db started");
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(s);
			preparedStmt.execute();
			System.out.println("inserted");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("done");
	}
	public void delete(String text) {
		con = getConnection();
		System.out.println("db started");
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(s);
			preparedStmt.execute();
			System.out.println("inserted");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("done");// TODO Auto-generated method stub
	}
}