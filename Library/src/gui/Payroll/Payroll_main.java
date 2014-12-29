package gui.Payroll;

import gui.Authentication.MainPage;
import gui.UserReport.userreportjtable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.JLabel;

import te.membershipreport;
import te.payrollreport;
import algo.payroll_algo;

import java.awt.Font;

public class Payroll_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Payroll_main frame = new Payroll_main();
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
	public Payroll_main() {
		setResizable(false);
		setTitle("Payroll Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				payroll_insertion obj = null;
				try {
					obj = new payroll_insertion();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				obj.setVisible(true);
			}
		});
		btnInsert.setBounds(20, 76, 109, 23);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				payroll_update1 obj = null;
				try {
					obj = new payroll_update1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				obj.setVisible(true);
			}
		});
		btnUpdate.setBounds(298, 76, 109, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payroll_deletion obj = null;
				try {
					obj = new payroll_deletion();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setVisible(true);
			}
		});
		btnDelete.setBounds(162, 76, 109, 23);
		contentPane.add(btnDelete);

		JButton btnReport = new JButton("JTable");
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					employee_report obj;
					obj = new employee_report();

					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReport.setBounds(20, 129, 109, 23);
		contentPane.add(btnReport);

		JButton btnSalary = new JButton("Salary");
		btnSalary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				payroll_salary1 obj = null;
				try {
					obj = new payroll_salary1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				obj.setVisible(true);
			}
		});
		btnSalary.setBounds(162, 129, 109, 23);
		contentPane.add(btnSalary);

		JButton btnBack = new JButton("Exit");
		btnBack.setForeground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage obj = new MainPage();
				obj.setVisible(true);
			}
		});
		btnBack.setBounds(162, 172, 109, 23);
		contentPane.add(btnBack);

		JLabel lblPayrollInc = new JLabel("LMS Payroll");
		lblPayrollInc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPayrollInc.setBounds(148, 11, 145, 43);
		contentPane.add(lblPayrollInc);

		JLabel label = new JLabel("__________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(146, 11, 157, 54);
		contentPane.add(label);

		JButton btnCustomReports = new JButton("Reports");
		btnCustomReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				payrollreport obj = new payrollreport();
				obj.setVisible(true);
			}
		});
		btnCustomReports.setBounds(298, 129, 109, 23);
		contentPane.add(btnCustomReports);
	}
}
