package gui.Budget;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;




















import algo.DatePicker;
import algo.ObservingTextField;
//import algo.alg;
import algo.budgetalgo;
import algo.mail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//import msg_gui.Empty_MSG;
//import msg_gui.capital_letter_msg;
//import msg_gui.textlength;
//import msg_gui.update_failed_msgg;
//import msg_gui.updated_msgg;
/**
 * 
 * @author Naveed
 *
 */
public class budgetupdate2 extends JFrame {

	private JPanel contentPane;
	private ObservingTextField t2;
	private JTextField t3;
	private JTextField t5;
	private JTextField t6;
	private JTable table;
	public budgetupdate2 framea;
	//public String a;
	public String sdate;
	public String CS;
	public String EE;
	public String BBA;
	public String HR;
	public String req;
	public String asp;
	public String issue_amount;
	public String type;
	public String year;
	public String equip;
	public static String []ttype=new String[100];
	public static String []yyear=new String[100];
	public String bill;
	public budgetupdate2 frame;
	public String id;
	private JTextField t8;
	//public static String []ID=new String[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetupdate2 frame = new budgetupdate2("");
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
	public budgetupdate2(String id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		framea=this;
		frame=this;
		this.id=id;
		System.out.println("id========="+id);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Update Budget");
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel);
		
		final JComboBox t11 = new JComboBox();
		t11.setEnabled(false);
		t11.setModel(new DefaultComboBoxModel(new String[] {"fall", "spring"}));
		t11.setBounds(125, 148, 108, 20);
		panel.add(t11);

		final JLabel lblSpectedAmount = new JLabel("Aspected Amount");
		lblSpectedAmount.setForeground(Color.BLACK);
		lblSpectedAmount.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblSpectedAmount.setBounds(272, 95, 101, 14);
		panel.add(lblSpectedAmount);

		final JLabel lblSemesterType = new JLabel("Semester Type");
		lblSemesterType.setForeground(Color.BLACK);
		lblSemesterType.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblSemesterType.setBounds(14, 151, 116, 14);
		panel.add(lblSemesterType);

		final JLabel lblIssued = new JLabel("Issued Amount");
		lblIssued.setForeground(Color.BLACK);
		lblIssued.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIssued.setBounds(14, 215, 101, 14);
		panel.add(lblIssued);

		final JLabel lblRequested = new JLabel("Requested Amount");
		lblRequested.setForeground(Color.BLACK);
		lblRequested.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblRequested.setBounds(272, 151, 119, 14);
		panel.add(lblRequested);

		t2 = new ObservingTextField();
		t2.setBackground(SystemColor.window);
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(401, 212, 108, 23);
		panel.add(t2);
		//alg a=new alg();
		//a.fun37(t2);

		t3 = new JTextField();
		t3.setBackground(SystemColor.window);
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(401, 92, 108, 23);
		panel.add(t3);
		//a.fun38(t3);

		t5 = new JTextField();
		t5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				 char cha = e.getKeyChar();
			      if (!((cha >= '0') && (cha <= '9') ||(cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			      if(t5.getText().length()>8)
				    {
					 getToolkit().beep();
				      e.consume();
				    }
			
			}
		});
		t5.setColumns(10);
		t5.setBounds(125, 211, 108, 23);
		panel.add(t5);
		//a.fun40(t5);

		t6 = new JTextField();
		t6.setBackground(SystemColor.window);
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBounds(401, 148, 108, 23);
		panel.add(t6);
		//a.fun41(t6);
		
		final JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblIssueDate.setBounds(310, 211, 63, 24);
		panel.add(lblIssueDate);
		
	
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(220, 0, 46, 49);
		//Image imge=new ImageIcon (this.getClass().getResource("/1013.png")).getImage();
		//label_1.setIcon(new ImageIcon(imge));
		panel.add(label_1);
		
		JLabel lblBudget = new JLabel("Purchase Budget");
		lblBudget.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblBudget.setBounds(220, 13, 412, 36);
		panel.add(lblBudget);
		
		final JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		lblYear.setBounds(41, 96, 46, 14);
		panel.add(lblYear);
		
		t8 = new JTextField();
		t8.setBackground(Color.WHITE);
		t8.setEditable(false);
		t8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				 char cha = e.getKeyChar();
				 int count=0;
			      if (!((cha >= '0') && (cha <= '9') ||(cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
				 if(t8.getText().length()>3)
				    {
					getToolkit().beep();
				      e.consume();
				    }
			}
		});
		t8.setBounds(125, 91, 108, 23);
		panel.add(t8);
		t8.setColumns(10);
		
		
		ResultSet rs=null;
		algo.budgetalgo alg=new algo.budgetalgo();
		try {
			rs=alg.querryupdatea(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rs.next())
			{
				t2.setText(rs.getString("Issue_Date"));
				t3.setText(rs.getString("Aspected_Amount"));
				t11.setSelectedItem(rs.getString("Semester_Type"));
				t5.setText(rs.getString("Issued_Amount"));
				t6.setText(rs.getString("Requested_Amount"));
				t8.setText(rs.getString("Year"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnCancel.setForeground(SystemColor.desktop);
		btnCancel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnCancel.setBounds(290, 290, 101, 23);
		panel.add(btnCancel);

		table = new JTable();
		table.setBounds(312, 250, 1, 1);
		panel.add(table);

		JButton btnUpdate = new JButton("  Update");
		//btnUpdate.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\5555.png"));
		btnUpdate.addActionListener(new ActionListener() {


			//framea=this;
			public void actionPerformed(ActionEvent arg0) {

				int checktype=0;
				int check=0;
				//t1.setText(t2.getText());
				/////for date
				
				CS="0";
				EE="0";
				BBA="0";
				HR="0";
				equip="0";
				bill="0";
				
				sdate=t2.getText();
				 req=t6.getText();
				 asp=t3.getText();
				 issue_amount=t5.getText();
				 type=(String) t11.getSelectedItem();
				 year=t8.getText();
				 
				 
				 if(year.isEmpty()||req.isEmpty()||asp.isEmpty()||issue_amount.isEmpty()||sdate.isEmpty())
					{
						check=0;
						System.out.println("if");	
					}
					else
					{System.out.println("else");
						check=1;
						
					}
					System.out.println("this chek....="+check);	 
				 
					if(check==1)
					{		 
						 
						 
						
						
						System.out.println("....................check this................");


						//yearr=textField.getText();
						type=(String) t11.getSelectedItem();
						year=t8.getText();
						int i=0;
						algo.budgetalgo algosaaobj=new algo.budgetalgo();
						
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
						if(yyear[j].equals(year) && ttype[j].equals(type) )
						{
							System.out.println("yearr======" +year);
							System.out.println("yyear=======" +yyear[j]);
							System.out.println("type========" +type);
							System.out.println("ttype=======" +ttype[j]);
							checkit=2;
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
						
						
						
						
						
						
						
							sdate=t2.getText();
							 req=t6.getText();
							 asp=t3.getText();
							 issue_amount=t5.getText();
							 type=(String) t11.getSelectedItem();
							 year=t8.getText();
						
					
					
					
					String ss=(String) t11.getSelectedItem();			
						if(type.contains("fall"))
						{
							//type=(String) t11.getSelectedItem();
						//	lblSemesterType.setForeground(Color.BLACK);
						}
						
						else if(type.contains("spring"))
						{
							//type=(String) t11.getSelectedItem();
						//	lblSemesterType.setForeground(Color.BLACK);
						}
						else
						{	
							
							checktype=1;
							
						}	
						
						
				 if(checktype==0)
				 {
				//System.out.println("gui started");
				algo.budgetalgo budgetobj=new algo.budgetalgo();


				budgetobj.Update(2,framea);

				

				//mail owner=new mail("fastlms1234@gmail.com","Budget is updated successfully");
				//mail librarian=new mail("F128067@nu.edu.pk","Budget for Year "+year+" and Semester "+type+" is updated. The amount is  "+issue_amount+"  rupees.");
				
				
				gui.msg_gui.updated_msgg m= new gui.msg_gui.updated_msgg();
				m.setVisible(true);
				dispose();
				
				
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
						if(t8.getText().length()!=4)
						{
							gui.msg_gui.textlength tx=new gui.msg_gui.textlength();
						tx.setVisible(true);
						lblYear.setForeground(Color.RED);
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
						if(issue_amount.isEmpty())
						{
							lblIssued.setForeground(Color.RED);
						}
						else
						{
							lblIssued.setForeground(Color.BLACK);
						}

					if(year.isEmpty())
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
							lblSemesterType.setForeground(Color.RED);
						}
						else
						{
							lblSemesterType.setForeground(Color.BLACK);
							
						}
						if(req.isEmpty())
						{
							lblRequested.setForeground(Color.RED);
						}
						else
						{
							lblRequested.setForeground(Color.BLACK);
						}
						if(asp.isEmpty())
						{
							lblSpectedAmount.setForeground(Color.RED);
						}
						else
						{
							lblSpectedAmount.setForeground(Color.BLACK);
						}
					
						
						
					}
		
			}
	
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnUpdate.setBounds(165, 290, 101, 23);
		panel.add(btnUpdate);
		//Image img=new ImageIcon (this.getClass().getResource("/4.png")).getImage();
		
		JButton btnIssueDate = new JButton("");
		btnIssueDate.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\project\\Librarian\\6666.png"));
		//btnIssueDate.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnIssueDate.setBackground(SystemColor.menu);
		btnIssueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String lang=null;
				final Locale locale = getLocale(lang);
				DatePicker dp=new DatePicker(t2,locale);
				Date selectedDate=dp.parseDate(t2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(t2);
				
			}
			public Locale getLocale(String loc)
			{
				if(loc!=null && loc.length()>0)
				{
					return new Locale(loc);
				
				}
				else
				{
					return Locale.US;
				}
			}		});
		btnIssueDate.setBounds(507, 212, 27, 23);
		panel.add(btnIssueDate);
		
		
		
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				double s;
				//String sss;
				budgetalgo a=new budgetalgo();
				s=a.Exponential_smoothing();
				String sss1 = new Double(s).toString();
			
				
					t3.setText(sss1);
			
			}
		});
		btnGet.setBounds(519, 92, 55, 23);
		panel.add(btnGet);
		
		JButton btnGet_1 = new JButton("Get");
		btnGet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
				year=t8.getText();
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
				if(yyear[j].equals(year))
				{
					System.out.println("id" +year);
					System.out.println("ID" +yyear[j]);
					checkit=1;
					//dispose();
					
					ResultSet rs=null;
					algo.librarian_algo alg=new algo.librarian_algo();/////payroll se yahan values dalwane...........
					try {
						System.out.println("hellllo");
						rs=alg.querryupdatea(year);
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
							t6.setText(rs.getString("Requested_Amount"));///////requested budget
							
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("hellllo");
						e1.printStackTrace();
					}
				
					
					
					break;
				}
			
				
				}
				
			//	if(checkit==0)
				//{
					
					//update_failed_msg jj=new update_failed_msg ();
				//	jj.setVisible(true);
				//}
				
				
			
			
			
			
			
			}
		});
		btnGet_1.setBounds(519, 148, 55, 23);
		panel.add(btnGet_1);
		
		
		
		
	}
}
