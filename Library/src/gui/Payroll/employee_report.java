package gui.Payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import algo.payroll_algo;
import algo.userreportalgo;

public class employee_report extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee_report frame = new employee_report();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public employee_report() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1205, 275);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
	
		setTitle("Employee Report");
		DefaultTableModel model=new DefaultTableModel(){};
		table.setModel(model);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(469, 303, 115, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnOk);
		payroll_algo obj=new payroll_algo();
		ResultSet rs=obj.Report();
		model.addColumn("Employee_id");
		model.addColumn("Employee_name");
		model.addColumn("Post");
		model.addColumn("Days");
		model.addColumn("Overtime_hours");
		model.addColumn("Rate_per_day");
		model.addColumn("Rate_per_overtime_hour");
		model.addColumn("Salary");
		model.addColumn("Date_of_Joining");
	int counter=-1;

		while(rs.next())
		{
			counter++;
			model.addRow(new Object[7]);
		
			model.setValueAt(rs.getInt("Employee_id"),counter,0);
			model.setValueAt(rs.getString("Employee_name"),counter,1);
			model.setValueAt(rs.getString("Post"),counter,2);
			model.setValueAt(rs.getInt("Days"),counter,3);
			model.setValueAt(rs.getFloat("Overtime_hours"),counter,4);
			model.setValueAt(rs.getFloat("Rate_per_day"),counter,5);
			model.setValueAt(rs.getFloat("Rate_per_overtime_hour"),counter,6);
			model.setValueAt(rs.getFloat("Salary"),counter,7);
			model.setValueAt(rs.getString("Date_of_Joining"),counter,8);
			
		}
	


	}
}
