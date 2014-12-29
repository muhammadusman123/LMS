package gui.Discard_Book_gui;

//import gui.bookPurchase;

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
import algo.discardautocomplete;
import algo.mail;

import javax.swing.JSeparator;

import gui.msg_gui.*;

import java.awt.Toolkit;

/**
 * 
 * @author Naveed
 *
 */
public class Update_Discard extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	public String ISBN;
	private ObservingTextField t12;

	// public String ID;
	public String id;

	public String Discard_datee;
	public String reason;
	public String copy;
	public String edit;
	public String name;
	public String book;
	public String price;
	public String purchase_date;
	// public static String []IDD=new String[100];
	// public static String []ID=new String[100];
	// public static String []copyy=new String[100];
	public static String[] ttype = new String[100];

	public Update_Discard framea;
	// public bookPurchase frame;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;

	// public String nameB;
	// public String bookB;
	// public String editB;
	// public String priceB;
	// public String dateB;
	// public String ISBNB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Update_Discard frame = new Update_Discard("");
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
	public Update_Discard(final String id) throws Exception {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\pic.png"));
		setTitle("Book Deletion Window");

		framea = this;

		// this.ID=ID;
		this.ISBN = ISBN;
		this.Discard_datee = Discard_datee;
		this.reason = reason;
		this.id = id;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDiscardBook = new JLabel("Discard Book");
		lblDiscardBook.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblDiscardBook.setBounds(200, 36, 270, 29);
		contentPane.add(lblDiscardBook);

		final JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookIsbn.setBounds(29, 133, 73, 29);
		contentPane.add(lblBookIsbn);

		t1 = new JTextField();
		t1.setBackground(Color.WHITE);
		t1.setEditable(false);
		t1.setBounds(149, 136, 108, 23);
		contentPane.add(t1);
		t1.setColumns(10);

		t12 = new ObservingTextField();
		t12.setBackground(Color.WHITE);
		t12.setForeground(Color.BLACK);
		t12.setEditable(false);
		t12.setBounds(427, 268, 108, 23);
		contentPane.add(t12);
		t12.setColumns(10);

		JLabel lblReasonOfDuscarding = new JLabel("Reason ");
		lblReasonOfDuscarding.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReasonOfDuscarding.setBounds(334, 127, 133, 41);
		contentPane.add(lblReasonOfDuscarding);

		final JLabel lblDiscardDate = new JLabel("Discard Date");
		lblDiscardDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiscardDate.setBounds(325, 268, 92, 14);
		contentPane.add(lblDiscardDate);

		t6 = new JTextField();
		t6.setBackground(Color.WHITE);
		t6.setForeground(Color.BLACK);
		t6.setEditable(false);
		t6.setBounds(149, 203, 108, 23);
		contentPane.add(t6);
		t6.setColumns(10);

		final JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdition.setBounds(336, 207, 46, 14);
		contentPane.add(lblEdition);

		t7 = new JTextField();
		t7.setBackground(Color.WHITE);
		t7.setForeground(Color.BLACK);
		t7.setEditable(false);
		t7.setBounds(429, 203, 108, 23);
		contentPane.add(t7);
		t7.setColumns(10);

		t8 = new JTextField();
		t8.setBackground(Color.WHITE);
		t8.setForeground(Color.BLACK);
		t8.setEditable(false);
		t8.setBounds(427, 335, 108, 23);
		contentPane.add(t8);
		t8.setColumns(10);

		final JLabel lblAuthorname = new JLabel("Author Name");
		lblAuthorname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAuthorname.setBounds(26, 272, 87, 14);
		contentPane.add(lblAuthorname);

		final JLabel lblBooktitle = new JLabel("Book Title");
		lblBooktitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBooktitle.setBounds(34, 207, 68, 14);
		contentPane.add(lblBooktitle);

		final JLabel lblPurchasedate = new JLabel("Purchase Date");
		lblPurchasedate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPurchasedate.setBounds(26, 339, 114, 14);
		contentPane.add(lblPurchasedate);

		final JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(334, 339, 46, 14);
		contentPane.add(lblPrice);

		t9 = new JTextField();
		t9.setBackground(Color.WHITE);
		t9.setForeground(Color.BLACK);
		t9.setEditable(false);
		t9.setBounds(149, 335, 108, 23);
		contentPane.add(t9);
		t9.setColumns(10);

		t5 = new JTextField();
		t5.setBackground(Color.WHITE);
		t5.setForeground(Color.BLACK);
		t5.setEditable(false);
		t5.setBounds(149, 268, 108, 23);
		contentPane.add(t5);
		t5.setColumns(10);
		// discardautocomplete obj = new discardautocomplete(t1, "isbn");
		// discardautocomplete obj1 = new discardautocomplete(t5, "author");
		// discardautocomplete obj2 = new discardautocomplete(t6, "book");
		// discardautocomplete obj3 = new discardautocomplete(t7, "edition");
		// discardautocomplete obj4 = new discardautocomplete(t8, "price");
		final JComboBox t4 = new JComboBox();
		t4.setBackground(Color.WHITE);
		t4.setEnabled(false);
		t4.setForeground(Color.BLACK);
		t4.setModel(new DefaultComboBoxModel(new String[] { "bad condition",
				"lost book by student" }));
		t4.setToolTipText("");
		t4.setBounds(429, 142, 143, 23);
		contentPane.add(t4);

		ResultSet rs = null;
		algo.Discard_algo alg = new algo.Discard_algo();
		try {
			rs = alg.querry(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("hellllo");

				// frame.ISBN=rs.getString("IISBN");

				// frame.name=rs.getString("Author_Name");
				// frame.book=rs.getString("Book_Title");
				// frame.edit=rs.getString("Price");
				// frame.price=rs.getString("Price");
				// framea.date=rs.getString("Purchase_Date");

				// nameB=rs.getString("Author_Name");
				// bookB=rs.getString("Book_Title");
				// editB=rs.getString("Edition");
				// priceB=rs.getString("Price");
				// dateB=rs.getString("Purchase_Date");
				// ISBNB=rs.getString("IISBN");

				// System.out.println(ISBNB);
				// System.out.println("date......."+dateB);

				t1.setText(rs.getString("IISBN"));
				// t2.setText(rs.getString("Discard_Date"));
				t12.setText(rs.getString("Discard_Date"));
				// t3.setText(rs.getString("Copy_No"));

				t4.setSelectedItem(rs.getString("Reason"));
				//
				//
				// t4.getSelectedItem();
				//
				t5.setText(rs.getString("Author_Name"));
				t6.setText(rs.getString("Book_Title"));
				t7.setText(rs.getString("Edition"));
				t8.setText(rs.getString("Price"));
				t9.setText(rs.getString("Purchase_Date"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnDiscard = new JButton("Delete");
		btnDiscard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// frame.ISBN=ISBNB;
				// frame.name=nameB;
				// frame.book= bookB;
				// frame.edit=editB;
				// frame.price=priceB;
				// framea.date=dateB;

				// System.out.println(frame.ISBN+frame.name);
				// System.out.println(ISBNB+"  "+nameB+" "+priceB);

				// algo.purchasealgo budgetobj=new
				// algo.purchasealgo();////////////////////////krna

				// budgetobj.Insert_frame2(1,ISBNB,
				// nameB,bookB,editB,priceB,dateB);

				int checktype = 0;
				int check = 0;

				// datee=t2.getText();
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
						|| book.isEmpty() || name.isEmpty() || edit.isEmpty()
						|| Discard_datee.isEmpty() || ISBN.isEmpty()) {
					check = 0;
					System.out.println("if");
				} else {
					System.out.println("else");
					check = 1;

				}
				System.out.println("this chek....=" + check);

				if (check == 1) {
					algo.Discard_algo budgetobj = new algo.Discard_algo();

					budgetobj.update(2, framea);
					// mail librarian=new
					// mail("F128067@nu.edu.pk","Book is successfully deleted from discard book database. The book information is as follows .... Book Name: "+book+
					// "     Author: "+name+"    Edition: "+edit+"");

					discard_msg ds = new discard_msg();
					ds.setVisible(true);
					dispose();
				}

				else {

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

				// Discard_algo budgetobj=new Discard_algo();
				// budgetobj.Insert_frame(1, framea);
				// Discard_algo budget=new Discard_algo();
				// budget.Discard_frame(1, framea);

			}
		});
		btnDiscard.setBounds(200, 426, 89, 23);
		contentPane.add(btnDiscard);

		JButton btnCencel = new JButton("Cencel");
		btnCencel.setForeground(Color.RED);
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(314, 426, 89, 23);
		contentPane.add(btnCencel);

		JSeparator separator = new JSeparator();
		separator.setBounds(28, 150, 1, 2);
		contentPane.add(separator);

	}
}
