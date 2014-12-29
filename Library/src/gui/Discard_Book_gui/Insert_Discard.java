package gui.Discard_Book_gui;

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
import algo.discardautocomplete;

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
public class Insert_Discard extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
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

	public Insert_Discard framea;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Insert_Discard frame = new Insert_Discard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public Insert_Discard() throws Exception {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\project\\Librarian\\pic.png"));
		setTitle("Discard Book");

		framea = this;
		this.ID = ID;
		this.ISBN = ISBN;
		this.Discard_datee = Discard_datee;
		this.reason = reason;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDiscardBook = new JLabel("Discard Book");
		lblDiscardBook.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblDiscardBook.setBounds(220, 22, 122, 46);
		contentPane.add(lblDiscardBook);

		final JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookIsbn.setBounds(24, 106, 73, 29);
		contentPane.add(lblBookIsbn);

		t1 = new JTextField();
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char cha = arg0.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
				if (t1.getText().length() > 3) {
					getToolkit().beep();
					arg0.consume();
				}

			}
		});
		t1.setBounds(107, 109, 108, 23);
		contentPane.add(t1);
		t1.setColumns(10);

		t5 = new JTextField();
		t5.setBackground(Color.WHITE);
		t5.setEditable(false);
		t5.setBounds(121, 319, 108, 23);
		contentPane.add(t5);
		t5.setColumns(10);

		t12 = new ObservingTextField();
		t12.setBackground(Color.WHITE);
		t12.setEditable(false);
		t12.setBounds(107, 172, 108, 23);
		contentPane.add(t12);
		t12.setColumns(10);

		final JLabel lblAuthorname = new JLabel("Author Name");
		lblAuthorname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAuthorname.setBounds(24, 323, 87, 14);
		contentPane.add(lblAuthorname);

		final JLabel lblBooktitle = new JLabel("Book Title");
		lblBooktitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBooktitle.setBounds(294, 323, 68, 14);
		contentPane.add(lblBooktitle);

		t6 = new JTextField();
		t6.setBackground(Color.WHITE);
		t6.setEditable(false);
		t6.setBounds(404, 314, 108, 23);
		contentPane.add(t6);
		t6.setColumns(10);

		final JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdition.setBounds(34, 376, 46, 14);
		contentPane.add(lblEdition);

		t7 = new JTextField();
		t7.setBackground(Color.WHITE);
		t7.setEditable(false);
		t7.setBounds(121, 372, 108, 23);
		contentPane.add(t7);
		t7.setColumns(10);

		t8 = new JTextField();
		t8.setBackground(Color.WHITE);
		t8.setEditable(false);
		t8.setBounds(404, 367, 108, 23);
		contentPane.add(t8);
		t8.setColumns(10);

		final JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(305, 376, 46, 14);
		contentPane.add(lblPrice);

		t9 = new JTextField();
		t9.setBackground(Color.WHITE);
		t9.setEditable(false);
		t9.setBounds(121, 427, 108, 23);
		contentPane.add(t9);
		t9.setColumns(10);

		discardautocomplete obj = new discardautocomplete(t1, "isbn");
		discardautocomplete obj1 = new discardautocomplete(t5, "author");
		discardautocomplete obj2 = new discardautocomplete(t6, "book");
		discardautocomplete obj3 = new discardautocomplete(t7, "edition");
		discardautocomplete obj4 = new discardautocomplete(t8, "price");
		final JLabel lblPurchasedate = new JLabel("Purchase Date");
		lblPurchasedate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPurchasedate.setBounds(24, 431, 114, 14);
		contentPane.add(lblPurchasedate);

		JLabel lblReasonOfDuscarding = new JLabel("Reason");
		lblReasonOfDuscarding.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReasonOfDuscarding.setBounds(294, 100, 141, 41);
		contentPane.add(lblReasonOfDuscarding);

		final JLabel lblDiscardDate = new JLabel("Discard Date");
		lblDiscardDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiscardDate.setBounds(24, 176, 92, 14);
		contentPane.add(lblDiscardDate);

		final JComboBox t4 = new JComboBox();
		t4.setModel(new DefaultComboBoxModel(new String[] { "bad condition",
				"lost book by student" }));
		t4.setToolTipText("");
		t4.setBounds(371, 109, 162, 23);
		contentPane.add(t4);

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
		btnNewButton.setBounds(220, 172, 27, 23);
		contentPane.add(btnNewButton);

		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int remainbook = 1;// ///////////////////////////////////change
				// this

				if (remainbook > 0) {

					int checktype = 0;
					int check = 0;

					Discard_datee = t12.getText();
					ISBN = t1.getText();
					reason = (String) t4.getSelectedItem();
					// copy=t3.getText();

					edit = t7.getText();
					name = t5.getText();
					book = t6.getText();
					price = t8.getText();
					purchase_date = t9.getText();

					System.out.println(Discard_datee);
					System.out.println(ISBN);
					System.out.println(copy);
					System.out.println(reason);

					if (purchase_date.isEmpty() || price.isEmpty()
							|| book.isEmpty() || name.isEmpty()
							|| edit.isEmpty() || Discard_datee.isEmpty()
							|| ISBN.isEmpty()) {
						check = 0;
						System.out.println("if");
					} else {
						System.out.println("else");
						check = 1;

					}
					System.out.println("this chek....=" + check);

					if (check == 1) {

						Discard_algo budgetobj = new Discard_algo();
						budgetobj.Insert_frame(1, framea);
						// Discard_algo budget=new Discard_algo();
						// budget.Discard_frame(1, framea);

						discard_msg ds = new discard_msg();
						ds.setVisible(true);

						dispose();

						// mail librarian=new
						// mail("F128067@nu.edu.pk","Book is discarded successfully. The book information is as follows .... Book Name: "+book+
						// "     Author: "+name+"    Edition: "+edit+"");

					} else {

						System.out.println("else part");

						Empty_MSG jj = new Empty_MSG();
						jj.setVisible(true);

						if (purchase_date.isEmpty()) {
							lblPurchasedate.setForeground(Color.RED);
						} else {
							lblPurchasedate.setForeground(Color.BLACK);
						}
						if (Discard_datee.isEmpty()) {
							lblDiscardDate.setForeground(Color.RED);
						} else {
							lblDiscardDate.setForeground(Color.BLACK);
						}

						if (price.isEmpty()) {

							lblPrice.setForeground(Color.RED);
						} else {
							lblPrice.setForeground(Color.BLACK);
						}

						if (book.isEmpty()) {
							// System.out.println("tttttttttttype="+type);
							lblBooktitle.setForeground(Color.RED);
						} else {
							lblBooktitle.setForeground(Color.BLACK);

						}
						if (name.isEmpty()) {
							lblAuthorname.setForeground(Color.RED);
						} else {
							lblAuthorname.setForeground(Color.BLACK);
						}
						if (edit.isEmpty()) {
							lblEdition.setForeground(Color.RED);
						} else {
							lblEdition.setForeground(Color.BLACK);
						}
						if (ISBN.isEmpty()) {
							lblBookIsbn.setForeground(Color.RED);
						} else {
							lblBookIsbn.setForeground(Color.BLACK);
						}
						// lblSemesterType.setForeground(Color.RED);

					}

				} else {
					noremainbook no = new noremainbook();
					no.setVisible(true);

				}
			}

		});
		btnDiscard.setBounds(179, 501, 89, 23);
		contentPane.add(btnDiscard);

		JButton btnCencel = new JButton("Cencel");
		btnCencel.setForeground(Color.RED);
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(294, 501, 89, 23);
		contentPane.add(btnCencel);

		JButton btnEnter = new JButton("Get Information");
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ISBN = t1.getText();
				// copy="0";
				System.out.println("ISBN=" + ISBN);
				System.out.println("copy=" + copy);
				int i = 0;
				algo.purchasealgo algosaaobj = new algo.purchasealgo();// ///////////////change
				// krna
				try {
					java.sql.ResultSet a;
					a = algosaaobj.queryrep();
					while (a.next()) {
						ISBNN[i] = a.getString("ISBN");
						// copyy[i]=a.getString("Copy_number");
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int checkit = 0;
				for (int j = 0; j < i; j++) {
					if (ISBNN[j].equals(ISBN))// && copyy[j].equals(copy))
					{
						System.out.println("id" + ISBN);
						// System.out.println("ID" +ISBNN[j]);
						checkit = 1;
						// dispose();
						ResultSet rs = null;
						algo.purchasealgo alg = new algo.purchasealgo();// ///payroll
						// se
						// yahan
						// values
						// dalwane...........
						try {
							System.out.println("hellllo");
							rs = alg.querryupdatec(ISBN);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("hellllo");
						try {
							while (rs.next()) {
								System.out.println("hellllo");
								// name=
								// book=
								// price=
								// date=
								// t1.setText(rs.getString("total_of_salaries"));
								// t6.setText(rs.getString("BBA"));
								t5.setText(rs.getString("Author_Name"));
								t6.setText(rs.getString("Book_Title"));
								t7.setText(rs.getString("Edition"));
								t8.setText(rs.getString("Price"));
								t9.setText(rs.getString("Purchase_Date"));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("hellllo");
							e1.printStackTrace();
						}
						break;
					}
				}
				if (checkit == 0) {
					update_failed_msgg jj = new update_failed_msgg();
					jj.setVisible(true);
				}
			}
		});
		btnEnter.setBounds(201, 237, 123, 23);
		contentPane.add(btnEnter);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 280, 523, 185);
		contentPane.add(separator);

	}
}
