package algo;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.student.studentupdate1;
import gui.student.studentupdate2;
import database.dbclass;
import database.studentdb;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentalgo {
	String a;
	String s;
	public static int founder = 0;
	/**
	 * 
	 */
	public studentalgo() {
	}
	/**
	 * 
	 * @param loc
	 * @return
	 */
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	/**
	 * 
	 * @param obj
	 * @param id
	 * @throws SQLException
	 */
	public void set(studentupdate2 obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed student id");
		ResultSet rs;
		algo.studentalgo alg = new algo.studentalgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			System.out.println("Usman 1");
			obj.textField.setText(rs.getString("name"));
			obj.textField_1.setText(rs.getString("emailaddress"));
			obj.textField_2.setText(rs.getString("dob"));
			obj.comboBox.setSelectedItem(rs.getString("gender"));
			obj.textField_4.setText(rs.getString("phone"));
			obj.textField_5.setText(rs.getString("date"));
		}
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		studentdb obj = new studentdb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String id) throws SQLException {
		ResultSet rs = null;
		textvalidation valobj = new textvalidation();
		if (valobj.fun(id)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			String id1 = id;
			verification obj2 = new verification();
			if (obj2.isstudentuni(id1)) {
				// set(obj, s);
				studentdb obj21 = new studentdb();
				rs = obj21.querryupdatea(id1);
				founder = 1;
			} else {
				Display obj3 = new Display("Student not Found");
				obj3.setVisible(true);
			}
		}
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public void querryupdateb(String id, String date, String name,
			String email, String phone, String gender, String dob) {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(name)) {
			Display obj = new Display("Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(email)) {
			Display obj = new Display("Email Address not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(dob)) {
			Display obj = new Display("Date of Birth not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(gender)) {
			Display obj = new Display("Gender not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(phone)) {
			Display obj = new Display("Phone not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(date)) {
			Display obj = new Display("Date of Joining not Entered");
			obj.setVisible(true);
		} else {
			Display disp = new Display("Record has been Successfully Updated");
			disp.setVisible(true);
			studentdb obj = new studentdb();
			obj.querryupdateb(id, date, name, email, phone, gender, dob);
			founder = 1;
		}
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 * @throws SQLException
	 */
	public void querygen(String date, String name, String email, String phone,
			String gender, String dob) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(name)) {
			Display obj = new Display("Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(email)) {
			Display obj = new Display("Email Address not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(dob)) {
			Display obj = new Display("Date of Birth not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(gender)) {
			Display obj = new Display("Gender not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(phone)) {
			Display obj = new Display("Phone not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(date)) {
			Display obj = new Display("Date of Joining not Entered");
			obj.setVisible(true);
		} else {
			int counter = 0;
			int counterchecker = 0;
			studentalgo obj = new studentalgo();
			ResultSet rs = obj.queryrep();
			while (rs.next()) {
				counter++;
			}
			// dispose();
			studentdb dbclassobj = new studentdb();
			dbclassobj.querygen(date, name, email, phone, gender, dob);
			founder = 1;
			rs = obj.queryrep();
			while (rs.next()) {
				counterchecker++;
			}
			if (counter + 1 == counterchecker) {
				Display disp = new Display(
						"Record has been Successfully Inserted");
				disp.setVisible(true);
			}
		}
	}
	/**
	 * 
	 * @param text
	 * @throws SQLException
	 */
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		textvalidation valobj = new textvalidation();
		verification obj22 = new verification();
		if (valobj.fun(id)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else if (!obj22.isstudentuni(id)) {
			Display obj = new Display("ID Not FOund");
			obj.setVisible(true);
		} else {
			String id1 = id;
			int counter = 0;
			int counterchecker = 0;
			studentalgo obj = new studentalgo();
			ResultSet rs = obj.queryrep();
			while (rs.next()) {
				counter++;
			}
			studentdb obj1 = new studentdb();
			ResultSet usman = obj1.querryupdatea(id);
			rs = obj1.queryrep();
			while (rs.next()) {
				counterchecker++;
			}
			if (counterchecker + 1 == counter) {
				Display disp = new Display(
						"Record has been Successfully Deleted");
				disp.setVisible(true);
			}
			obj1.delete(id);
			founder = 1;
		}
	}
}
