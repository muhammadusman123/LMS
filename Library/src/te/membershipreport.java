package te;

import gui.UserReport.st_database_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algo.DatePicker;
import algo.ObservingTextField;
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

public class membershipreport extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	public String name, rollno, section, membership_date;
	public int id;
	public st_database_GUI frame;
	private ObservingTextField textField_4;
	private JTextField textField_2;
	private ObservingTextField textField_3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					membershipreport frame = new membershipreport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public membershipreport() {
		setBounds(100, 100, 863, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Membership Report Window");
		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(20, 29, 125, 14);
		contentPanel.add(lblStudentname);
		JLabel lblRollNo = new JLabel("University id From");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollNo.setBackground(Color.GRAY);
		lblRollNo.setBounds(20, 64, 111, 14);
		contentPanel.add(lblRollNo);
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSection.setBackground(Color.GRAY);
		lblSection.setBounds(20, 101, 97, 14);
		contentPanel.add(lblSection);
		textField = new JTextField();
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
		// alg d = new alg();
		// d.fun46(textField);
		textField_1 = new JTextField();
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
		JLabel lblMembershipdate = new JLabel("Membership date From");
		lblMembershipdate.setForeground(Color.BLACK);
		lblMembershipdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMembershipdate.setBounds(20, 138, 140, 14);
		contentPanel.add(lblMembershipdate);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "A", "B",
				"C", "D" }));
		comboBox.setBounds(196, 99, 125, 20);
		contentPanel.add(comboBox);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField_2.getText().length() > 5) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(512, 58, 146, 26);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new ObservingTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(512, 133, 146, 26);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblUniversityIdTo = new JLabel("University id TO");
		lblUniversityIdTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUniversityIdTo.setBackground(Color.GRAY);
		lblUniversityIdTo.setBounds(354, 64, 111, 14);
		contentPanel.add(lblUniversityIdTo);

		JLabel label = new JLabel("Membership date From");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(355, 136, 140, 14);
		contentPanel.add(label);

		JButton button = new JButton("Membershipdate");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				userreportalgo obj = new userreportalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_3, locale);
				Date selectedDate = dp.parseDate(textField_3.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_3);

			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(662, 132, 27, 23);
		contentPanel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Report");
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
						String membership_dateto = textField_3.getText();
						String rollnoto = textField_2.getText();

						// id=Integer.parseInt(textField_3.getText());
						int counter = 0;
						String query = "SELECT * FROM `student_database` ";

						if (!section.equals("") && counter == 0) {
							query += " where `Section` ='" + section + "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!section.equals("") && counter != 0) {
							query += " AND `Section` ='" + section + "'";
							counter = 1;
						}

						if (!name.equals("") && counter == 0) {
							query += " where `Student_name` ='" + name + "'";
							counter = 1;
						} else if (!name.equals("") && counter != 0) {
							query += " AND `Student_name` ='" + name + "'";
							counter = 1;
						}

						if (!membership_date.equals("") && counter == 0) {
							query += " where `Membership_date` >='"
									+ membership_date + "'";
							counter = 1;
						} else if (!membership_date.equals("") && counter != 0) {
							query += " AND `Membership_date` >='"
									+ membership_date + "'";
							counter = 1;
						}
						if (!membership_dateto.equals("") && counter == 0) {
							query += " where `Membership_date` <='"
									+ membership_dateto + "'";
							counter = 1;
						} else if (!membership_dateto.equals("")
								&& counter != 0) {
							query += " AND `Membership_date` <='"
									+ membership_dateto + "'";
							counter = 1;
						}

						if (!rollno.equals("") && counter == 0) {
							query += " where `Student_id` >='" + rollno + "'";
							counter = 1;
						} else if (!rollno.equals("") && counter != 0) {
							query += " AND `Student_id` >='" + rollno + "'";
							counter = 1;
						}

						if (!rollnoto.equals("") && counter == 0) {
							query += " where `Student_id` <='" + rollnoto + "'";
							counter = 1;
						} else if (!rollnoto.equals("") && counter != 0) {
							query += " AND `Student_id` <='" + rollnoto + "'";
							counter = 1;
						}
						membership ma = new membership();
						ma.initConnection();
						try {
							ma.showReport(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// obj.setVisible(true);
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
