package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.returning.returninsert;
import gui.returning.returnupdate2;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class returndb {
	returninsert framea;
	returnupdate2 frameab;
	/**
	 * 
	 */
	public returndb() {
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `returning`");
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
		System.out.println("query started");
		ResultSet rs = obj.select("SELECT * FROM `returning` WHERE returnid='"
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
	 */
	public void querryupdateb(String returnid, String returndate,
			String issueid, String fine, String upc, String studentid) {
		// this.a = am;
		// frameab = frame;
		String s = ("Update `returning` SET `returndate`='" + returndate
				+ "', `issueid`='" + issueid + "', `finepaid`='" + fine
				+ "',`UPC` ='" + upc + "',`studentid` ='" + studentid
				+ "' where `returnid`='" + returnid + "'");
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
	 */
	public void querygen(String returndate, String issueid, String fine,
			String upc, String studentid) {
		// int a = Integer.parseInt(framea.textField_1.getText());
		String s = "INSERT INTO `returning`(`returndate`, `issueid`, `finepaid`,`UPC`,`studentid`) values ('"
				+ returndate
				+ "','"
				+ issueid
				+ "','"
				+ fine
				+ "','"
				+ upc
				+ "','" + studentid + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param text
	 */
	public void delete(String id) {
		String s = "DELETE FROM `returning` WHERE returnid='" + id + "'";
		dbclass obj = new dbclass();
		obj.insert(s); // TODO Auto-generated method stub
	}
}
