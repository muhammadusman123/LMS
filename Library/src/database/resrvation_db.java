package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import database.dbclass;
public class resrvation_db {
	public void Insert(String st_name, String book_name, int book_id,
			String Date) {
		String insert_query;
		insert_query = "INSERT INTO `reservation`(`Student_id`,`Book_name`,`Book_id`,`Reservation_Date`) VALUES('"
				+ st_name
				+ "','"
				+ book_name
				+ "','"
				+ book_id
				+ "','"
				+ Date
				+ "')";
		database.dbclass obj = new database.dbclass();
		obj.insert(insert_query);
	}
	public void Update(int st_id, String st_name, String book_name,
			int book_id, String Date) {
		String update_query;
		update_query = "UPDATE `reservation` SET `Student_id`= '" + st_name
				+ "' ,`Book_name`='" + book_name + "',`Book_id`='" + book_id
				+ "',`Reservation_Date`='" + Date + "' WHERE `Student_id`='"
				+ st_id + "'";
		dbclass obj = new dbclass();
		obj.insert(update_query);
	}
	public ResultSet Report() throws SQLException {
		String report_query = "SELECT * FROM `reservation`";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(report_query);
		return rs;
	}
	public ResultSet update_field(int id) throws SQLException {
		String query = "SELECT * FROM `reservation` WHERE Student_id='" + id
				+ "'";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(query);
		return rs;
	}
	public void delete(String text) {
		// TODO Auto-generated method stub
		String s = "DELETE FROM `reservation` WHERE Book_id='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
	}
}