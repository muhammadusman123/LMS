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
public class purchasedb {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	/**
	 * 
	 */
	public purchasedb() {
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `book1`");
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String bookid) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `book1` WHERE Book_ID='"
				+ bookid + "'");
		return rs;
	}
	public ResultSet querryupdatec(String s) throws SQLException
	{
		
		
		
		dbclass obj=new dbclass();	
		System.out.println("query started");
		ResultSet rs = obj.select("SELECT * FROM `book1` WHERE ISBN='"+s+"'");
		
		
		System.out.println("querycompleted");
		
		return rs;
		
		
		
		
	
	}
	public ResultSet querryupdateb(String bookid) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `book1` WHERE ISBN='"
				+ bookid + "'");
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
	 * @param g
	 * @param h
	 */
	public void querryupdateb(String bookid, String date, String isbn,
			String authorname, String bookname, String edition, String price,
			String category, String upc) {
		this.a = bookid;
		// frameab = frame;
		s = ("Update `book1` SET `ISBN`='" + isbn + "', `Author_Name`='"
				+ authorname + "', `Book_Title`='" + bookname
				+ "', `Edition`='" + edition + "', `Price`='" + price
				+ "' , `Purchase_Date`='" + date + "' , `Category`='"
				+ category + "' , `UPC`='" + upc + "' where `book_ID`='"
				+ bookid + "'");
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
	 * @param g
	 * @param h
	 */
	public void querygen(String date, String isbn, String authorname,
			String bookname, String edition, String price, String category,
			String upc) {
		// framea = frame;
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `book1`(`ISBN`, `Author_Name`, `Book_Title`, `Edition`, `Price`,`Purchase_Date`,`Category`,`UPC`) values ('"
				+ isbn
				+ "','"
				+ authorname
				+ "','"
				+ bookname
				+ "','"
				+ edition
				+ "','"
				+ price
				+ "','"
				+ date
				+ "','"
				+ category
				+ "','" + upc + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	/**
	 * 
	 * @param text
	 */
	public void delete(String bookid) {
		// TODO Auto-generated method stub
		String s = "DELETE FROM `book1` WHERE Book_ID='" + bookid + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
	}
}
