package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import algo.loginalgo;
import algo.returnalgo;
import database.dbclass;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class loginjtable extends JFrame {
	private JPanel contentPane;
	private JTable table;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					loginjtable frame = new loginjtable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public loginjtable() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 275);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		setTitle("Login List");
		DefaultTableModel model = new DefaultTableModel() {
		};
		table.setModel(model);
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(469, 303, 115, 29);
		contentPane.add(btnOk);
		loginalgo obj = new loginalgo();
		ResultSet rs = null;
		if (loginalgo.logintype.equals("student")) {
			rs = obj.updatea(loginalgo.username);
		} else if (loginalgo.logintype.equals("librarian")) {
			rs = obj.selectb(loginalgo.logintype);
		} else {
			rs = obj.select();
		}
		model.addColumn("UserName");
		model.addColumn("PassWord");
		model.addColumn("LoginType");
		int counter = -1;
		while (rs.next()) {
			counter++;
			model.addRow(new Object[6]);
			model.setValueAt(rs.getString("User_name"), counter, 0);
			model.setValueAt(rs.getString("User_pswd"), counter, 1);
			model.setValueAt(rs.getString("logintype"), counter, 2);
		}
	}
}