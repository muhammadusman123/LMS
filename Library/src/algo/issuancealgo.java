package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.issuance.issuanceinsert;
import gui.issuance.issuanceupdate2;
import database.dbclass;
import database.issuancedb;
import database.resrvation_db;
import database.returndb;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class issuancealgo {
	public static int founder = 0;
	/**
	 * 
	 */
	public issuancealgo() {
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
	public void set(issuanceupdate2 obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed issuance id");
		ResultSet rs;
		algo.issuancealgo alg = new algo.issuancealgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField_5.setText(rs.getString("studentid"));
			obj.textField.setText(rs.getString("UPC"));
			obj.textField_1.setText(rs.getString("issuedate"));
			obj.textField_2.setText(rs.getString("returndate"));
		}
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet queryrep() {
		issuancedb obj = new issuancedb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querryupdatea(String issuanceid) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(issuanceid)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			if (!obj.isissueid(issuanceid)) {
				Display obj2 = new Display("Issue ID Not Found");
				obj2.setVisible(true);
			} else {
				founder = 1;
				String id = issuanceid;
				issuancedb obj1 = new issuancedb();
				ResultSet rs = obj1.querryupdatea(issuanceid);
				return rs;
			}
		}
		return null;
	}
	/**
	 * 
	 * @param s
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 */
	public void querryupdateb(String issuanceid, String studentid,
			String issuedate, String returndate, String upc) {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(issuedate)) {
			Display obj = new Display("Issue Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(returndate)) {
			Display obj = new Display("Return Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(studentid)) {
			Display obj = new Display("StudentID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			try {
				if (!obj.isstudent(studentid)) {
					Display obj2 = new Display("Student ID Not Found");
					obj2.setVisible(true);
				} else {
					Display disp = new Display(
							"Record has been Successfully Updated");
					disp.setVisible(true);
					issuancedb obj11 = new issuancedb();
					obj11.querryupdateb(issuanceid, studentid, issuedate,
							returndate, upc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @throws SQLException
	 */
	public void querygen(String studentid, String issuedate, String returndate,
			String upc) throws SQLException {
		textvalidation valobj = new textvalidation();
		if (valobj.fun(upc)) {
			Display obj = new Display("UPC not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(issuedate)) {
			Display obj = new Display("Issue Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(returndate)) {
			Display obj = new Display("Return Date not Entered");
			obj.setVisible(true);
		} else if (valobj.fun(studentid)) {
			Display obj = new Display("StudentID not Entered");
			obj.setVisible(true);
		} else {
			verification var = new verification();
			if (!var.isstudent(studentid)) {
				Display obj = new Display("Student ID Doesnot Match");
				obj.setVisible(true);
			} else {
				if (var.isreservedwithanystudent(upc, studentid)) {
					Display obj = new Display("Sorry Reserved by someone else");
					obj.setVisible(true);
				} else {
					founder = 1;
					bookinventoryalgo obj2 = new bookinventoryalgo();
					ResultSet abc = obj2.queryrep();
					int found = 0;
					resrvation_db obj45 = new resrvation_db();
					obj45.delete(upc);
					while (abc.next()) {
						if (abc.getString("UPC").equals(upc)
								&& abc.getInt("Remaining") > 0) {
							obj2.querryupdateb(upc, abc.getInt("Total"),
									abc.getInt("Issued") + 1,
									abc.getInt("Returned"),
									abc.getInt("Remaining") - 1,
									abc.getInt("discarded"));
							int counter = 0;
							int counterchecker = 0;
							issuancealgo obj = new issuancealgo();
							ResultSet rs = obj.queryrep();
							while (rs.next()) {
								counter++;
							}
							issuancedb dbclassobj = new issuancedb();
							dbclassobj.querygen(studentid, issuedate,
									returndate, upc);
							rs = obj.queryrep();
							while (rs.next()) {
								counterchecker++;
							}
							found = 1;
							if (counterchecker == counter + 1) {
								Display disp = new Display(
										"Record has been Successfully Inserted");
								disp.setVisible(true);
							}
						}
					}
					if (found == 0) {
						System.out.println("not found");
						Display obj3 = new Display("Book Not Available");
						obj3.setVisible(true);
						found = 1;
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
	public void delete(String text) throws SQLException {
		// TODO Auto-generated method stub
		textvalidation valobj = new textvalidation();
		if (valobj.fun(text)) {
			Display obj = new Display("ID not Entered");
			obj.setVisible(true);
		} else {
			verification obj = new verification();
			if (!obj.isissueid(text)) {
				Display obj2 = new Display("Issue ID Not Found");
				obj2.setVisible(true);
			} else {
				founder = 1;
				String id = text;
				issuancedb obj1 = new issuancedb();
				bookinventoryalgo obj21 = new bookinventoryalgo();
				ResultSet usman = obj1.querryupdatea(text);
				String checker = "";
				while (usman.next()) {
					checker = usman.getString("UPC");
				}
				ResultSet abc = obj21.queryrep();
				while (abc.next()) {
					if (abc.getString("UPC").equals(checker))
						obj21.querryupdateb(checker, abc.getInt("Total"),
								abc.getInt("Issued") - 1,
								abc.getInt("Returned"),
								abc.getInt("Remaining") + 1,
								abc.getInt("discarded"));
				}
				int counter = 0;
				int counterchecker = 0;
				issuancealgo obj11 = new issuancealgo();
				ResultSet rs = obj11.queryrep();
				while (rs.next()) {
					counter++;
				}
				issuancedb obj112 = new issuancedb();
				obj112.delete(text);
				rs = obj11.queryrep();
				while (rs.next()) {
					counterchecker++;
				}
				if (counterchecker + 1 == counter) {
					Display disp = new Display(
							"Record has been Successfully Deleted");
					disp.setVisible(true);
				}
			}
		}
	}
}
