package te;

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
public class universityreport extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public static universityreport frame;
	public ObservingTextField textField;
	public JComboBox comboBox;
	public String date = null;
	public String name = null;
	public String email = null;
	public String phone = null;
	public String gender = null;
	public String dob = null;
	private ObservingTextField textField_2;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					universityreport frame = new universityreport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 */
	public universityreport() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 260);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle(" Student Report Window");
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 120, 86, 14);
		contentPane.add(lblNewLabel_4);
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
		textField_1.setBounds(196, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// alg d = new alg();
		// d.fun31(textField_1);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(354, 169, 80, 29);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Report");
		btnAdd.setBounds(258, 169, 86, 29);
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentalgo algosobj = new studentalgo();
				date = textField.getText();
				name = textField_1.getText();
				// email = textField_2.getText();
				String dateto = textField_2.getText();
				gender = (String) comboBox.getSelectedItem();
				int counter = 0;
				String query = "SELECT * FROM `student` ";

				if (!name.equals("") && counter == 0) {
					query += " where `name` ='" + name + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!name.equals("") && counter != 0) {
					query += " AND `name` ='" + name + "'";
					counter = 1;
				}

				if (!date.equals("") && counter == 0) {
					query += " where `date` >='" + date + "'";
					counter = 1;
				} else if (!date.equals("") && counter != 0) {
					query += " AND `date` >='" + date + "'";
					counter = 1;
				}

				if (!gender.equals("") && counter == 0) {
					query += " where `gender` ='" + gender + "'";
					counter = 1;
				} else if (!gender.equals("") && counter != 0) {
					query += " AND `gender` ='" + gender + "'";
					counter = 1;
				}

				if (!dateto.equals("") && counter == 0) {
					query += " where `date` <='" + dateto + "'";
					counter = 1;
				} else if (!dateto.equals("") && counter != 0) {
					query += " AND `date` <='" + dateto + "'";
					counter = 1;
				}
				university ma = new university();
				ma.initConnection();

				try {
					ma.showReport(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		// obj.setVisible(true);

		);
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnstudentdate = new JButton("student_Date");
		btnstudentdate.setBounds(292, 17, 26, 24);
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
		JLabel lblDate = new JLabel("From Date of join");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 115, 14);
		contentPane.add(lblDate);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Male",
				"Female" }));
		comboBox.setBounds(196, 114, 86, 26);
		contentPane.add(comboBox);

		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(488, 19, 108, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton button = new JButton("student_Date");
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
		button.setBackground(Color.WHITE);
		button.setBounds(602, 17, 26, 24);
		contentPane.add(button);

		JLabel lblToDateOf = new JLabel("To Date of Join");
		lblToDateOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToDateOf.setBounds(354, 22, 115, 14);
		contentPane.add(lblToDateOf);
	}
}