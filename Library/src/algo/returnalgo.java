package algo;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import gui.Authentication.Display;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.returning.returninsert;
import gui.returning.returnupdate2;
import database.dbclass;
import database.issuancedb;
import database.purchasedb;
import database.returndb;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class returnalgo {
	public static int founder = 0;
	returninsert framea;
	returnupdate2 frameab;

	/**
	 * 
	 * @param frame
	 */
	public returnalgo(returninsert frame) {
		framea = frame;
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
	 */
	public returnalgo() {
	}

	/**
	 * 
	 * @param obj
	 * @param id
	 * @throws SQLException
	 */
	public void set(returnupdate2 obj, String id) throws SQLException {
		String c;
		ResultSet rs;
		algo.returnalgo alg = new algo.returnalgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField_5.setText(rs.getString("returndate"));
			obj.textField.setText(rs.getString("issueid"));
			obj.textField_1.setText(rs.getString("finepaid"));
			obj.textField_2.setText(rs.getString("UPC"));
			obj.textField_3.setText(rs.getString("studentid"));
		}
	}

	/**
	 * 
	 * @param frame
	 */
	public returnalgo(returnupdate2 frame) {
		frameab = frame;
	}

	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		returndb obj = new returndb();
		ResultSet rs = obj.queryrep();
		return rs;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String returnid) throws SQLException {
		ResultSet rs = null;
		textvalidation valobj = new textvalidation();
		if (valobj.fun(returnid)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			if (!obj.isreturnid(returnid)) {
				Display obj2 = new Display("Return ID Not Found");
				obj2.setVisible(true);
			} else {
				founder = 1;
				String id = returnid;
				returndb obj11 = new returndb();
				rs = obj11.querryupdatea(returnid);
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
	 * @throws SQLException
	 */
	public void querryupdateb(String returnid, String returndate,
			String issueid, String fine, String upc, String studentid)
			throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(returndate)) {
			Display obj = new Display("Return Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(issueid)) {
			Display obj = new Display("Issue ID not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(fine)) {
			Display obj = new Display("Fine Paid not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else {
			verification obj4 = new verification();
			if (!obj4.ismatch(issueid, studentid, upc)) {
				Display obj5 = new Display(
						"Issue ID and Student ID and Book doesnot match");
				obj5.setVisible(true);
			} else {
				returndb obj = new returndb();
				obj.querryupdateb(returnid, returndate, issueid, fine, upc,
						studentid);
				Display disp = new Display(
						"Record has been Successfully Updated");
				disp.setVisible(true);
			}
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @throws SQLException
	 */
	public void querygen(String returndate, String issueid, String fine,
			String upc, String studentid) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(returndate)) {
			Display obj = new Display("Return Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(issueid)) {
			Display obj = new Display("Issue ID not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(fine)) {
			Display obj = new Display("Fine Paid not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else {
			verification obj4 = new verification();
			if (!obj4.ismatch(issueid, studentid, upc)) {
				Display obj5 = new Display(
						"Issue ID and Student ID and Book doesnot match");
				obj5.setVisible(true);
			} else {

				issuancealgo obj12 = new issuancealgo();
				java.sql.ResultSet rs123 = null;
				try {
					rs123 = obj12.querryupdatea((issueid));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (rs123.next()) {
					DateTimeFormatter formatter = DateTimeFormat.forPattern(
							"MM/dd/yyyy").withLocale(Locale.US);
					LocalDate date = formatter.parseLocalDate(rs123
							.getString("returndate"));

					System.out.println("Testing");
					System.out.println(date.getDayOfMonth());
					System.out.println(date.getMonthOfYear());
					System.out.println(date.getYear());
					DateCalculator obj1 = new DateCalculator(
							date.getMonthOfYear(), date.getDayOfMonth(),
							date.getYear());
					System.out.println(DateCalculator.fine + "aaaa");
					System.out.println(fine + "bbbbbbbb");
				}
				if (!(fine.equals("" + DateCalculator.fine + ""))) {
					Display obj = new Display(
							"Fine Paid is not Equal to FIne Calculated");
					obj.setVisible(true);
				} else {
					DateCalculator.fine = 0;

					bookinventoryalgo obj2 = new bookinventoryalgo();
					ResultSet abc = obj2.queryrep();
					int found = 0;
					while (abc.next()) {
						if (abc.getString("UPC").equals(upc)) {
							obj2.querryupdateb(upc, abc.getInt("Total"),
									abc.getInt("Issued"),
									abc.getInt("Returned") + 1,
									abc.getInt("Remaining") + 1,
									abc.getInt("discarded"));
						}
					}
					returndb dbclassobj = new returndb();

					int counter = 0;
					int counterchecker = 0;
					// returnalgo obj = new returnalgo();
					ResultSet rs = dbclassobj.queryrep();
					while (rs.next()) {
						counter++;
					}
					System.out.println(counter);
					System.out.println("hello Usman eneterin gdatatata");
					dbclassobj.querygen(returndate, issueid, fine, upc,
							studentid);
					found = 1;

					rs = dbclassobj.queryrep();
					while (rs.next()) {
						counterchecker++;
					}
					System.out.println(counterchecker);
					if (counter + 1 == counterchecker) {
						Display disp = new Display(
								"Record has been Successfully Inserted");
						disp.setVisible(true);
					}

				}
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
		if (valobj.fun(id)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			if (!obj.isreturnid(id)) {
				Display obj2 = new Display("Return ID Not Found");
				obj2.setVisible(true);
			} else {
				founder = 1;
				returndb obj1 = new returndb();
				bookinventoryalgo obj2 = new bookinventoryalgo();
				ResultSet usman = obj1.querryupdatea(id);
				String checker = "";
				while (usman.next()) {
					checker = usman.getString("UPC");
				}
				ResultSet abc = obj2.queryrep();
				while (abc.next()) {
					if (abc.getString("UPC").equals(checker))
						obj2.querryupdateb(checker, abc.getInt("Total"),
								abc.getInt("Issued"),
								abc.getInt("Returned") - 1,
								abc.getInt("Remaining") - 1,
								abc.getInt("discarded"));
				}
				int counter = 0;
				int counterchecker = 0;
				returnalgo obj11 = new returnalgo();
				ResultSet rs = obj11.queryrep();
				while (rs.next()) {
					counter++;
				}
				returndb obj112 = new returndb();
				obj112.delete(id);
				System.out.println(counter);
				rs = obj11.queryrep();
				while (rs.next()) {
					counterchecker++;
				}
				System.out.println(counterchecker);
				if (counter == counterchecker + 1) {
					Display disp = new Display(
							"Record has been Successfully Deleted");
					disp.setVisible(true);
				}
			}
		}
	}
}
