package gui.Budget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import algo.DatePicker;
import algo.ObservingTextField;
//import algo.alg;
import algo.budgetalgo;
import algo.mail;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//import msg_gui.Empty_MSG;
//import msg_gui.Insert_msgg;
//import msg_gui.Msg;
//import msg_gui.capital_letter_msg;
//import msg_gui.textlength;
//import msg_gui.update_failed_msgg;
/**
 * 
 * @author Naveed
 *
 */
public class budgetinsertion extends JFrame {

	private JPanel contentPane;
	private ObservingTextField t2;
	private JTextField t3;
	private JTextField t5;
	private JTextField t6;
	// public String a;
	// public static String []ID=new String[100];
	public static String[] ttype = new String[100];
	public static String[] yyear = new String[100];
	// t1.setText(t2.getText());0
	// ///for date
	public String sdate;
	public String CS;
	public String EE;
	public String BBA;
	public String HR;
	private JTable table;
	public String year;
	public String req;
	public String asp;
	public String issue;
	public String type;

	public String equip;
	public String bill;

	public static String[] ID = new String[100];
	public budgetinsertion framea;
	private JTextField textField;
	public String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetinsertion frame = new budgetinsertion();
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
	public budgetinsertion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));

		framea = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 380);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Purchase Budget Window");

		final JLabel lblNewLabel_2 = new JLabel("Aspected Amount");
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(290, 103, 108, 14);
		contentPane.add(lblNewLabel_2);

		final JLabel lblNewLabel_3 = new JLabel("Semester Type");
		lblNewLabel_3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(29, 154, 96, 14);
		contentPane.add(lblNewLabel_3);

		final JComboBox t11 = new JComboBox();
		t11.setModel(new DefaultComboBoxModel(new String[] { "fall", "spring" }));
		t11.setBounds(135, 151, 108, 20);
		contentPane.add(t11);

		final JLabel lblNewLabel_4 = new JLabel("Requested Amount");
		lblNewLabel_4.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(290, 154, 132, 14);
		contentPane.add(lblNewLabel_4);

		final JLabel lblNewLabel_5 = new JLabel("Issue Amount");
		lblNewLabel_5.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(38, 213, 87, 14);
		contentPane.add(lblNewLabel_5);

		t2 = new ObservingTextField();
		t2.setBackground(SystemColor.window);
		t2.setEditable(false);
		t2.setBounds(425, 204, 108, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		// alg a=new alg();
		// a.fun37(t2);

		t3 = new JTextField();
		t3.setBackground(SystemColor.window);
		t3.setEditable(false);
		t3.setBounds(425, 100, 108, 23);
		contentPane.add(t3);
		t3.setColumns(10);
		// a.fun38(t3);

		final JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIssueDate.setBounds(312, 208, 73, 24);
		contentPane.add(lblIssueDate);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(375, 0, 46, 55);
		// Image imge=new ImageIcon
		// (this.getClass().getResource("/1013.png")).getImage();
		// label_1.setIcon(new ImageIcon(imge));
		contentPane.add(label_1);

		t5 = new JTextField();
		t5.setBackground(SystemColor.window);
		t5.setEditable(false);
		t5.setBounds(425, 151, 108, 23);
		contentPane.add(t5);
		t5.setColumns(10);
		// a.fun40(t5);

		t6 = new JTextField();
		t6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char cha = e.getKeyChar();
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
				if (t6.getText().length() > 8) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		t6.setBounds(135, 209, 108, 23);
		contentPane.add(t6);
		t6.setColumns(10);
		// a.fun41(t6);

		final JLabel lblIdyear = new JLabel("Year");
		lblIdyear.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIdyear.setBounds(52, 104, 46, 14);
		contentPane.add(lblIdyear);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char cha = e.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
				if (textField.getText().length() > 3) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		textField.setBounds(135, 100, 108, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSalaryBudget = new JLabel("Purchase Budget");
		lblSalaryBudget.setForeground(UIManager.getColor("Button.foreground"));
		lblSalaryBudget.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblSalaryBudget.setBounds(202, 11, 412, 36);
		contentPane.add(lblSalaryBudget);

		JButton btnAdd = new JButton("Insert");
		// btnAdd.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\1111.png"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// String asp;
				// String req;
				int checktype = 0;
				int check = 0;

				CS = "0";
				EE = "0";
				BBA = "0";
				HR = "0";
				equip = "0";
				bill = "0";

				year = textField.getText();

				req = t5.getText();

				asp = t3.getText();
				issue = t6.getText();
				// type=t4.getText();
				sdate = t2.getText();
				type = (String) t11.getSelectedItem();

				if (year.isEmpty() || req.isEmpty() || asp.isEmpty()
						|| issue.isEmpty() || sdate.isEmpty()) {
					check = 0;
					System.out.println("if");
				} else if (textField.getText().length() != 4) {

					check = 4;

				} else {
					System.out.println("else");
					check = 1;

				}
				System.out.println("this chek....=" + check);

				if (check == 1) {

					System.out
							.println("....................check this................");

					// yearr=textField.getText();
					type = (String) t11.getSelectedItem();
					year = textField.getText();
					int i = 0;
					algo.budgetalgo algosaaobj = new algo.budgetalgo();

					try {
						java.sql.ResultSet a;
						a = algosaaobj.select();
						while (a.next()) {

							yyear[i] = a.getString("Year");
							ttype[i] = a.getString("Semester_Type");

							i++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int checkit = 0;
					for (int j = 0; j < i; j++) {
						if (yyear[j].equals(year) && ttype[j].equals(type)) {
							System.out.println("yearr======" + year);
							System.out.println("yyear=======" + yyear[j]);
							System.out.println("type========" + type);
							System.out.println("ttype=======" + ttype[j]);
							checkit = 1;
							// dispose();

							// Update_Salary_Budget obj=new
							// Update_Salary_Budget(id);
							// obj.setVisible(true);
							// dispose();
							break;
						}

					}
					// budgetupdate2 obj=new budgetupdate2(id);
					// obj.setVisible(true);
					// dispose();
					if (checkit == 1) {
						gui.msg_gui.update_failed_msgg jj = new gui.msg_gui.update_failed_msgg();
						jj.setVisible(true);

					} else {

						// year=textField.getText();

						// req=t5.getText();

						// asp=t3.getText();
						// issue=t6.getText();

						// sdate=t2.getText();
						// type=(String) t11.getSelectedItem();

						String ss = (String) t11.getSelectedItem();
						if (ss.contains("fall")) {
							type = (String) t11.getSelectedItem();

						} else if (ss.contains("spring")) {
							type = (String) t11.getSelectedItem();

						} else {

							checktype = 1;

						}

						if (checktype == 0) {

							budgetalgo salaryobj = new budgetalgo();
							salaryobj.Insert_frame(1, framea);

							// mail owner=new
							// mail("fastlms1234@gmail.com","Budget for is issued successfully");
							// mail librarian=new
							// mail("F128067@nu.edu.pk","Budget for Year "+id+" and Semester "+type+" is issued. The amount is  "+issue+"  rupees.");

							dispose();
							gui.msg_gui.Insert_msgg ii = new gui.msg_gui.Insert_msgg();
							ii.setVisible(true);

						} else if (checktype == 2) {
							gui.msg_gui.capital_letter_msg msg = new gui.msg_gui.capital_letter_msg();
							msg.setVisible(true);
							lblNewLabel_3.setForeground(Color.RED);
						} else {

							gui.msg_gui.Empty_MSG jj = new gui.msg_gui.Empty_MSG();
							jj.setVisible(true);
						}

					}
				}

				else if (check == 4) {
					if (textField.getText().length() != 4) {
						gui.msg_gui.textlength tx = new gui.msg_gui.textlength();
						tx.setVisible(true);
						lblIdyear.setForeground(Color.RED);
					}
				}

				else {
					// lblIdyear
					// lblNewLabel_3
					// lblNewLabel_5
					// lblNewLabel_2
					// lblNewLabel_4
					//

					System.out.println("else part");

					gui.msg_gui.Empty_MSG jj = new gui.msg_gui.Empty_MSG();
					jj.setVisible(true);

					if (sdate.isEmpty()) {
						lblIssueDate.setForeground(Color.RED);
					} else {
						lblIssueDate.setForeground(Color.BLACK);
					}
					if (issue.isEmpty()) {
						lblNewLabel_5.setForeground(Color.RED);
					} else {
						lblNewLabel_5.setForeground(Color.BLACK);
					}

					if (year.isEmpty()) {

						lblIdyear.setForeground(Color.RED);
					} else {
						lblIdyear.setForeground(Color.BLACK);
					}

					if (type.isEmpty()) {
						System.out.println("tttttttttttype=" + type);
						lblNewLabel_3.setForeground(Color.RED);
					} else {
						lblNewLabel_3.setForeground(Color.BLACK);

					}
					if (req.isEmpty()) {
						lblNewLabel_4.setForeground(Color.RED);
					} else {
						lblNewLabel_4.setForeground(Color.BLACK);
					}
					if (asp.isEmpty()) {
						lblNewLabel_2.setForeground(Color.RED);
					} else {
						lblNewLabel_2.setForeground(Color.BLACK);
					}

					// lblSemesterType.setForeground(Color.RED);

				}
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnAdd.setBounds(224, 277, 89, 23);
		contentPane.add(btnAdd);

		JButton btnCencel = new JButton("Cancel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnCencel.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnCencel.setForeground(SystemColor.desktop);
		btnCencel.setBounds(332, 277, 89, 23);
		contentPane.add(btnCencel);

		table = new JTable();
		table.setBounds(312, 250, 1, 1);
		contentPane.add(table);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/4.png")).getImage();

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
				DatePicker dp = new DatePicker(t2, locale);// t2 txtfild for
															// date//locale
															// format of date of
															// our regin
				Date selectedDate = dp.parseDate(t2.getText());// casting in
																// Date type
				dp.setSelectedDate(selectedDate);// change colour
				dp.start(t2);

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
		btnNewButton.setBounds(543, 203, 27, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Get");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int nullcheck = 0;
				if (textField.getText().isEmpty()) {
					nullcheck = 5;
				}

				if (nullcheck != 5) {
					year = textField.getText();
					int i = 0;
					algo.librarian_algo algosaaobj = new algo.librarian_algo();

					try {
						java.sql.ResultSet a;
						a = algosaaobj.select();
						while (a.next()) {

							ID[i] = a.getString("Year");

							i++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int checkit = 0;
					for (int j = 0; j < i; j++) {
						if (ID[j].equals(year)) {
							System.out.println("id" + year);
							System.out.println("ID" + ID[j]);
							checkit = 1;
							// dispose();

							ResultSet rs = null;
							algo.librarian_algo alg = new algo.librarian_algo();// ///payroll
																				// se
																				// yahan
																				// values
																				// dalwane...........
							try {
								System.out.println("hellllo");
								rs = alg.querryupdatea(year);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("hellllo");
							try {
								while (rs.next()) {
									System.out.println("hellllo");

									// t1.setText(rs.getString("CS"));
									t5.setText(rs.getString("Requested_Amount"));// /////requested
																					// budget

								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								System.out.println("hellllo");
								e1.printStackTrace();
							}

							// budgetupdate2 obj=new budgetupdate2(id);
							// obj.setVisible(true);
							// dispose();
							break;
						}

					}
					// budgetupdate2 obj=new budgetupdate2(id);
					// obj.setVisible(true);
					// dispose();
					if (checkit == 0) {

						int enterzero = 0;
						String zer;
						zer = Integer.toString(enterzero);
						gui.msg_gui.Msg msg = new gui.msg_gui.Msg();
						msg.setVisible(true);
						t5.setText(zer);

						// update_failed_msg jj=new update_failed_msg ();

					}

				} else {
					gui.msg_gui.update_failed_msgg jj = new gui.msg_gui.update_failed_msgg();
					jj.setVisible(true);
				}

			}
		});
		btnNewButton_1.setBounds(543, 151, 55, 23);
		contentPane.add(btnNewButton_1);

		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double s;
				int nullcheck = 0;
				if (textField.getText().isEmpty()) {
					nullcheck = 5;
				}

				if (nullcheck != 5) {
					// String sss;
					budgetalgo a = new budgetalgo();
					s = a.Exponential_smoothing();
					String sss1 = new Double(s).toString();

					t3.setText(sss1);
				}

				else {

					gui.msg_gui.update_failed_msgg jj = new gui.msg_gui.update_failed_msgg();
					jj.setVisible(true);
				}
			}
		});
		btnGet.setBounds(543, 100, 55, 23);
		contentPane.add(btnGet);

	}
}
