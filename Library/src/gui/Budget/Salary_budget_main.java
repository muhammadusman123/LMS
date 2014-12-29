package gui.Budget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

//import algo.SendEmail;
/**
 * 
 * @author Naveed
 *
 */
public class Salary_budget_main extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary_budget_main frame = new Salary_budget_main();
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
	
	
	public Salary_budget_main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 292);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("FormattedTextField.selectionForeground"));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("  Issue budget");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				//dispose();
				Inset_Salary_budget m=new Inset_Salary_budget();
				m.setVisible(true);
				
				
			}
		});
	

		btnNewButton.setBounds(69, 139, 115, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("  Update");
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				Update1_Salay_Budget dialog = new Update1_Salay_Budget();
				
				dialog.setVisible(true);
				//dispose();
				
			}
		});
		btnNewButton_1.setBounds(229, 138, 115, 28);
		contentPane.add(btnNewButton_1);
		setTitle("Salary Budget");
		JButton btnNewButton_2 = new JButton("View  Report");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\pic\\4444.png"));
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Salary_table obj=new Salary_table();
						obj.setVisible(true);
					//obj.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_2.setBounds(69, 193, 115, 26);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(" Exit");
	
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//MainPage obj=new MainPage();		
				//obj.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_3.setBounds(229, 193, 115, 26);
		contentPane.add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(10, -64, 157, 262);
	//	Image img=new ImageIcon (this.getClass().getResource("/bud.png")).getImage();
	//	label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel lblSalaryBudget = new JLabel("Salary Budget");
		lblSalaryBudget.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalaryBudget.setBounds(146, 44, 178, 33);
		contentPane.add(lblSalaryBudget);
		
		
	
		
		
	}
}
