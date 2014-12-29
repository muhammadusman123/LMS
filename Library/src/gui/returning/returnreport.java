package gui.returning;
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
public class returnreport extends JFrame {
	private JPanel contentPane;
	private JTable table;
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
					returnreport frame = new returnreport();
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
	public returnreport() throws SQLException {
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
		setTitle("Book Return Report");
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
		returnalgo abc = new returnalgo();
		ResultSet rs = abc.queryrep();
		model.addColumn("ReturnID");
		model.addColumn("ReturnDate");
		model.addColumn("IssueID");
		model.addColumn("FinePaid");
		model.addColumn("UPC");
		int counter = -1;
		while (rs.next()) {
			counter++;
			model.addRow(new Object[6]);
			model.setValueAt(rs.getString("returnid"), counter, 0);
			model.setValueAt(rs.getString("returndate"), counter, 1);
			model.setValueAt(rs.getString("issueid"), counter, 2);
			model.setValueAt(rs.getString("finepaid"), counter, 3);
			model.setValueAt(rs.getString("UPC"), counter, 4);
		}
	}
}