package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class bookinventory {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	/**
	 * 
	 */
	public bookinventory() {
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `bookinventory`");
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String upc) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `bookinventory` WHERE UPC='"
				+ upc + "'");
		return rs;
	}
	/**
	 * 
	 * @param am
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 */
	public void querryupdateb(String upc, int total, int issued, int returned,
			int remaining, int discarded) {
		this.a = upc;
		// frameab = frame;
		s = ("Update `bookinventory` SET `Total`='" + total + "', `Issued`='"
				+ issued + "', `Returned`='" + returned + "', `Remaining`='"
				+ remaining + "' ,`discarded`='" + discarded + "'where `UPC`='"
				+ upc + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 */
	public void querygen(String upc, int total, int issued, int returned,
			int remaining, int discarded) {
		// framea = frame;
		System.out.println("bossssssssssssssssssssssssssss");
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `bookinventory`(`Total`, `Issued`, `Returned`, `Remaining`, `discarded`,`UPC`) values ('"
				+ total
				+ "','"
				+ issued
				+ "','"
				+ returned
				+ "','"
				+ remaining
				+ "','" + discarded + "','" + upc + "')";
		dbclass dbclassobj = new dbclass();
		System.out.println("bossssssssssssssssssssssssssss2");
		// in/t a = Integer.parseInt(framea.textField_1.getTex
		dbclassobj.insert(s);
	}
}
