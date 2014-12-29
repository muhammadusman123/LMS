package algo;
import gui.Authentication.Display;
import gui.Authentication.MainPage;
import gui.Authentication.error;
import gui.Authentication.librarianmainpage;
import gui.Authentication.loginupdate2;
import gui.Authentication.studentmainpage;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import database.authenticationdb;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class loginalgo extends JFrame {
	public static String logintype;
	public static String username;
	public static String password;
	public static String[] user = new String[100];
	public static String[] pass = new String[100];
	public static String[] type = new String[100];
	private JPanel contentPane;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					loginalgo frame = new loginalgo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public void logininsertion(String a, String b, String c) {
		if (loginalgo.logintype.equals("owner")) {
			// c = c.getText();
		}
		algo.loginalgo l = new algo.loginalgo();
		try {
			l.insert(a, b, c);
		} catch (Exception fd) {
			fd.printStackTrace();
		}
		Display disp = new Display("Record has been Successfully Inserted");
		disp.setVisible(true);
		dispose();
		dispose();
	}
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public void validation(String a, String b) {
		int i = 0;
		algo.loginalgo algosaaobj = new algo.loginalgo();
		System.out.println();
		try {
			ResultSet a1;
			a1 = algosaaobj.select();
			while (a1.next()) {
				user[i] = a1.getString("User_name");
				pass[i] = a1.getString("User_pswd");
				type[i] = a1.getString("logintype");
				i++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int check = 0;
		for (int j = 0; j < i; j++) {
			if (user[j].equals(a) && pass[j].equals(b)) {
				check = 1;
				username = user[j];
				password = pass[j];
				logintype = type[j];
				if (type[j].equals("owner")) {
					error obj = new error(1, "Welcome to LMS");
					obj.setVisible(true);
					break;
				} else if (type[j].equals("librarian")) {
					error obj = new error(2, "Welcome to LMS");
					obj.setVisible(true);
					System.out.println("librarian");
					break;
				} else if (type[j].equals("student")) {
					error obj = new error(3, "Welcome to LMS");
					obj.setVisible(true);
					System.out.println("student");
					break;
				}
				dispose();
			}
		}
		if (check == 0) {
			error obj = new error(0, "You entered Wrong Password");
			obj.setVisible(true);
		}
	}
	/**
	 * 
	 * @param i
	 * @return
	 */
	public int typeofuser(int i) {
		if (i == 1) {
			MainPage o = new MainPage();
			o.setVisible(true);
		} else if (i == 2) {
			librarianmainpage obj1 = new librarianmainpage();
			obj1.setVisible(true);
		} else if (i == 3) {
			studentmainpage obj1 = new studentmainpage();
			obj1.setVisible(true);
		} else if (i == 0) {
		}
		return i;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @throws SQLException
	 */
	public void insert(String a, String b, String c) throws SQLException {
		authenticationdb obj = new authenticationdb();
		obj.insert(a, b, c);
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select() throws SQLException {
		authenticationdb obj = new authenticationdb();
		ResultSet rs = obj.select();
		return rs;
	}
	/**
	 * 
	 * @param string
	 * @return
	 * @throws SQLException
	 */
	public ResultSet updatea(String string) throws SQLException {
		ResultSet rs = null;
		authenticationdb obj = new authenticationdb();
		rs = obj.updatea(string);
		return rs;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @throws SQLException
	 */
	public void updateb(String a, String b) throws SQLException {
		authenticationdb obj = new authenticationdb();
		obj.updateb(a, b);
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public ResultSet selectb(String string) {
		String two = "student";
		ResultSet rs = null;
		authenticationdb obj = new authenticationdb();
		rs = obj.selectb(string);
		return rs;
	}
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public ResultSet querryupdatea(String id) {
		return null;
	}
}
