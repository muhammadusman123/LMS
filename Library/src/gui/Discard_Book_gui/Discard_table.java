package gui.Discard_Book_gui;
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
import algo.Discard_algo;
import database.dbclass;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
 * 
 * @author Naveed
 *
 */
public class Discard_table extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Discard_table frame = new Discard_table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Discard_table() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\pic.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 750, 450);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		setTitle("Discard Book Report");
		DefaultTableModel model = new DefaultTableModel() {
		};
		table.setModel(model);
		JButton btnOk = new JButton("Close");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(350, 460, 115, 25);
		contentPane.add(btnOk);
		algo.Discard_algo abc = new algo.Discard_algo();
		ResultSet rs = abc.select();
		model.addColumn("ID");
		model.addColumn("ISBN");
		model.addColumn("Discard Date");
		model.addColumn("Author Name");
		model.addColumn("Book Title");
		model.addColumn("Edition");
		model.addColumn("Price");
		model.addColumn("Purchase Date");
		model.addColumn("Reason");
		
		
		int counter = -1;
		while (rs.next()) {
			counter++;
			model.addRow(new Object[12]);
			model.setValueAt(rs.getString("ID"), counter, 0);
			model.setValueAt(rs.getString("IISBN"), counter, 1);
			model.setValueAt(rs.getString("Discard_Date"), counter, 2);
			model.setValueAt(rs.getString("Author_Name"), counter, 3);
			model.setValueAt(rs.getString("Book_Title"), counter, 4);
			model.setValueAt(rs.getString("Edition"), counter, 5);
			model.setValueAt(rs.getString("Price"), counter, 6);
			model.setValueAt(rs.getString("Purchase_Date"), counter, 7);
			model.setValueAt(rs.getString("Reason"), counter, 8);
			
		}
	}
}
