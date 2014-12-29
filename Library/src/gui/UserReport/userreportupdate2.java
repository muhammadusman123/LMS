package gui.UserReport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.alg;
import algo.userreport_autocomplete;
import algo.userreportalgo;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class userreportupdate2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public String name, section, membership_date;

	public int count, rollno;
	public st_database_GUI frame;
	public ObservingTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public userreportupdate2(final int id) throws Exception {

		setBounds(100, 100, 450, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Student Data Updation Window");

		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBounds(30, 11, 144, 14);
		contentPanel.add(lblStudentname);

		JLabel lblBook_1 = new JLabel("Section");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook_1.setBounds(30, 52, 109, 14);
		contentPanel.add(lblBook_1);

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
		textField.setBounds(212, 8, 109, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		JButton btnFromdate = new JButton("...");
		btnFromdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnFromdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);
			}

			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);

				} else {
					return Locale.US;
				}
			}
		});
		btnFromdate.setBounds(320, 88, 20, 23);
		contentPanel.add(btnFromdate);

		textField_4 = new ObservingTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(212, 89, 109, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblFromdate = new JLabel("Membership date");
		lblFromdate.setForeground(Color.BLACK);
		lblFromdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFromdate.setBounds(30, 91, 109, 14);
		contentPanel.add(lblFromdate);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "A", "B",
				"C", "D" }));
		comboBox.setBounds(212, 50, 109, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						boolean flag;

						name = textField.getText();

						section = comboBox.getSelectedItem().toString();
						membership_date = textField_4.getText();
						userreportalgo obj = new userreportalgo();
						flag = obj.Update(id, name, rollno, section,
								membership_date);
						if (flag) {
							dispose();
						}

					}
				});
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

						dispose();
					}
				});
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
