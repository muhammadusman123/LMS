package testcases;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import database.dbclass;
import database.resrvation_db;
public class reservationalgo {
	public void Insert(String st_name, String book_name, int book_id,
			String Date) {
		resrvation_db obj = new resrvation_db();
		obj.Insert(st_name, book_name, book_id, Date);
	}
	public void Update(int st_id, String st_name, String book_name,
			int book_id, String Date) {
		resrvation_db obj = new resrvation_db();
		obj.Update(st_id, st_name, book_name, book_id, Date);
	}
	public ResultSet Report() throws SQLException {
		resrvation_db obj = new resrvation_db();
		ResultSet rs = obj.Report();
		return rs;
	}
	public ResultSet update_field(int id) throws SQLException {
		resrvation_db obj = new resrvation_db();
		ResultSet rs = obj.update_field(id);
		return rs;
	}
}