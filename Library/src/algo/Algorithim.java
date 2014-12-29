package algo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import database.db_connection;
public class Algorithim {
	private static final String Default = null;
	static db_connection db;
	private Object returnValue;
	public void totalpurchase(int a) throws SQLException {
		System.out.println(a);
		db_connection db = new db_connection();
		ResultSet rsQuery;
		rsQuery = db
				.select("SELECT `Book_ID`, `ISBN`, `Author_Name`, `Book_Title`, `Edition`, `Price`, `Purchase_Date`, `count` FROM `book1` WHERE `Book_ID`='"
						+ a + "'");
		while (rsQuery.next()) {
			gui.Labeling.record c = new gui.Labeling.record();
			c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			c.setVisible(true);
			c.textField1.setText(String.valueOf(rsQuery.getInt("count")));
		}
	}
	public void total1(String dep) {
		// TODO Auto-generated method stub
		db_connection db = new db_connection();
		ResultSet rsQuery;
		// rsQuery = db.select("SELECT COUNT(`Book_ID`) FROM `book1`");
		// rsQuery=db.select("SELECT COUNT(`count`) FROM `book1`");
		rsQuery = db.select("SELECT COUNT(count) AS co FROM book1");
		try {
			rsQuery.next();
			int a = rsQuery.getInt("co");
			System.out.println(a);
			String s = Integer.toString(a);
			s = dep + s;
			gui.Labeling.record c = new gui.Labeling.record();
			c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			c.textField1.setText(s);
			c.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
