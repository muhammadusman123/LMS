package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.issuance.issuanceinsert;
import gui.issuance.issuanceupdate1;
import gui.issuance.issuanceupdate2;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class issuancedb {
	String a;
	String s;
	issuanceinsert framea;
	issuanceupdate2 frameab;
	/**
	 * 
	 */
	public issuancedb() {
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `issuance`");
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String issuanceid) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `issuance` WHERE issuanceid='"
				+ issuanceid + "'");
		return rs;
	}
	/**
	 * 
	 * @param am
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public void querryupdateb(String issuanceid, String studentid,
			String issuedate, String returndate, String upc) {
		// frameab = frame;
		// this.a = am;
		s = ("Update `issuance` SET `studentid`='" + studentid + "', `UPC`='"
				+ upc + "', `issuedate`='" + issuedate + "', `returndate`='"
				+ returndate + "' where `issuanceid`='" + issuanceid + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public void querygen(String studentid, String issuedate, String returndate,
			String upc) {
		// framea = frame;
		// int a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `issuance`(`studentid`, `UPC`, `issuedate`, `returndate`) values ('"
				+ studentid
				+ "','"
				+ upc
				+ "','"
				+ issuedate
				+ "','"
				+ returndate + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param text
	 */
	public void delete(String issuanceid) {
		String s = "DELETE FROM `issuance` WHERE issuanceid='" + issuanceid
				+ "'";
		dbclass obj = new dbclass();
		obj.insert(s);
		// TODO Auto-generated method stub
	}
}
