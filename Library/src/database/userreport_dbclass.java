package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import database.dbclass;

public class userreport_dbclass {

	public void Insert(String st_name,int rollno,String section,String membership_date)
	
	{
		
		
		 String insert_query;
		  insert_query="INSERT INTO `student_database`(`Student_name`,`Roll_No`,`Section`,`Membership_date`) VALUES('"+st_name+"','"+rollno+"','"+section+"','"+membership_date+"')";
		dbclass obj=new dbclass();
		obj.insert(insert_query);
		
		
	}

	public void Update(int st_id, String st_name, int rollno, String section,
			String membership_date) {
		String d1="22",d2="23";
		String update_query;
		update_query = "UPDATE `student_database` SET `Student_name`= '"
				+ st_name + "' ,`Roll_No`='" + rollno + "',`Section`='" + section
				+ "',`Membership_date`='"+membership_date+"' WHERE `Student_id`='" + st_id
				+ "'";
		dbclass obj = new dbclass();
		obj.insert(update_query);
	}

	public ResultSet Report() throws SQLException {
		String report_query = "SELECT * FROM `student_database`";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(report_query);
		// JTable table = new JTable(buildTableModel(rs));
		// JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return rs;
	}
	
	public ResultSet Report2() throws SQLException {
		String report_query = "SELECT * FROM `student`";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(report_query);
		// JTable table = new JTable(buildTableModel(rs));
		// JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return rs;
	}

	public ResultSet update_field(int id) throws SQLException {
		String query = "SELECT * FROM `student_database` WHERE Student_id='"
				+ id + "'";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(query);
		// JTable table = new JTable(buildTableModel(rs));
		// JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return rs;
	}
	
	 public void Delete (int id, String name)
	   {
		  String query="DELETE FROM `student_database` WHERE Student_id='"+ id +"'";
		  dbclass obj = new dbclass();
		  obj.insert(query);
	   }

}
