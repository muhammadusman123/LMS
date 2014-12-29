package te;

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
public class budgetreport extends JFrame {

	private JPanel contentPane;
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
	public budgetreport framea;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetreport frame = new budgetreport();
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
	public budgetreport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));

		framea = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 281);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(" Purchase Budget Report Window");

		JLabel label_1 = new JLabel("");
		label_1.setBounds(375, 0, 46, 55);
		// Image imge=new ImageIcon
		// (this.getClass().getResource("/1013.png")).getImage();
		// label_1.setIcon(new ImageIcon(imge));
		contentPane.add(label_1);
		// a.fun41(t6);

		final JLabel lblIdyear = new JLabel("Year");
		lblIdyear.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		lblIdyear.setBounds(52, 104, 73, 14);
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
		lblSalaryBudget.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		lblSalaryBudget.setBounds(202, 11, 412, 36);
		contentPane.add(lblSalaryBudget);

		JButton btnAdd = new JButton("Report");
		// btnAdd.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\1111.png"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String year = textField.getText();
				int counter = 0;
				String query = "SELECT * FROM `budget` ";
				String yearto = textField_1.getText();
				if (!year.equals("") && counter == 0) {
					query += " where `Year` >='" + year + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!year.equals("") && counter != 0) {
					query += " AND `Year` >='" + year + "'";
					counter = 1;
				}

				if (!yearto.equals("") && counter == 0) {
					query += " where `Year` <='" + yearto + "'";
					counter = 1;
					System.out.println("I am in isbn");
				} else if (!yearto.equals("") && counter != 0) {
					query += " AND `Year` <='" + yearto + "'";
					counter = 1;
				}
				budget ma = new budget();
				ma.initConnection();
				try {
					ma.showReport(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnAdd.setBounds(186, 178, 89, 23);
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
		btnCencel.setBounds(312, 178, 89, 23);
		contentPane.add(btnCencel);

		table = new JTable();
		table.setBounds(312, 250, 1, 1);
		contentPane.add(table);

		JLabel label = new JLabel("Year");
		label.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		label.setBounds(294, 104, 46, 14);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(360, 96, 108, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	}
}
