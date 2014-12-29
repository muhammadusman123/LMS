package gui.Budget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.Salary_algo;
//import algo.alg;
import algo.mail;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//import msg_gui.Empty_MSG;
//import msg_gui.Insert_msgg;
//import msg_gui.Msg;
//import msg_gui.capital_letter_msg;
//import msg_gui.textlength;
//import msg_gui.update_failed_msgg;

import java.awt.Toolkit;
/**
 * 
 * @author Naveed
 *
 */
public class Inset_Salary_budget extends JFrame {

	private JPanel contentPane;
	
	
	private JTextField t1;
	private JTextField t2;
	private ObservingTextField t4;
	
	public String sdate;
	
	public String amount;
	public String Spent;
	public String type;
	public String cur;
	public String spent;
	//public static String []ID=new String[100];
	public static String []ttype=new String[100];
	public static String []yyear=new String[100];
	
	private JTable table;
	public Inset_Salary_budget framea;
	private JTextField t6;
	public String id;
	public String yearr;
	//public int zerr;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inset_Salary_budget frame = new Inset_Salary_budget();
					//frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public Inset_Salary_budget() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		
		framea=this;
		this.id=id;
		//this.zerr=zero;
		
		setTitle("Salary Budget ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNumberOfEmployees = new JLabel("Total of Salaries");
		lblNumberOfEmployees.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNumberOfEmployees.setBounds(276, 162, 124, 14);
		contentPane.add(lblNumberOfEmployees);
		
		final JComboBox t11 = new JComboBox();
		t11.setModel(new DefaultComboBoxModel(new String[] {"fall", "spring"}));
		t11.setBounds(127, 159, 108, 20);
		contentPane.add(t11);
		
		t1 = new JTextField();
		t1.setForeground(Color.BLACK);
		t1.setBackground(Color.WHITE);
		t1.setBounds(395, 111, 108, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		t1.setEditable(false);
		
		t4 = new ObservingTextField();
		t4.setForeground(Color.BLACK);
		t4.setBackground(Color.WHITE);
		t4.setBounds(395, 216, 108, 23);
		contentPane.add(t4);
		t4.setColumns(10);
		t4.setEditable(false);
		
		
		
	
		
		JButton btnPress = new JButton("Get");
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int nullcheck=0;
				if(textField.getText().isEmpty())
				{
					nullcheck=5;
				}
				if(nullcheck!=5)
				{
					
					id=textField.getText();
					int i=0;
					algo.librarian_algo algosaaobj=new algo.librarian_algo();
					
					try {
						java.sql.ResultSet a;
						a=algosaaobj.select();
						while (a.next()) {
							
							yyear[i]=a.getString("Year");
							
							i++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int checkit=0;
					for(int j=0;j<i;j++)
					{
					if(yyear[j].equals(id))
					{
						System.out.println("id" +id);
						System.out.println("ID" +yyear[0]);
						checkit=1;
						//dispose();
						
						ResultSet rs=null;
						algo.librarian_algo alg=new algo.librarian_algo();/////payroll se yahan values dalwane...........
						try {
							System.out.println("hellllo");
							rs=alg.querryupdatea(id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("hellllo");
						try {
							while(rs.next())
							{
								System.out.println("hellllo");
								
								t1.setText(rs.getString("Requested_Amount"));
								//t6.setText(rs.getString("BBA"));
								
								
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("hellllo");
							e1.printStackTrace();
						}
					
						
						//budgetupdate2 obj=new budgetupdate2(id);
						//obj.setVisible(true);
						//dispose();
						break;
					}
				
					
					}
					//budgetupdate2 obj=new budgetupdate2(id);
					//obj.setVisible(true);
					//dispose();
					if(checkit==0)
					{
						int enterzero=0;
						String zer;
						zer=Integer.toString(enterzero);
						gui.msg_gui.Msg msg=new gui.msg_gui.Msg();
						msg.setVisible(true);
						t1.setText(zer);
						
						
						//update_failed_msg jj=new update_failed_msg ();
						//jj.setVisible(true);
					}
							
					
				}
				else
				{
					gui.msg_gui.update_failed_msgg jj=new gui.msg_gui.update_failed_msgg ();
					jj.setVisible(true);
				}
				
				
				
				
				
				
				
				
			}
		});
		btnPress.setBounds(513, 111, 55, 23);
		contentPane.add(btnPress);
		
		final JLabel lblSemesterType = new JLabel("Semester Type");
		lblSemesterType.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblSemesterType.setBounds(21, 162, 93, 14);
		contentPane.add(lblSemesterType);
		
		final JLabel lblEnterId = new JLabel("Year");
		lblEnterId.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblEnterId.setBounds(42, 111, 74, 14);
		contentPane.add(lblEnterId);
		
		JLabel lblAmount = new JLabel(" Salary Budget Issuance");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(193, 11, 412, 36);
		contentPane.add(lblAmount);
		
		final JLabel lblAmount_1 = new JLabel("Issue Amount");
		lblAmount_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblAmount_1.setBounds(28, 220, 86, 14);
		contentPane.add(lblAmount_1);
		
		t2 = new JTextField();
		t2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				 char cha = e.getKeyChar();
			      if (!((cha >= '0') && (cha <= '9') ||(cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			      if(t2.getText().length()>8)
				    {
					 getToolkit().beep();
				      e.consume();
				    }
			
			}
		});
		t2.setBounds(127, 217, 108, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		//alg a=new alg();
		//a.fun53(t2);
		
		final JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIssueDate.setBounds(293, 220, 74, 14);
		contentPane.add(lblIssueDate);
		
		final JLabel lblRequestedAmount = new JLabel("Requested Amount");
		lblRequestedAmount.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblRequestedAmount.setBounds(269, 115, 131, 14);
		contentPane.add(lblRequestedAmount);
		
		textField = new JTextField();
		
			
	
			
			
	
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			
				 char cha = arg0.getKeyChar();
				 int count=0;
			      if (!((cha >= '0') && (cha <= '9') ||(cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        arg0.consume();
			      }
				 if(textField.getText().length()>3)
				    {
					getToolkit().beep();
				      arg0.consume();
				    }
			
			}
		});
		textField.setBounds(127, 108, 108, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		t6 = new JTextField();
		t6.setForeground(Color.BLACK);
		t6.setBackground(Color.WHITE);
		t6.setBounds(395, 158, 108, 23);
		contentPane.add(t6);
		t6.setColumns(10);
		t6.setEditable(false);
		
		
		
		
		
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String total;
				String req;
				int checktype=0;
				int check=0;
				
				//s=t3.getText();	
				sdate=t4.getText();
				
				amount=t2.getText();

				yearr=textField.getText();
				
				
				
			
			//	type=t5.getText();
				
				type=(String) t11.getSelectedItem();
				total=t6.getText();
				req=t1.getText();
				
				
				System.out.println("type="+type);
				System.out.println("s="+sdate);
				System.out.println("amount="+amount);
				System.out.println("year="+yearr);
				System.out.println("total="+total);
				System.out.println("req="+req);
				
			//	type="";
				System.out.println("type="+type);
				if(sdate.isEmpty()||amount.isEmpty()||yearr.isEmpty()||total.isEmpty()||req.isEmpty())
				{
					check=0;
					System.out.println("if");	
				}
				else if(textField.getText().length()!=4)
				{
					
					check=4;
					
				}
				else
				{System.out.println("else");
					check=1;
					
				}
				
				
				
				
				System.out.println("this chek....="+check);
				
				if(check==1)
				{
					
					System.out.println("....................................");


					//yearr=textField.getText();
					type=(String) t11.getSelectedItem();//t5.getText();
					yearr=textField.getText();
					int i=0;
					algo.Salary_algo algosaaobj=new algo.Salary_algo();
					
					try {
						java.sql.ResultSet a;
						a=algosaaobj.select();
						while (a.next()) {
							
							yyear[i]=a.getString("Year");
							ttype[i]=a.getString("Semester_Type");
							
							i++;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int checkit=0;
					for(int j=0;j<i;j++)
					{
					if(yyear[j].equals(yearr) && ttype[j].equals(type) )
					{
						System.out.println("yearr=" +yearr);
						System.out.println("yyear=" +yyear[j]);
						System.out.println("type=" +type);
						System.out.println("ttype=" +ttype[j]);
						checkit=1;
						//dispose();
						
						
						//Update_Salary_Budget obj=new Update_Salary_Budget(id);
						//obj.setVisible(true);
						//dispose();
						break;
					}
				
					
					}
					//budgetupdate2 obj=new budgetupdate2(id);
					//obj.setVisible(true);
					//dispose();
					if(checkit==1)
					{
						gui.msg_gui.update_failed_msgg jj=new gui.msg_gui.update_failed_msgg ();
						jj.setVisible(true);
						
					}
					else
					{
					
					
					
					
					
					
					
						
					

					
					
					
					sdate=t4.getText();	
				amount=t2.getText();

				yearr=textField.getText();
				cur=amount;
				spent="0";
				
				
				String ss=(String) t11.getSelectedItem();
				System.out.println(ss);
				
				if(ss.contains("fall"))
				{
				//type=(String) t11.getSelectedItem();
				//lblSemesterType.setForeground(Color.BLACK);
				}
				else if(ss.contains("spring"))
				{
					//type=(String) t11.getSelectedItem();
				}
				else
				{	
					//
					checktype=1;
					//type=" ";
				//	lblSemesterType.setForeground(Color.RED);
					
					//budget_error_msg err=new budget_error_msg();
					//err.setVisible(true);
				}	
				
				//System.out.println(t5.getText());
				
				if(checktype==0)
				{
				
				Salary_algo salaryobj=new Salary_algo();
				salaryobj.Insert_frame(1, framea);
				
				//mail owner=new mail("fastlms1234@gmail.com","Salary Budget is issued successfully");
				//mail librarian=new mail("F128067@nu.edu.pk","Budget for Year "+yearr+" and Semester "+type+" is issued. The amount is  "+amount+"  rupees.");
				
				dispose();		 
				gui.msg_gui.Insert_msgg ii=new gui.msg_gui.Insert_msgg();
				ii.setVisible(true);
				
				
			
				
				}
				else if(checktype==2)
				{
					gui.msg_gui.capital_letter_msg msg=new gui.msg_gui.capital_letter_msg();
					msg.setVisible(true);
					lblSemesterType.setForeground(Color.RED);
				}
				else
				{
					
					gui.msg_gui.Empty_MSG jj=new gui.msg_gui.Empty_MSG ();
					jj.setVisible(true);
				}
					
					
					}
					
					
					
					
					
					
					
					
					
					
					
				
							
				

					
					
					
					

					
					
					
					
					
				}
				else if(check==4)
				{
					if(textField.getText().length()!=4)
					{
						gui.msg_gui.textlength tx=new gui.msg_gui.textlength();
					tx.setVisible(true);
					lblEnterId.setForeground(Color.RED);
					}
				}
				else
				{
					
					System.out.println("else part");
					
					gui.msg_gui.Empty_MSG jj=new gui.msg_gui.Empty_MSG ();
					jj.setVisible(true);
					
					
					if(sdate.isEmpty())
					{
						lblIssueDate.setForeground(Color.RED);
					}
					else
					{
						lblIssueDate.setForeground(Color.BLACK);
					}
					if(amount.isEmpty())
					{
						lblAmount_1.setForeground(Color.RED);
					}
					else
					{
						lblAmount_1.setForeground(Color.BLACK);
					}

				if(yearr.isEmpty())
	    			{
					
					lblEnterId.setForeground(Color.RED);
					}
				else
				{
					lblEnterId.setForeground(Color.BLACK);
				}
				
					if(type.isEmpty())
					{
						System.out.println("tttttttttttype="+type);
						lblSemesterType.setForeground(Color.RED);
					}
					else
					{
						lblSemesterType.setForeground(Color.BLACK);
						
					}
					if(total.isEmpty())
					{
						lblNumberOfEmployees.setForeground(Color.RED);
					}
					else
					{
						lblNumberOfEmployees.setForeground(Color.BLACK);
					}
					if(req.isEmpty())
					{
						lblRequestedAmount.setForeground(Color.RED);
					}
					else
					{
						lblRequestedAmount.setForeground(Color.BLACK);
					}
				
					//lblSemesterType.setForeground(Color.RED);	
				
				
				}
							
			
			}
		});
		btnInsert.setBounds(178, 289, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(292, 289, 89, 23);
		contentPane.add(btnCencel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\6666.png"));
		//btnNewButton.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lang=null;
				final Locale locale = getLocale(lang);
				DatePicker dp=new DatePicker(t4,locale);//t2 txtfild for date//locale format of date of our regin
				Date selectedDate=dp.parseDate(t4.getText());//casting in Date type
				dp.setSelectedDate(selectedDate);//change colour
				dp.start(t4);
			
			
			}
			public Locale getLocale(String loc)//function in library 
			{
				if(loc!=null && loc.length()>0)
				{
					return new Locale(loc);
				
				}
				else
				{
					return Locale.US;
				}
			}
		
		
		
		
		});
		btnNewButton.setBounds(503, 216, 27, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int nullcheck=0;
				if(textField.getText().isEmpty())
				{
					nullcheck=5;
				}
				
				if(nullcheck!=5)
				{
				id=textField.getText();
				type=(String) t11.getSelectedItem();;
				int i=0;
				algo.librarian_algo algosaaobj=new algo.librarian_algo();
				
				try {
					java.sql.ResultSet a;
					a=algosaaobj.select();
					while (a.next()) {
						
						yyear[i]=a.getString("Year");
						
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int checkit=0;
				for(int j=0;j<i;j++)
				{
				if(yyear[j].equals(id))
				{
					System.out.println("id" +id);
					System.out.println("ID" +yyear[0]);
					checkit=1;
					//dispose();
					
					ResultSet rs=null;
					algo.librarian_algo alg=new algo.librarian_algo();/////payroll se yahan values dalwane...........
					try {
						System.out.println("hellllo");
						rs=alg.querryupdatea(id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("hellllo");
					try {
						while(rs.next())
						{
							System.out.println("hellllo");
							
							//t1.setText(rs.getString("CS"));
							t6.setText(rs.getString("total_of_salaries"));
							
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("hellllo");
						e1.printStackTrace();
					}
				
					
					//budgetupdate2 obj=new budgetupdate2(id);
					//obj.setVisible(true);
					//dispose();
					break;
				}
			
				
				}
				//budgetupdate2 obj=new budgetupdate2(id);
				//obj.setVisible(true);
				//dispose();
				if(checkit==0)
				{
					
					int enterzero=0;
					String zer;
					zer=Integer.toString(enterzero);
					gui.msg_gui.Msg msg=new gui.msg_gui.Msg();
					msg.setVisible(true);
					t6.setText(zer);
				}
				
			}
				else
				{
					gui.msg_gui.update_failed_msgg jj=new gui.msg_gui.update_failed_msgg ();
					jj.setVisible(true);
				}
				
			}
		});
		btnGet.setBounds(513, 158, 55, 23);
		contentPane.add(btnGet);
		
	
		
	
		
		
		
		
	}
}
