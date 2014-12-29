package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentdb {
	String a;
	String s;
	/**
	 * 
	 */
	public studentdb() {
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `student`");
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String id) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `student` WHERE studentid='"
				+ id + "'");
		return rs;
	}
	/**
	 * 
	 * @param am
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public void querryupdateb(String id, String date, String name,
			String email, String phone, String gender, String dob) {
		// this.a = am;
		// frameab = frame;
		s = ("Update `student` SET `name`='" + name + "', `emailaddress`='"
				+ email + "', `dob`='" + dob + "', `gender`='" + gender
				+ "', `phone`='" + phone + "' , `date`='" + date
				+ "' where `studentid`='" + id + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public void querygen(String date, String name, String email, String phone,
			String gender, String dob) {
		// framea = frame;
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `student`(`name`, `emailaddress`, `dob`, `gender`, `phone`,`date`) values ('"
				+ name
				+ "','"
				+ email
				+ "','"
				+ dob
				+ "','"
				+ gender
				+ "','"
				+ phone + "','" + date + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param text
	 */
	public void delete(String text) {
		// TODO Auto-generated method stub
		String s = "DELETE FROM `student` WHERE studentid='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
	}
}
