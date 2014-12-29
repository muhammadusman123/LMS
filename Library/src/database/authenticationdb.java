package database;
import gui.Authentication.loginupdate2;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import database.dbclass;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class authenticationdb extends JFrame {
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
					// loginalgo frame = new loginalgo();
					// frame.setVisible(true);
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
	 * @throws SQLException
	 */
	public void insert(String a, String b, String c) throws SQLException {
		dbclass obj = new dbclass();
		obj.insert("INSERT INTO `login`(`User_name`, `User_pswd`,`logintype`) VALUES ('"
				+ a + "','" + b + "','" + c + "')");
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select() throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `login`");
		return rs;
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public ResultSet updatea(String string) {
		ResultSet rs = null;
		dbclass obj = new dbclass();
		rs = obj.select("SELECT * FROM `login` WHERE User_name='" + string
				+ "'");
		return rs;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @throws SQLException
	 */
	public void updateb(String a, String b) throws SQLException {
		String update_query;
		update_query = "UPDATE `login` SET `User_name`= '" + a
				+ "' ,`User_pswd`='" + b + "' WHERE `User_name`='" + a + "'";
		dbclass obj = new dbclass();
		obj.insert(update_query);
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public ResultSet selectb(String string) {
		String two = "student";
		ResultSet rs = null;
		dbclass obj = new dbclass();
		rs = obj.select("SELECT * FROM `login` WHERE logintype='" + string
				+ "'  OR logintype='" + two + "'");
		return rs;
	}
	/**
	 * 
	 */
	public authenticationdb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ResultSet querryupdatea(String id) {
		return null;
	}
}
