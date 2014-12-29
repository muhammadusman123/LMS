package gui.issuance;

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
import algo.issueautocomplete;
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
public class issuanceinsert extends JFrame {
	private JPanel contentPane;
	public ObservingTextField textField_2;
	public ObservingTextField textField_3;
	public static issuanceinsert frame;
	public JTextField textField;
	private JTextField textField_7;
	public String issuedate = null;
	public String returndate = null;
	public String upc = null;
	public String studentid = null;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					issuanceinsert frame = new issuanceinsert();
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
	public issuanceinsert() throws Exception {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book issuance Insert");
		JLabel lblNewLabel_2 = new JLabel("IssueDate");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(60, 76, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Return Date");
		lblNewLabel_3.setBounds(60, 119, 86, 14);
		contentPane.add(lblNewLabel_3);
		// alg d = new alg();
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(249, 74, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// d.fun56(textField_2);
		textField_3 = new ObservingTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(249, 116, 86, 20);
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
		btnNewButton.setBounds(309, 209, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancealgo algosobj = new issuancealgo();
				try {
					studentid = textField.getText();
					issuedate = textField_2.getText();
					returndate = textField_3.getText();
					upc = textField_7.getText();
					algosobj.querygen(studentid, issuedate, returndate, upc);
					if (issuancealgo.founder == 1) {
						issuancealgo.founder = 0;
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(43, 209, 115, 29);
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
		textField.setBounds(251, 23, 86, 20);
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
		btnissuancedate.setBounds(335, 72, 26, 24);
		contentPane.add(btnissuancedate);
		JLabel lblDate = new JLabel("StudentID");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(60, 25, 105, 14);
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
		button.setBounds(335, 114, 26, 24);
		contentPane.add(button);
		JLabel lblLabel = new JLabel("UPC");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLabel.setBounds(77, 161, 69, 20);
		contentPane.add(lblLabel);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(249, 158, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		issueautocomplete obj = new issueautocomplete(textField, "studentid");

		JButton btnBarcodereader = new JButton("BarCode");
		btnBarcodereader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewLibTest obj = new NewLibTest();
				String value = obj.getbar();
				textField_7.setText(value);
			}
		});
		btnBarcodereader.setBounds(179, 209, 112, 29);
		contentPane.add(btnBarcodereader);
	}
}