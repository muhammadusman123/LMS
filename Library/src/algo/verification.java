package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.issuancedb;
import database.purchasedb;
import database.resrvation_db;
import database.returndb;
import database.studentdb;
import database.userreport_dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class verification {
	/**
	 * 
	 * @param studentid
	 * @return
	 * @throws SQLException
	 */
	public boolean isstudent(String studentid) throws SQLException {
		ResultSet rs = null;
		userreport_dbclass obj = new userreport_dbclass();
		rs = obj.Report();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("Student_id").equals(studentid)) {
				found = 1;
				System.out.println(studentid);
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	public boolean isstudentuni(String studentid) throws SQLException {
		ResultSet rs = null;
		studentdb obj = new studentdb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("studentid").equals(studentid)) {
				found = 1;
				System.out.println(studentid);
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param upc
	 * @return
	 * @throws SQLException
	 */
	public boolean isbook(String upc) throws SQLException {
		ResultSet rs = null;
		purchasedb obj = new purchasedb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("UPC").equals(upc)) {
				found = 1;
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @return
	 * @throws SQLException
	 */
	public boolean isissueid(String a) throws SQLException {
		ResultSet rs = null;
		issuancedb obj = new issuancedb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("issuanceid").equals(a)) {
				found = 1;
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @return
	 * @throws SQLException
	 */
	public boolean isreturnid(String a) throws SQLException {
		ResultSet rs = null;
		returndb obj = new returndb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("returnid").equals(a)) {
				found = 1;
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @return
	 * @throws SQLException
	 */
	public boolean ispurchaseid(String a) throws SQLException {
		System.out.println("Passed id is " + a);
		ResultSet rs = null;
		purchasedb obj = new purchasedb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			if (rs.getString("Book_ID").equals(a)) {
				found = 1;
				break;
			}
		}
		System.out.println(found);
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean ismatch(String a, String b, String c) throws SQLException {
		ResultSet rs = null;
		issuancedb obj = new issuancedb();
		rs = obj.queryrep();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("issuanceid").equals(a)
					&& rs.getString("studentid").equals(b)
					&& rs.getString("UPC").equals(c)) {
				found = 1;
				break;
			}
		}
		if (found == 1)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws SQLException
	 */
	public boolean isreservedwiththisstudent(String a, String b)
			throws SQLException {
		ResultSet rs = null;
		resrvation_db obj = new resrvation_db();
		rs = obj.Report();
		int found = 0;
		while (rs.next()) {
			if (rs.getString("Book_id").equals(a)
					&& rs.getString("Student_id").equals(b)) {
				found = 1;
				break;
			}
		}
		if (found == 1) {
			obj.delete(rs.getString("reservationid"));
			return true;
		} else
			return false;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws SQLException
	 */
	public boolean isreservedwithanystudent(String a, String b)
			throws SQLException {
		ResultSet rs = null;
		resrvation_db obj = new resrvation_db();
		rs = obj.Report();
		int found = 0;
		int thisstudentreservationid = -1;
		ResultSet rs1 = null;
		resrvation_db obj1 = new resrvation_db();
		rs1 = obj1.Report();
		while (rs1.next()) {
			if (rs1.getString("Book_id").equals(a)
					&& rs1.getString("Student_id").equals(b))
				thisstudentreservationid = Integer.parseInt(rs1
						.getString("reservationid"));
			break;
		}
		System.out.println("your id is " + thisstudentreservationid);
		while (rs.next()) {
			if (rs.getString("Book_id").equals(a))
				if (Integer.parseInt(rs.getString("reservationid")) < thisstudentreservationid
						|| thisstudentreservationid == -1) {
					found = 1;
					break;
				}
		}
		if (found == 1) {
			return true;
		} else
			return false;
	}
}
