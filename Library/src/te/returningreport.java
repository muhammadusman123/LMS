package te;

import gui.Authentication.Display;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.resource.cci.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import algo.DateCalculator;
import algo.DatePicker;
import algo.NewLibTest;
import algo.ObservingTextField;
import algo.issuancealgo;
//import task2.myframe;
import algo.returnalgo;
import algo.textvalidation;
import algo.verification;

import javax.swing.UIManager;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import database.alg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class returningreport extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public static returningreport frame;
	public ObservingTextField textField;
	private JTextField textField_7;
	private JTextField textField_3;
	private Calendar Today;
	public String returndate = null;
	public String issueid = null;
	public String fine = null;
	public String studentid = null;
	public String upc = null;
	private ObservingTextField textField_4;
	private JTextField textField_5;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					returningreport frame = new returningreport();
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
	public returningreport() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 256);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book Return Report");
		JLabel lblNewLabel_1 = new JLabel("Issue ID From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 53, 86, 14);
		contentPane.add(lblNewLabel_1);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(164, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// alg d = new alg();
		// d.fun60(textField_1);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(339, 178, 95, 29);
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Report");
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnalgo algosobj = new returnalgo();

				returndate = textField.getText();
				issueid = textField_1.getText();

				upc = textField_7.getText();
				studentid = textField_3.getText();
				String issueidto = textField_5.getText();
				String returndateto = textField_4.getText();
				int counter = 0;
				String query = "SELECT * FROM `returning` ";

				if (!studentid.equals("") && counter == 0) {
					query += " where `studentid` ='" + studentid + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!studentid.equals("") && counter != 0) {
					query += " AND `studentid` ='" + studentid + "'";
					counter = 1;
				}

				if (!issueid.equals("") && counter == 0) {
					query += " where `issueid` >='" + issueid + "'";
					counter = 1;
				} else if (!issueid.equals("") && counter != 0) {
					query += " AND `issueid` >='" + issueid + "'";
					counter = 1;
				}

				if (!returndate.equals("") && counter == 0) {
					query += " where `returndate` >='" + returndate + "'";
					counter = 1;
				} else if (!returndate.equals("") && counter != 0) {
					query += " AND `returndate` >='" + returndate + "'";
					counter = 1;
				}

				if (!upc.equals("") && counter == 0) {
					query += " where `UPC` ='" + upc + "'";
					counter = 1;
				} else if (!upc.equals("") && counter != 0) {
					query += " AND `UPC` ='" + upc + "'";
					counter = 1;
				}
				if (!issueidto.equals("") && counter == 0) {
					query += " where `issueid` <='" + issueidto + "'";
					counter = 1;
				} else if (!issueidto.equals("") && counter != 0) {
					query += " AND `issueid` <='" + issueidto + "'";
					counter = 1;
				}
				if (!returndateto.equals("") && counter == 0) {
					query += " where `returndate` <='" + returndateto + "'";
					counter = 1;
				} else if (!returndateto.equals("") && counter != 0) {
					query += " AND `returndate` <='" + returndateto + "'";
					counter = 1;
				}

				returning ma = new returning();
				ma.initConnection();

				try {
					ma.showReport(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAdd.setBounds(215, 178, 95, 29);
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(164, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		// d.fun59(textField);
		Today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		textField.setText("\r\n");
		JButton btnreturndate = new JButton("return_Date");
		btnreturndate
				.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnreturndate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				returnalgo obj = new returnalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		btnreturndate.setBounds(260, 17, 26, 24);
		contentPane.add(btnreturndate);
		JLabel lblDate = new JLabel("Return Date From");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 111, 14);
		contentPane.add(lblDate);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpc.setBounds(43, 84, 69, 20);
		contentPane.add(lblUpc);
		textField_7 = new JTextField();
		textField_7.setBounds(164, 81, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
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
				if (textField_3.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(164, 123, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblStudentid = new JLabel("Student id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentid.setBounds(33, 126, 69, 20);
		contentPane.add(lblStudentid);

		textField_4 = new ObservingTextField();
		textField_4.setEditable(false);
		textField_4.setText("");
		textField_4.setBounds(472, 16, 105, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 5) {
					e.consume();
				}
			}

		});
		textField_5.setBounds(472, 47, 107, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblIssueidTo = new JLabel("IssueID To");
		lblIssueidTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssueidTo.setBounds(371, 53, 86, 14);
		contentPane.add(lblIssueidTo);

		JLabel lblReturnDateTo = new JLabel("Return Date To");
		lblReturnDateTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnDateTo.setBounds(365, 19, 105, 14);
		contentPane.add(lblReturnDateTo);

		JButton button = new JButton("return_Date");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				returnalgo obj = new returnalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);

			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(585, 17, 26, 24);
		contentPane.add(button);
	}
}