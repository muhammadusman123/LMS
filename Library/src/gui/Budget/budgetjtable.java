package gui.Budget;
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
import algo.budgetalgo;
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
public class budgetjtable extends JFrame {
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetjtable frame = new budgetjtable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public budgetjtable() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
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
		setTitle("Purchase Budget Report");
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
		btnOk.setBounds(350, 460, 115, 29);
		contentPane.add(btnOk);
		budgetalgo abc = new budgetalgo();
		ResultSet rs = abc.select();
		model.addColumn("ID");
		model.addColumn("Year");
		model.addColumn("Issue Date");
		model.addColumn("Aspected Amount");
		model.addColumn("Requested Amount");
		model.addColumn("Issued Amount");
		model.addColumn("Semester Type");
		model.addColumn("CS");
		model.addColumn("EE");
		model.addColumn("BBA");
		model.addColumn("HR");
		model.addColumn("FurnitureEquipment");
		model.addColumn("Bill");
		int counter = -1;
		while (rs.next()) {
			counter++;
			model.addRow(new Object[12]);
			model.setValueAt(rs.getString("ID"), counter, 0);
			model.setValueAt(rs.getString("Year"), counter, 1);
			model.setValueAt(rs.getString("Issue_Date"), counter, 2);
			model.setValueAt(rs.getString("Aspected_Amount"), counter, 3);
			model.setValueAt(rs.getString("Requested_Amount"), counter, 4);
			model.setValueAt(rs.getString("Issued_Amount"), counter, 5);
			model.setValueAt(rs.getString("Semester_Type"), counter, 6);
			model.setValueAt(rs.getString("CS"), counter, 7);
			model.setValueAt(rs.getString("EE"), counter, 8);
			model.setValueAt(rs.getString("BBA"), counter, 9);
			model.setValueAt(rs.getString("HR"), counter, 10);
			model.setValueAt(rs.getString("FurnitureEquipment"), counter, 11);
			model.setValueAt(rs.getString("Bill"), counter, 12);
		}
	}
}
