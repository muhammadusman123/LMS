package algo;
import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import database.dbclass;
import database.purchasedb;
import database.purchasedb;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class purchasealgo {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	public static int founder = 0;
	private String labelofbook;
	public purchasealgo() {
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
	// @Test
	public void tester(String s) {
		// assertEquals("10 x 0 must be 0", "", s);
	}
	public void set(BookPurchaseUpdate obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed purchase id");
		ResultSet rs;
		algo.purchasealgo alg = new algo.purchasealgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField.setText(rs.getString("ISBN"));
			obj.textField_1.setText(rs.getString("Author_Name"));
			obj.textField_2.setText(rs.getString("Book_Title"));
			obj.textField_4.setText(rs.getString("Edition"));
			obj.textField_3.setText(rs.getString("Price"));
			obj.textField_5.setText(rs.getString("Purchase_Date"));
			obj.comboBox.setSelectedItem(rs.getString("Category"));
			obj.textField_7.setText(rs.getString("UPC"));
		}
	}
	/**
	 * 
	 * @return
	 */


	public ResultSet queryrep() {
		purchasedb obj = new purchasedb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String bookid) throws SQLException {
		verification obj1 = new verification();
		if (obj1.ispurchaseid(bookid)) {
			purchasedb obj = new purchasedb();
			ResultSet rs = obj.querryupdatea(bookid);
			founder = 1;
			return rs;
		} else {
			Display obj3 = new Display("Record not Found");
			obj3.setVisible(true);
			return null;
		}
	}
	public ResultSet querryupdatec(String s) throws SQLException
	{
		
		
		
		purchasedb budget=new purchasedb();
		ResultSet rs =budget.querryupdatec(s);
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
	 * @param g
	 * @param h
	 */
	public void querryupdateb(String bookid, String date, String isbn,
			String authorname, String bookname, String edition, String price,
			String category, String upc) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(date)) {
			Display obj = new Display("Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(isbn)) {
			Display obj = new Display("ISBN not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(authorname)) {
			Display obj = new Display("Author Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(bookname)) {
			Display obj = new Display("Book Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(edition)) {
			Display obj = new Display("Edition not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(price)) {
			Display obj = new Display("Price not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(category)) {
			Display obj = new Display("Category not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else {
			founder = 1;
			Display disp = new Display("Record has been Successfully Inserted");
			disp.setVisible(true);
			purchasedb obj = new purchasedb();
			obj.querryupdateb(bookid, date, isbn, authorname, bookname,
					edition, price, category, upc);
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
	 * @param g
	 * @param h
	 * @throws SQLException
	 */
		public void querygen(String date, String isbn, String authorname,
			String bookname, String edition, String price, String category,
			String upc) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(date)) {
			Display obj = new Display("Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(isbn)) {
			Display obj = new Display("ISBN not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(authorname)) {
			Display obj = new Display("Author Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(bookname)) {
			Display obj = new Display("Book Name not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(edition)) {
			Display obj = new Display("Edition not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(price)) {
			Display obj = new Display("Price not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(category)) {
			Display obj = new Display("Category not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else {
			// founder = 1;
			labelalgo obj = new labelalgo();
			int counter = obj.calculatelabel(category);
			labelofbook = category + counter;
			Display obj2 = new Display(
					"Do you want to Print a Label for this new Book !!!");
			obj2.setVisible(true);
			int counter1 = 0;
			int counterchecker = 0;
			purchasealgo obj1 = new purchasealgo();
			ResultSet rs = obj1.queryrep();
			while (rs.next()) {
				counter1++;
			}
			System.out.println(counter1);
			purchasedb dbclassobj = new purchasedb();
			dbclassobj.querygen(date, isbn, authorname, bookname, edition,
					price, category, upc);
			rs = obj1.queryrep();
			while (rs.next()) {
				counterchecker++;
				if (counter1 + 1 == counterchecker) {
					Display disp = new Display(
							"Record has been Successfully Inserted");
					disp.setVisible(true);
				}
			}
			int found = 0;
			System.out.println("Usman you are here");
			found = 0;
			bookinventoryalgo obj3 = new bookinventoryalgo();
			ResultSet abc = obj3.queryrep();
			while (abc.next()) {
				if (abc.getString("UPC").equals(upc)) {
					obj3.querryupdateb(upc, abc.getInt("Total") + 1,
							abc.getInt("Issued"), abc.getInt("Returned"),
							abc.getInt("Remaining") + 1,
							abc.getInt("discarded"));
					found = 1;
				}
			}
			if (found == 0) {
				System.out.println("not found");
				obj3.querygen(upc, 1, 0, 0, 1, 0);
				found = 1;
			}
		}
	}
	/**
	 * 
	 * @param text
	 * @throws SQLException
	 */
	public void delete(String text) throws SQLException {
		// TODO Auto-generated method stub
		textvalidation valobj = new textvalidation();
		if (valobj.fun(text)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			if (!obj.ispurchaseid(text)) {
				Display obj2 = new Display("Purchase ID Not Found");
				obj2.setVisible(true);
			} else {
				String id = text;
				founder = 1;
				purchasedb obj1 = new purchasedb();
				bookinventoryalgo obj21 = new bookinventoryalgo();
				// ResultSet usman = obj1.querryupdatea(text);
				String checker = "";
				ResultSet usman = obj1.querryupdatea(text);
				while (usman.next()) {
					checker = usman.getString("UPC");
				}
				obj1.delete(text);
				ResultSet abc = obj21.queryrep();
				while (abc.next()) {
					System.out.println("Below are details");
					System.out.println(checker);
					System.out.println(abc.getString("UPC"));
					if (abc.getString("UPC").equals(checker))
						obj21.querryupdateb(checker, abc.getInt("Total") - 1,
								abc.getInt("Issued"), abc.getInt("Returned"),
								abc.getInt("Remaining") - 1,
								abc.getInt("discarded"));
				}
				int counter1 = 0;
				int counterchecker = 0;
				purchasealgo obj11 = new purchasealgo();
				ResultSet rs = obj11.queryrep();
				while (rs.next()) {
					counter1++;
				}
				System.out.println(counter1);
				obj11.delete(text);
				rs = obj11.queryrep();
				while (rs.next()) {
					counter1++;
				}
				if (counter1 == counterchecker + 1) {
					Display disp = new Display(
							"Record has been Successfully Deleted");
					disp.setVisible(true);
				}
			}
		}
	}
}
