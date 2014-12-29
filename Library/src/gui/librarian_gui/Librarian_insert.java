package gui.librarian_gui;
import gui.msg_gui.Empty_MSG;

import gui.msg_gui.Insert_msgg;
import gui.msg_gui.textlength;
import gui.msg_gui.update_failed_msgg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algo.librarian_algo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.Toolkit;
/**
 * 
 * @author Naveed
 *
 */
public class Librarian_insert extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField t1;
	private JTextField t3;
	public String year;
	public String type;
	public String ReqA;
	public String total;
	public Librarian_insert framea;
	public JComboBox t4;
	public static String[] ttype = new String[100];
	public static String[] yyear = new String[100];
	private JTextField t5;
	private JLabel lblYear;
	private JLabel lblRequestedamount;
	private JLabel lblTotalSalaries;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Librarian_insert dialog = new Librarian_insert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public Librarian_insert() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\abx.png"));
		setTitle("issue request");
		framea = this;
		setBounds(100, 100, 450, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			 lblYear = new JLabel("Year");
			 lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblYear.setBounds(117, 102, 46, 14);
			contentPanel.add(lblYear);
		}
		{
			JLabel lblSemesterType = new JLabel("Semester Type");
			lblSemesterType.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSemesterType.setBounds(99, 144, 111, 23);
			contentPanel.add(lblSemesterType);
		}
		{
			 lblRequestedamount = new JLabel("Requested Amount");
			 lblRequestedamount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRequestedamount.setBounds(99, 196, 129, 14);
			contentPanel.add(lblRequestedamount);
		}
		{
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
			t1.setBounds(232, 98, 108, 23);
			contentPanel.add(t1);
			t1.setColumns(10);
		}
		{
			t4 = new JComboBox();
			t4.setModel(new DefaultComboBoxModel(new String[] { "fall",
					"spring" }));
			t4.setBounds(232, 147, 110, 20);
			contentPanel.add(t4);
		}
		{
			t3 = new JTextField();
			t3.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char cha = e.getKeyChar();
					int count = 0;
					if (!((cha >= '0') && (cha <= '9')
							|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
					if (t3.getText().length() > 8) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			t3.setBounds(234, 192, 108, 23);
			contentPanel.add(t3);
			t3.setColumns(10);
		}
		{
			JLabel label = new JLabel("Request for Budget");
			label.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
			label.setBounds(138, 11, 179, 41);
			contentPanel.add(label);
		}
		{
		 lblTotalSalaries = new JLabel("Total Salaries");
		 lblTotalSalaries.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTotalSalaries.setBounds(117, 244, 111, 14);
			contentPanel.add(lblTotalSalaries);
		}
		{
			JButton btnInsert = new JButton("Insert");
			btnInsert.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					year = t1.getText();
					type = (String) t4.getSelectedItem();
					ReqA = t3.getText();
					total = t5.getText();
					// type=(String) t11.getSelectedItem();//t5.getText();
					// yearr=textField.getText();
					int i = 0;
					algo.librarian_algo algosaaobj = new algo.librarian_algo();
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
							System.out.println("yearr=" + year);
							System.out.println("yyear=" + yyear[j]);
							System.out.println("type=" + type);
							System.out.println("ttype=" + ttype[j]);
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
					if (year.isEmpty() || type.isEmpty() || ReqA.isEmpty()
							|| total.isEmpty()) {
						
						
						
						
						if(year.isEmpty())
						{
							lblYear.setForeground(Color.RED);
						}
						else
						{
							lblYear.setForeground(Color.BLACK);
						}
						if(ReqA.isEmpty())
						{
							lblRequestedamount.setForeground(Color.RED);
						}
						else
						{
							lblRequestedamount.setForeground(Color.BLACK);
						}
						if(total.isEmpty())
						{
							lblTotalSalaries.setForeground(Color.RED);
						}
						else
						{
							lblTotalSalaries.setForeground(Color.BLACK);
						}
						
						
						
						
						
						
						
						Empty_MSG msg = new Empty_MSG();
						msg.setVisible(true);
					} else if (year.length() != 4) {
						textlength le = new textlength();
						le.setVisible(true);
					} else if (checkit == 1) {
						update_failed_msgg jj = new update_failed_msgg();
						jj.setVisible(true);
					} else {
						librarian_algo lb = new librarian_algo();
						lb.Insert_frame(1, framea);
						Insert_msgg msg = new Insert_msgg();
						msg.setVisible(true);
						dispose();
					}
				}
			});
			btnInsert.setBounds(124, 306, 89, 23);
			contentPanel.add(btnInsert);
		}
		{
			JButton btnCence = new JButton("Cencel");
			btnCence.setForeground(Color.RED);
			btnCence.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCence.setBounds(228, 306, 89, 23);
			contentPanel.add(btnCence);
		}
		
		{
			t5 = new JTextField();
			t5.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char cha = e.getKeyChar();
					int count = 0;
					if (!((cha >= '0') && (cha <= '9')
							|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
					if (t5.getText().length() > 8) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			t5.setBounds(234, 240, 108, 23);
			contentPanel.add(t5);
			t5.setColumns(10);
		}
	}
}
