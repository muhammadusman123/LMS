package gui.student;

import gui.Authentication.Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import algo.DatePicker;
import algo.NewLibTest;
import algo.ObservingTextField;
//import task2.myframe;
import algo.studentalgo;
import algo.studentautocomplete;
import algo.textvalidation;

import javax.swing.UIManager;

import database.alg;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentinsert extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public ObservingTextField textField_5;
	public static studentinsert frame;
	public ObservingTextField textField;
	public JComboBox comboBox;
	public String date = null;
	public String name = null;
	public String email = null;
	public String phone = null;
	public String gender = null;
	public String dob = null;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentinsert frame = new studentinsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @throws Exception
	 * 
	 */
	public studentinsert() throws Exception {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Student Insert Form");
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(33, 135, 86, 14);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 174, 46, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblPrice = new JLabel("DOB");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(33, 216, 46, 14);
		contentPane.add(lblPrice);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(196, 50, 112, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		// d.fun31(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField_2.getText().length() == 30) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(196, 87, 112, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// d.fun32(textField_2);
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_3.getText().length() == 15) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(196, 132, 112, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// d.fun33(textField_3);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(196, 213, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		// d.fun35(textField_5);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(339, 258, 95, 29);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(234, 258, 95, 29);
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentalgo algosobj = new studentalgo();
				date = textField.getText();
				name = textField_1.getText();
				email = textField_2.getText();
				phone = textField_3.getText();
				gender = (String) comboBox.getSelectedItem();
				dob = textField_5.getText();
				try {
					algosobj.querygen(date, name, email, phone, gender, dob);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (studentalgo.founder == 1) {
					studentalgo.founder = 0;
					dispose();
				}
			}
		});
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		studentautocomplete obj = new studentautocomplete(textField_1, "name");
		studentautocomplete obj1 = new studentautocomplete(textField_2, "email");
		studentautocomplete obj2 = new studentautocomplete(textField_3, "phone");

		JButton btnstudentdate = new JButton("student_Date");
		btnstudentdate.setBounds(282, 17, 26, 24);
		btnstudentdate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnstudentdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		contentPane.add(btnstudentdate);
		JLabel lblDate = new JLabel("Date of Joining");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 115, 14);
		contentPane.add(lblDate);
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(282, 209, 26, 29);
		contentPane.add(button);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male",
				"Female" }));
		comboBox.setBounds(196, 168, 112, 26);
		contentPane.add(comboBox);
	}
}