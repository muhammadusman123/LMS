package te;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import algo.DatePicker;
import algo.Discard_algo;
import algo.ObservingTextField;
import algo.mail;

import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JSeparator;

import gui.msg_gui.*;

import java.awt.Toolkit;

/**
 * 
 * @author Naveed
 *
 */
public class discardingreport extends JFrame {

	private JPanel contentPane;
	private ObservingTextField t12;

	public String ISBN;
	public String ID;
	public String Discard_datee;
	public String reason;
	public String copy;
	public String edit;
	public String name;
	public String book;
	public String price;
	public String purchase_date;
	public static String[] ISBNN = new String[100];
	// public static String []ID=new String[100];
	// public static String []copyy=new String[100];
	public static String[] ttype = new String[100];

	public discardingreport framea;
	private ObservingTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					discardingreport frame = new discardingreport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public discardingreport() {

		setTitle("Discard Book Report Window");

		framea = this;
		this.ID = ID;
		this.ISBN = ISBN;
		this.Discard_datee = Discard_datee;
		this.reason = reason;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDiscardBook = new JLabel("Discard Book");
		lblDiscardBook.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		lblDiscardBook.setBounds(220, 22, 122, 46);
		contentPane.add(lblDiscardBook);

		t12 = new ObservingTextField();
		t12.setEditable(false);
		t12.setBackground(Color.WHITE);
		t12.setBounds(126, 174, 108, 23);
		contentPane.add(t12);
		t12.setColumns(10);

		final JLabel lblDiscardDate = new JLabel("Discard Date");
		lblDiscardDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscardDate.setBounds(24, 176, 92, 14);
		contentPane.add(lblDiscardDate);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(
				"C:\\Users\\Naveed\\Desktop\\project\\Librarian\\6666.png"));
		// btnNewButton.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(t12, locale);// t2 txtfild for
															// date//locale
															// format of date of
															// our regin
				Date selectedDate = (Date) dp.parseDate(t12.getText());// casting
																		// in
																		// Date
																		// type
				dp.setSelectedDate(selectedDate);// change colour
				dp.start(t12);

			}

			public Locale getLocale(String loc)// function in library
			{
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);

				} else {
					return Locale.US;
				}
			}

		});
		btnNewButton.setBounds(234, 174, 27, 23);
		contentPane.add(btnNewButton);

		JButton btnDiscard = new JButton("Report");
		btnDiscard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String year = t12.getText();
				int counter = 0;
				String query = "SELECT * FROM `discard_book` ";
				String yearto = textField.getText();
				if (!year.equals("") && counter == 0) {
					query += " where `Discard_Date` >='" + year + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!year.equals("") && counter != 0) {
					query += " AND `Discard_Date` >='" + year + "'";
					counter = 1;
				}

				if (!yearto.equals("") && counter == 0) {
					query += " where `Discard_Date` <='" + yearto + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!yearto.equals("") && counter != 0) {
					query += " AND `Discard_Date` <='" + yearto + "'";
					counter = 1;
				}
				System.out.println(year + "   " + yearto);
				discarding ma = new discarding();
				ma.initConnection();
				try {
					ma.showReport(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnDiscard.setBounds(172, 245, 89, 23);
		contentPane.add(btnDiscard);

		JButton btnCencel = new JButton("Cancel");
		btnCencel.setForeground(Color.RED);
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(307, 245, 89, 23);
		contentPane.add(btnCencel);

		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(425, 173, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDiscardDateTo = new JLabel("Discard Date To");
		lblDiscardDateTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscardDateTo.setBounds(292, 176, 104, 14);
		contentPane.add(lblDiscardDateTo);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);// t2 txtfild
																	// for
				// date//locale
				// format of date of
				// our regin
				Date selectedDate = (Date) dp.parseDate(textField.getText());// casting
				// in
				// Date
				// type
				dp.setSelectedDate(selectedDate);// change colour
				dp.start(textField);

			}

			public Locale getLocale(String loc)// function in library
			{
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);

				} else {
					return Locale.US;
				}
			}
		});
		button.setBackground(SystemColor.menu);
		button.setBounds(576, 172, 27, 23);
		contentPane.add(button);

	}
}
