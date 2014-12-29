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
import algo.issuancealgo;
import algo.issuancealgo;
import algo.textvalidation;
import algo.verification;

import javax.swing.UIManager;

import database.alg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class issuancereport extends JFrame {
	private JPanel contentPane;
	public ObservingTextField textField_2;
	public ObservingTextField textField_3;
	public static issuancereport frame;
	public JTextField textField;
	private JTextField textField_7;
	public String issuedate = null;
	public String returndate = null;
	public String upc = null;
	public String studentid = null;
	private ObservingTextField textField_1;
	private ObservingTextField textField_4;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					issuancereport frame = new issuancereport();
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
	public issuancereport() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book Issuance Report");
		JLabel lblNewLabel_2 = new JLabel("From Issue Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(15, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("From Return Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(15, 133, 113, 17);
		contentPane.add(lblNewLabel_3);
		// alg d = new alg();
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(128, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// d.fun56(textField_2);
		textField_3 = new ObservingTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(128, 131, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// d.fun57(textField_3);
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
		btnNewButton.setBounds(302, 220, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Report");
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancealgo algosobj = new issuancealgo();

				studentid = textField.getText();
				issuedate = textField_2.getText();
				returndate = textField_3.getText();
				upc = textField_7.getText();
				String issuedateto = textField_1.getText();
				String returndateto = textField_4.getText();
				int counter = 0;
				String query = "SELECT * FROM `issuance` ";

				if (!studentid.equals("") && counter == 0) {
					query += " where `studentid` ='" + studentid + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!studentid.equals("") && counter != 0) {
					query += " AND `studentid` ='" + studentid + "'";
					counter = 1;
				}

				if (!issuedate.equals("") && counter == 0) {
					query += " where `issuedate` >='" + issuedate + "'";
					counter = 1;
				} else if (!issuedate.equals("") && counter != 0) {
					query += " AND `issuedate` >='" + issuedate + "'";
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
				if (!issuedateto.equals("") && counter == 0) {
					query += " where `issuedate` <='" + issuedateto + "'";
					counter = 1;
				} else if (!issuedateto.equals("") && counter != 0) {
					query += " AND `issuedate` <='" + issuedateto + "'";
					counter = 1;
				}
				if (!returndateto.equals("") && counter == 0) {
					query += " where `returndate` <='" + returndateto + "'";
					counter = 1;
				} else if (!returndateto.equals("") && counter != 0) {
					query += " AND `returndate` <='" + returndateto + "'";
					counter = 1;
				}

				issuance ma = new issuance();
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
		btnAdd.setBounds(166, 220, 115, 29);
		contentPane.add(btnAdd);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField.setBounds(104, 24, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		// d.fun54(textField);
		JButton btnissuancedate = new JButton("issuance_Date");
		btnissuancedate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnissuancedate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
			}
		});
		btnissuancedate.setBounds(224, 85, 26, 24);
		contentPane.add(btnissuancedate);
		JLabel lblDate = new JLabel("StudentID");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 105, 14);
		contentPane.add(lblDate);
		JButton button = new JButton("issuance_Date");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_3, locale);
				Date selectedDate = dp.parseDate(textField_3.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_3);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(224, 129, 26, 24);
		contentPane.add(button);
		JLabel lblLabel = new JLabel("UPC");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLabel.setBounds(33, 175, 69, 20);
		contentPane.add(lblLabel);
		textField_7 = new JTextField();
		textField_7.setBounds(104, 174, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_1 = new ObservingTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(364, 84, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_4 = new ObservingTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(364, 127, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblIssueDateTo = new JLabel("Issue Date TO");
		lblIssueDateTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssueDateTo.setBounds(265, 90, 105, 14);
		contentPane.add(lblIssueDateTo);

		JLabel lblReturnDateTo = new JLabel("Return Date TO");
		lblReturnDateTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnDateTo.setBounds(265, 134, 105, 14);
		contentPane.add(lblReturnDateTo);

		JButton button_1 = new JButton("issuance_Date");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_1, locale);
				Date selectedDate = dp.parseDate(textField_1.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_1);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(511, 85, 26, 24);
		contentPane.add(button_1);

		JButton button_2 = new JButton("issuance_Date");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(511, 126, 26, 24);
		contentPane.add(button_2);
	}
}