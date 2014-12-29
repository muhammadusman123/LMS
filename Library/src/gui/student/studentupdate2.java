package gui.student;

import gui.Authentication.Display;

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

import database.alg;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.studentalgo;
import algo.studentautocomplete;
import algo.textvalidation;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentupdate2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public ObservingTextField textField_2;
	public String name, bookname;
	public int bookid;
	public studentupdate2 frameab;
	public JTextField textField_4;
	public ObservingTextField textField_5;
	public JComboBox comboBox;

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	public studentupdate2(final String id) throws Exception {
		frameab = this;
		setBounds(100, 100, 450, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("student Update2 Form");
		contentPanel.setLayout(null);
		JLabel lblNobooks = new JLabel("DOB");
		lblNobooks.setBounds(24, 122, 77, 14);
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNobooks);
		JLabel lblStudentname = new JLabel("Name");
		lblStudentname.setBounds(24, 39, 134, 14);
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Email");
		lblBook.setBounds(24, 84, 106, 14);
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblBook);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField.setBounds(222, 37, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		//
		// a.fun31(textField);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField_1.getText().length() == 30) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(222, 82, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun32(textField_1);
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(222, 120, 115, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun33(textField_2);
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_4.getText().length() == 15) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(222, 210, 115, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(24, 166, 69, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setBounds(24, 209, 69, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(222, 250, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		System.out.println("HELLLLLLLLLLLLLLLLLo");
		// studentautocomplete obj = new studentautocomplete(textField, "name");
		// studentautocomplete obj1 = new studentautocomplete(textField_1,
		// "email");
		// studentautocomplete obj2 = new studentautocomplete(textField_4,
		// "phone");

		JButton btnstudentDate = new JButton("student Date");
		btnstudentDate.setBounds(339, 250, 30, 20);
		btnstudentDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnstudentDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
		});
		contentPanel.add(btnstudentDate);
		JLabel lblNewLabel_2 = new JLabel("Date of Joining");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(24, 253, 106, 17);
		contentPanel.add(lblNewLabel_2);
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
			}
		});
		button.setBounds(339, 120, 33, 20);
		contentPanel.add(button);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male\t",
				"Female" }));
		comboBox.setBounds(222, 162, 115, 26);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					private String date;
					private String email;
					private String phone;
					private String gender;
					private String dob;

					@Override
					public void actionPerformed(ActionEvent arg0) {
						studentalgo obj = new studentalgo();
						date = textField_5.getText();
						name = textField.getText();
						email = textField_1.getText();
						phone = textField_4.getText();
						gender = (String) comboBox.getSelectedItem();
						dob = textField_2.getText();
						obj.querryupdateb(id, date, name, email, phone, gender,
								dob);
						if (studentalgo.founder == 1) {
							studentalgo.founder = 0;
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