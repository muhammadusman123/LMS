package gui.returning;

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
import algo.returnautocomplete;
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
public class returninsert extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public static returninsert frame;
	public ObservingTextField textField;
	private JTextField textField_7;
	private JTextField textField_3;
	private Calendar Today;
	public String returndate = null;
	public String issueid = null;
	public String fine = null;
	public String studentid = null;
	public String upc = null;

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
					returninsert frame = new returninsert();
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
	public returninsert() throws Exception {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book Return Insert");
		JLabel lblNewLabel_1 = new JLabel("Issue ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 53, 86, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Fine Paid");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
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
		textField_1.setBounds(228, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_2.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(228, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// d.fun61(textField_2);
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
		btnNewButton.setBounds(345, 219, 86, 29);
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnalgo algosobj = new returnalgo();
				try {
					returndate = textField.getText();
					issueid = textField_1.getText();
					fine = textField_2.getText();
					upc = textField_7.getText();
					studentid = textField_3.getText();
					algosobj.querygen(returndate, issueid, fine, upc, studentid);
					if (returnalgo.founder == 1) {
						returnalgo.founder = 0;
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(5, 219, 97, 29);
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(228, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		// d.fun59(textField);

		Today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		textField.setText(sdf.format(Today.getTime()));
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
		btnreturndate.setBounds(316, 17, 26, 24);
		contentPane.add(btnreturndate);
		JLabel lblDate = new JLabel("Return Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 105, 14);
		contentPane.add(lblDate);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpc.setBounds(33, 119, 69, 20);
		contentPane.add(lblUpc);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(228, 118, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btnBarcode = new JButton("BarCode");
		btnBarcode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewLibTest obj = new NewLibTest();
				String value = obj.getbar();
				textField_7.setText(value);
			}
		});
		btnBarcode.setBounds(238, 219, 97, 29);
		contentPane.add(btnBarcode);
		textField_3 = new JTextField();
		returnautocomplete obj = new returnautocomplete(textField_1, "issueid");
		returnautocomplete obj2 = new returnautocomplete(textField_3,
				"studentid");
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
		textField_3.setBounds(228, 155, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblStudentid = new JLabel("Student ID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentid.setBounds(33, 156, 69, 20);
		contentPane.add(lblStudentid);
		JButton btnFineCalc = new JButton("Fine Calc");
		btnFineCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancealgo obj = new issuancealgo();
				java.sql.ResultSet rs = null;
				try {
					rs = obj.querryupdatea((textField_1.getText()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while (rs.next()) {
						DateTimeFormatter formatter = DateTimeFormat
								.forPattern("MM/dd/yyyy").withLocale(Locale.US);
						LocalDate date = formatter.parseLocalDate(rs
								.getString("returndate"));
						System.out.println(date.getDayOfMonth());
						System.out.println(date.getMonthOfYear());
						System.out.println(date.getYear());
						DateCalculator obj1 = new DateCalculator(date
								.getMonthOfYear(), date.getDayOfMonth(), date
								.getYear());
						// obj1.calculating(obj1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFineCalc.setBounds(120, 219, 97, 29);
		contentPane.add(btnFineCalc);
	}
}