package gui.UserReport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.alg;
import algo.payroll_autocomplete;
import algo.userreport_autocomplete;
import algo.userreportalgo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class userreportinsertion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	public String name, rollno, section, membership_date;
	public int id;

	public st_database_GUI frame;
	private ObservingTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public userreportinsertion() throws Exception {
		setBounds(100, 100, 450, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Student Addition Window");
		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(20, 29, 125, 14);
		contentPanel.add(lblStudentname);

		JLabel lblRollNo = new JLabel("University id");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRollNo.setBackground(Color.GRAY);
		lblRollNo.setBounds(20, 64, 111, 14);
		contentPanel.add(lblRollNo);

		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSection.setBackground(Color.GRAY);
		lblSection.setBounds(20, 101, 97, 14);
		contentPanel.add(lblSection);

		textField = new JTextField();
		userreport_autocomplete obj = new userreport_autocomplete(textField,
				"name");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (textField.getText().length() > 49) {

					e.consume();
				}
			}
		});
		textField.setBounds(196, 26, 125, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg d = new alg();
		// d.fun46(textField);
		textField_1 = new JTextField();
		userreport_autocomplete obj2 = new userreport_autocomplete(textField_1,
				"id2");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				if (textField_1.getText().length() > 5) {

					arg0.consume();
				}
			}
		});
		textField_1.setBounds(196, 62, 125, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		// d.fun47(textField_1);

		JButton btnMembershipdate = new JButton("Membershipdate");
		btnMembershipdate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnMembershipdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String lang = null;
				userreportalgo obj = new userreportalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);

			}

		});
		btnMembershipdate.setBounds(321, 135, 27, 23);
		contentPanel.add(btnMembershipdate);

		textField_4 = new ObservingTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(196, 136, 125, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		// d.fun49(textField_4);

		JLabel lblMembershipdate = new JLabel("Membership date");
		lblMembershipdate.setForeground(Color.BLACK);
		lblMembershipdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMembershipdate.setBounds(20, 138, 111, 14);
		contentPanel.add(lblMembershipdate);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "A", "B",
				"C", "D" }));
		comboBox.setBounds(196, 99, 125, 20);
		contentPanel.add(comboBox);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						boolean flag = false;
						name = textField.getText();
						rollno = textField_1.getText();
						section = comboBox.getSelectedItem().toString();
						membership_date = textField_4.getText();

						// id=Integer.parseInt(textField_3.getText());
						userreportalgo obj = new userreportalgo();
						try {
							flag = obj.Insert(name, rollno, section,
									membership_date);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
