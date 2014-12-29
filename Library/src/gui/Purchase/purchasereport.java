package gui.Purchase;
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
import algo.purchasealgo;
import database.dbclass;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class purchasereport extends JFrame {
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
					purchasereport frame = new purchasereport();
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
	public purchasereport() throws SQLException {
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
		setTitle("Book Purchase Report");
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
		purchasealgo abc = new purchasealgo();
		ResultSet rs = abc.queryrep();
		model.addColumn("Book ID");
		model.addColumn("ISBN");
		model.addColumn("Author_Name");
		model.addColumn("Book_Title");
		model.addColumn("Edition");
		model.addColumn("Price");
		model.addColumn("Purchase_Date");
		model.addColumn("Category");
		model.addColumn("UPC");
		int counter = -1;
		while (rs.next()) {
			counter++;
			model.addRow(new Object[9]);
			model.setValueAt(rs.getString("Book_ID"), counter, 0);
			model.setValueAt(rs.getString("ISBN"), counter, 1);
			model.setValueAt(rs.getString("Author_Name"), counter, 2);
			model.setValueAt(rs.getString("Book_Title"), counter, 3);
			model.setValueAt(rs.getString("Edition"), counter, 4);
			model.setValueAt(rs.getString("Price"), counter, 5);
			model.setValueAt(rs.getString("Purchase_Date"), counter, 6);
			model.setValueAt(rs.getString("Category"), counter, 7);
			model.setValueAt(rs.getString("UPC"), counter, 8);
		}
	}
}