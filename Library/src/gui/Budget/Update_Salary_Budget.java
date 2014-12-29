package gui.Budget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.mail;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import gui.msg_gui.*;
//import msg_gui.Msg;
//import msg_gui.textlength;
//import msg_gui.update_failed_msgg;
//import msg_gui.updated_msgg;

import java.awt.Toolkit;
/**
 * 
 * @author Naveed
 *
 */
public class Update_Salary_Budget extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;	
	private ObservingTextField t11;
	
	public String sdate;
	public String amount;
	public String id;
	public String yearr;
	public String type;
	public String getyear;
	
	
	private JTable table;
	public Update_Salary_Budget framea;
	public Update_Salary_Budget frame;
	private JTextField t6;
	//public static String []ID=new String[100];
	public static String []yyear=new String[100];
	public static String []ttype=new String[100];
	
	private JTextField t7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Salary_Budget frame = new Update_Salary_Budget("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id 
	 */
	public Update_Salary_Budget(final String id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		framea=this;
		frame=this;
		this.id=id;
		
		setTitle("Salary Budget ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNumberOfEmployees = new JLabel("Total of Salaries");
		lblNumberOfEmployees.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblNumberOfEmployees.setBounds(270, 111, 124, 14);
		contentPane.add(lblNumberOfEmployees);
		
		final JComboBox t111 = new JComboBox();
		t111.setEnabled(false);
		t111.setModel(new DefaultComboBoxModel(new String[] {"fall", "spring"}));
		t111.setBounds(127, 168, 108, 20);
		contentPane.add(t111);
		
		t1 = new JTextField();
		t1.setBackground(SystemColor.window);
		t1.setBounds(382, 107, 108, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		t1.setEditable(false);
		
		t11 = new ObservingTextField();
		t11.setBackground(SystemColor.window);
		t11.setBounds(382, 226, 108, 23);
		contentPane.add(t11);
		t11.setColumns(10);
		t11.setEditable(false);
		
		t7 = new JTextField();
		t7.setBackground(Color.WHITE);
		t7.setEditable(false);
		t7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			
				 char cha = arg0.getKeyChar();
				 int count=0;
			      if (!((cha >= '0') && (cha <= '9') ||(cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        arg0.consume();
			      }
				 if(t7.getText().length()>3)
				    {
					getToolkit().beep();
				      arg0.consume();
				    }
			
			
			
			}
		});
		t7.setBounds(127, 107, 108, 23);
		contentPane.add(t7);
		t7.setColumns(10);
		
		final JLabel lblRequested = new JLabel("Requested");
		lblRequested.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblRequested.setBounds(286, 171, 86, 14);
		contentPane.add(lblRequested);
		
		final JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblYear.setBounds(45, 111, 46, 14);
		contentPane.add(lblYear);
		
		final JLabel label = new JLabel("Semester Type");
		label.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		label.setBounds(21, 171, 93, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\6666.png"));
		//btnNewButton.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lang=null;
				final Locale locale = getLocale(lang);
				DatePicker dp=new DatePicker(t11,locale);//t2 txtfild for date//locale format of date of our regin
				Date selectedDate=dp.parseDate(t11.getText());//casting in Date type
				dp.setSelectedDate(selectedDate);//change colour
				dp.start(t11);
			
			
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
		btnNewButton.setBounds(489, 226, 27, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnPress = new JButton("Get");
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				getyear=t7.getText();
				System.out.println("yearid");
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
				if(yyear[j].equals(getyear))
				{
					System.out.println("id" +id);
					System.out.println("ID" +yyear[0]);
					checkit=1;
					//dispose();
					
					ResultSet rs=null;
					algo.librarian_algo alg=new algo.librarian_algo();/////payroll se yahan values dalwane...........
					try {
						System.out.println("hellllo");
						rs=alg.querryupdatea(getyear);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("hellllo");
					try {
						while(rs.next())
						{
							System.out.println("hellllo");
							
							t1.setText(rs.getString("total_of_salaries"));
							//t6.setText(rs.getString("BBA"));
							
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("hellllo");
						e1.printStackTrace();
					}
				
					
					
					break;
				}
			
				
				}
				
				if(checkit==0)
				{
					
					
						int enterzero=0;
						String zer;
						zer=Integer.toString(enterzero);
						Msg msg=new Msg();
						msg.setVisible(true);
						t1.setText(zer);
						
						
						//update_failed_msg jj=new update_failed_msg ();
						//jj.setVisible(true);
					
				}
				
				
				
				
				
			
			
			}
		});
		btnPress.setBounds(500, 107, 55, 23);
		contentPane.add(btnPress);
		
		JLabel lblAmount = new JLabel("Update Salary Budget");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(194, 25, 412, 36);
		contentPane.add(lblAmount);
		
		final JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIssueDate.setBounds(298, 230, 74, 14);
		contentPane.add(lblIssueDate);
		
		final JLabel lblAmount_2 = new JLabel("Issue Amount");
		lblAmount_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblAmount_2.setBounds(20, 235, 86, 14);
		contentPane.add(lblAmount_2);
		
		
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
		t2.setBounds(127, 226, 108, 23);
		contentPane.add(t2);
		t2.setColumns(10);
		
		
		
		ResultSet rs=null;
		algo.Salary_algo alg=new algo.Salary_algo();
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
				//System.out.println(rs.getString("Type"));
				
				//System.out.println(rs.getString("Semester_Type"));
				System.out.println(".......................");
				type=rs.getString("Semester_Type");
				yearr=rs.getString("Year");
				
				
				System.out.println(yearr);
				System.out.println(type);
				
				
				t2.setText(rs.getString("Allocated"));
				t11.setText(rs.getString("Issue_Date"));
				t7.setText(yearr);
				t111.setSelectedItem(type);
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("hellllo");
			e1.printStackTrace();
		}
		
		
		
		
		
		JButton btnInsert = new JButton("Update");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int checktype=0;
				int check=0;	
				String total,req;
				
				type=(String) t111.getSelectedItem();//t8.getText();
				//yearr=t7.getText();
				//s=t3.getText();
				sdate=t11.getText();
				
				
				amount=t2.getText();
				yearr=t7.getText();
				
				total=t1.getText();
				req=t6.getText();
				
				
				System.out.println("type="+type);
				if(sdate.isEmpty()||amount.isEmpty()||yearr.isEmpty()||total.isEmpty()||req.isEmpty())
				{
					check=0;
					System.out.println("if");	
				}
				else if(t7.getText().length()!=4)
				{
					
					check=4;
					
				}
				else
				{System.out.println("else");
					check=1;
					
				}
				
				
				if(check==1)
				{
					
					
				
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
					checkit=2;
					//dispose();
					
					
					//Update_Salary_Budget obj=new Update_Salary_Budget(id);
					//obj.setVisible(true);
					//dispose();
					break;
				}
			
				
				}
				if(checkit==1)
				{
					update_failed_msgg jj=new update_failed_msgg ();
					jj.setVisible(true);
					
				}
				else
				{
				//budgetupdate2 obj=new budgetupdate2(id);
				//obj.setVisible(true);
				//dispose();
				
				
				
				

					//s=t3.getText();
				sdate=t11.getText();
					amount=t2.getText();
					yearr=t7.getText();
					
				
					String ss=(String) t111.getSelectedItem();
				
					if(ss.contains("fall"))
					{
						//type=(String) t111.getSelectedItem();;
					//	lblSemesterType.setForeground(Color.BLACK);
					}
					else if(ss.contains("spring"))
					{
						//type=(String) t111.getSelectedItem();
					//	lblSemesterType.setForeground(Color.BLACK);
					}
					else
					{	
						
						
						checktype=1;
						
					//	lblSemesterType.setForeground(Color.RED);
						
						//budget_error_msg err=new budget_error_msg();
						//err.setVisible(true);
					}	
					
					if(checktype==0)
					{
					//System.out.println("gui started");
					algo.Salary_algo budgetobj=new algo.Salary_algo();


					budgetobj.Update(1,framea);
					
					//mail owner=new mail("fastlms1234@gmail.com","Salary Budget is updated successfully");
					//mail librarian=new mail("F128067@nu.edu.pk","Budget for Year "+yearr+" and Semester "+type+" is updated. The amount is  "+amount+"  rupees.");
					

					updated_msgg m= new updated_msgg();
					m.setVisible(true);
					dispose();
					
					
					
				
					}
					else
					{
						
						Empty_MSG jj=new Empty_MSG ();
						jj.setVisible(true);
					}
				}
				}
				else if(check==4)
				{
					if(t7.getText().length()!=4)
					{
					textlength tx=new textlength();
					tx.setVisible(true);
					lblYear.setForeground(Color.RED);
					}
				}
				else
				{
System.out.println("else part");
					
					Empty_MSG jj=new Empty_MSG ();
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
						lblAmount_2.setForeground(Color.RED);
					}
					else
					{
						lblAmount_2.setForeground(Color.BLACK);
					}

				if(yearr.isEmpty())
	    			{
					
					lblYear.setForeground(Color.RED);
					}
				else
				{
					lblYear.setForeground(Color.BLACK);
				}
				
					if(type.isEmpty())
					{
						System.out.println("tttttttttttype="+type);
						label.setForeground(Color.RED);
					}
					else
					{
						label.setForeground(Color.BLACK);
						
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
						lblRequested.setForeground(Color.RED);
					}
					else
					{
						lblRequested.setForeground(Color.BLACK);
					}
				
					//lblSemesterType.setForeground(Color.RED);	
				
					
					
					
				}
				

				
				
			

			
				
				
				
				
				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			
			
			
			
			}
		});
		btnInsert.setBounds(185, 291, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnCencel = new JButton("Cancel");
		btnCencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnCencel.setBounds(305, 291, 89, 23);
		contentPane.add(btnCencel);
		
		
		
		t6 = new JTextField();
		t6.setBackground(SystemColor.window);
		t6.setBounds(382, 164, 108, 23);
		contentPane.add(t6);
		t6.setColumns(10);
		t6.setEditable(false);
		
		
		
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				//id=t.getText();
				//type=t5.getText();
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
				if(yyear[j].equals(getyear))
				{
					System.out.println("id" +id);
					System.out.println("ID" +yyear[0]);
					checkit=1;
					//dispose();
					
					ResultSet rs=null;
					algo.librarian_algo alg=new algo.librarian_algo();/////payroll se yahan values dalwane...........
					try {
						System.out.println("hellllo");
						rs=alg.querryupdatea(getyear);
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
							t6.setText(rs.getString("Requested_Amount"));
							
							
							
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
						Msg msg=new Msg();
						msg.setVisible(true);
						t6.setText(zer);
						
						
						//update_failed_msg jj=new update_failed_msg ();
						//jj.setVisible(true);
					
				}
				
				
			
			}
		});
		btnGet.setBounds(500, 164, 55, 23);
		contentPane.add(btnGet);
		
		
		
	
		
		
	}
}
