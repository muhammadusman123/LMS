package gui.Payroll;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import algo.alg;
import algo.payroll_algo;
import algo.payroll_autocomplete;
import algo.userreportalgo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class payroll_update2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public String name, post, date;
	public int days;
	public float salary;
	public float hours, dayrate, hourrate;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public payroll_update2(final int id) throws Exception {
		setTitle("Employee Data Updation");
		setBounds(100, 100, 450, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblName.setBounds(30, 24, 54, 14);
			contentPanel.add(lblName);
		}
		{
			JLabel lblAddDays = new JLabel("Add Days");
			lblAddDays.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddDays.setBounds(30, 68, 68, 14);
			contentPanel.add(lblAddDays);
		}
		{
			JLabel lblAddOvertimeHours = new JLabel("Add overtime Hours");
			lblAddOvertimeHours.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblAddOvertimeHours.setBounds(30, 110, 119, 14);
			contentPanel.add(lblAddOvertimeHours);
		}
		{
			textField = new JTextField();
			payroll_autocomplete obj = new payroll_autocomplete(textField,
					"name");
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					if (textField.getText().length() > 30) {

						arg0.consume();
					}

				}
			});
			textField.setBounds(274, 22, 119, 20);
			contentPanel.add(textField);
			textField.setColumns(10);

		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(274, 66, 59, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(274, 108, 59, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						boolean flag = false;
						String s_days, s_hours;
						name = textField.getText();
						s_days = textField_1.getText();
						s_hours = textField_2.getText();
						if (s_days.isEmpty()) {
							s_days = "0";
						}
						if (s_hours.isEmpty()) {
							s_hours = "0";
						}
						days = days + Integer.parseInt(s_days);
						hours = hours + Float.parseFloat(s_hours);

						payroll_algo obj = new payroll_algo();
						flag = obj.Update(id, name, post, days, hours, dayrate,
								hourrate, salary, date);
						if (flag) {
							dispose();
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
