package gui.Payroll;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algo.payroll_algo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payroll_salary2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	public JLabel labelid;
	public JLabel labelname;
	public JLabel labelpost;
	public JLabel labeldays;
	public JLabel labelhours;
	public JLabel labeldayrate;
	public JLabel labelhourrate;
	public JLabel labelsalary;
	public int days;
	float salary;
	public float hours, dayrate, hourrate;
	public String date;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public payroll_salary2(final int id) {
		setTitle("Salary Status Window");
		setBounds(100, 100, 450, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEmployeeid = new JLabel("Employee_id");
			lblEmployeeid.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeeid.setBounds(10, 11, 88, 14);
			contentPanel.add(lblEmployeeid);
		}
		{
			JLabel lblEmployeename = new JLabel("Employee-name");
			lblEmployeename.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmployeename.setBounds(10, 36, 100, 14);
			contentPanel.add(lblEmployeename);
		}
		{
			JLabel lblDays = new JLabel("Days");
			lblDays.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDays.setBounds(10, 86, 60, 14);
			contentPanel.add(lblDays);
		}
		{
			JLabel lblOvertimeHours = new JLabel("Overtime hours");
			lblOvertimeHours.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblOvertimeHours.setBounds(10, 111, 88, 14);
			contentPanel.add(lblOvertimeHours);
		}
		{
			JLabel lblRatePerDay = new JLabel("Rate per day");
			lblRatePerDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRatePerDay.setBounds(10, 136, 88, 14);
			contentPanel.add(lblRatePerDay);
		}
		{
			JLabel lblRatePerOvertime = new JLabel("Rate per overtime hour");
			lblRatePerOvertime.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRatePerOvertime.setBounds(10, 161, 142, 14);
			contentPanel.add(lblRatePerOvertime);
		}
		{
			JLabel lblSalary = new JLabel("Salary");
			lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSalary.setBounds(10, 186, 60, 14);
			contentPanel.add(lblSalary);
		}
		{
			JLabel lblPost = new JLabel("Post");
			lblPost.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPost.setBounds(10, 61, 52, 14);
			contentPanel.add(lblPost);
		}
		{
			labelid = new JLabel("");
			labelid.setBounds(282, 12, 46, 14);
			contentPanel.add(labelid);
		}
		{
			labelname = new JLabel("");
			labelname.setBounds(282, 37, 88, 14);
			contentPanel.add(labelname);
		}
		{
			labelpost = new JLabel("");
			labelpost.setBounds(282, 62, 142, 14);
			contentPanel.add(labelpost);
		}
		{
			labeldays = new JLabel("");
			labeldays.setBounds(282, 87, 46, 14);
			contentPanel.add(labeldays);
		}
		{
			labelhours = new JLabel("");
			labelhours.setBounds(282, 112, 46, 14);
			contentPanel.add(labelhours);
		}
		{
			labeldayrate = new JLabel("");
			labeldayrate.setBounds(282, 137, 46, 14);
			contentPanel.add(labeldayrate);
		}
		{
			labelhourrate = new JLabel("");
			labelhourrate.setBounds(282, 162, 46, 14);
			contentPanel.add(labelhourrate);
		}
		{
			labelsalary = new JLabel("");
			labelsalary.setBounds(282, 187, 46, 14);
			contentPanel.add(labelsalary);
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
						payroll_algo obj = new payroll_algo();
						days = 0;
						hours = 0;
						salary = 0;
						obj.Update(id, labelname.getText(),
								labelpost.getText(), days, hours, dayrate,
								hourrate, salary, date);
						dispose();

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
