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
import algo.labelalgo;
//import task2.myframe;
import algo.purchasealgo;
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
public class PurchaseReport extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public static PurchaseReport frame;
	public ObservingTextField textField;
	public JTextField textField_7;
	public JComboBox comboBox;
	public static String labelofbook;
	public String date = null;
	public String isbn = null;
	public String authorname = null;
	public String bookname = null;
	public String edition = null;
	public String price = null;
	public String category = null;
	public String upc = null;
	private ObservingTextField textField_6;
	private JTextField textField_8;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PurchaseReport frame = new PurchaseReport();
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
	public PurchaseReport() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 397);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book Purchase Report");
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Author Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Book Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(33, 135, 86, 14);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Edition");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 174, 46, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblPrice = new JLabel("Price From");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(33, 216, 86, 14);
		contentPane.add(lblPrice);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_1.getText().length() == 10) {
					arg0.consume();
				}
			}
		});
		textField_1.setBounds(196, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// alg d = new alg();
		// d.fun31(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					arg0.consume();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
				}
				if (textField_2.getText().length() == 25) {
					arg0.consume();
				}
			}
		});
		textField_2.setBounds(196, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// d.fun32(textField_2);
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
				}
				if (textField_3.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(196, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// d.fun33(textField_3);
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_4.getText().length() == 2) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(196, 171, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		// d.fun34(textField_4);
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_5.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_5.setBounds(196, 213, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		// d.fun35(textField_5);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(309, 328, 115, 29);
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
		btnAdd.setBounds(163, 328, 115, 29);
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchasealgo algosobj = new purchasealgo();
				date = null;
				isbn = null;
				authorname = null;
				bookname = null;
				edition = null;
				price = null;
				category = null;
				upc = null;
				String todate = null;
				String toprice = null;

				date = textField.getText();
				isbn = textField_1.getText();
				authorname = textField_2.getText();
				bookname = textField_3.getText();
				edition = textField_4.getText();
				price = textField_5.getText();
				category = (String) comboBox.getSelectedItem();
				upc = textField_7.getText();
				todate = textField_6.getText();
				toprice = textField_8.getText();
				int counter = 0;
				String query = "SELECT * FROM `book1` ";

				if (!isbn.equals("") && counter == 0) {
					query += " where `ISBN` ='" + isbn + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!isbn.equals("") && counter != 0) {
					query += " AND `ISBN` ='" + isbn + "'";
					counter = 1;
				}

				if (!authorname.equals("") && counter == 0) {
					query += " where `Author_Name` ='" + authorname + "'";
					counter = 1;
				} else if (!authorname.equals("") && counter != 0) {
					query += " AND `Author_Name` ='" + authorname + "'";
					counter = 1;
				}

				if (!bookname.equals("") && counter == 0) {
					query += " where `Book_Title` ='" + bookname + "'";
					counter = 1;
				} else if (!bookname.equals("") && counter != 0) {
					query += " AND `Book_Title ='" + bookname + "'";
					counter = 1;
				}
				if (!edition.equals("") && counter == 0) {
					query += " where `Edition` ='" + edition + "'";
					counter = 1;
				} else if (!edition.equals("") && counter != 0) {
					query += " AND `Edition` ='" + edition + "'";
					counter = 1;
				}

				if (!upc.equals("") && counter == 0) {
					query += " where `UPC` ='" + upc + "'";
					counter = 1;
				} else if (!upc.equals("") && counter != 0) {
					query += " AND `UPC` ='" + upc + "'";
					counter = 1;
				}

				if (!category.equals("") && counter == 0) {
					query += " where `Category` ='" + category + "'";
					counter = 1;
				} else if (!category.equals("") && counter != 0) {
					query += " AND `Category` ='" + category + "'";
					counter = 1;
				}

				if (!price.equals("") && counter == 0) {
					query += " where `Price` >='" + price + "'";
					counter = 1;
				} else if (!price.equals("") && counter != 0) {
					query += " AND `Price` >='" + price + "'";
					counter = 1;
				}
				if (!date.equals("") && counter == 0) {
					query += " where `Purchase_Date` >='" + date + "'";
					counter = 1;
				} else if (!date.equals("") && counter != 0) {
					query += " AND `Purchase_Date` >='" + date + "'";
					counter = 1;
				}
				if (!todate.equals("") && counter == 0) {
					query += " where `Purchase_Date` <='" + todate + "'";
					counter = 1;
				} else if (!todate.equals("") && counter != 0) {
					query += " AND `Purchase_Date` <='" + todate + "'";
					counter = 1;
				}
				System.out.println(price + "" + toprice);
				if (!toprice.equals("") && counter == 0) {
					query += " where `Price` <='" + toprice + "'";
					counter = 1;
				} else if (!toprice.equals("") && counter != 0) {
					query += " AND `Price` <='" + toprice + "'";
					counter = 1;
				}
				MainApplication ma = new MainApplication();
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
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnPurchasedate = new JButton("Purchase_Date");
		btnPurchasedate.setBounds(287, 17, 26, 24);
		btnPurchasedate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnPurchasedate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				purchasealgo obj = new purchasealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		contentPane.add(btnPurchasedate);
		JLabel lblDate = new JLabel("Date From");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(33, 25, 69, 14);
		contentPane.add(lblDate);
		JLabel lblNewLabel_6 = new JLabel("Category");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(33, 258, 69, 20);
		contentPane.add(lblNewLabel_6);
		JLabel lblNewLabel_5 = new JLabel("UPC");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(33, 294, 69, 20);
		contentPane.add(lblNewLabel_5);
		textField_7 = new JTextField();
		textField_7.setBounds(196, 291, 86, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "BBA",
				"HS", "EE", "CS" }));
		comboBox.setBounds(196, 255, 86, 26);
		contentPane.add(comboBox);

		textField_6 = new ObservingTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(416, 16, 125, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_5.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_8.setBounds(416, 213, 121, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblPriceTo = new JLabel("Price To");
		lblPriceTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceTo.setBounds(345, 216, 86, 14);
		contentPane.add(lblPriceTo);

		JButton button = new JButton("Purchase_Date");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String lang = null;
				purchasealgo obj = new purchasealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_6, locale);
				Date selectedDate = dp.parseDate(textField_6.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_6);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(543, 17, 26, 24);
		contentPane.add(button);

		JLabel lblFromDate = new JLabel("Date TO");
		lblFromDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFromDate.setBounds(342, 25, 59, 14);
		contentPane.add(lblFromDate);
	}
}