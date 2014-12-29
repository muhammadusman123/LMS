package gui.Budget;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
/**
 * 
 * @author Naveed
 *
 */
public class Main_BUDGET extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_BUDGET frame = new Main_BUDGET();
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
	public Main_BUDGET() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		setTitle("Main Budget Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSalaries = new JButton("Salary Budget");
		btnSalaries.setBounds(86, 132, 116, 26);
		btnSalaries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Salary_budget_main frame = new Salary_budget_main();
				frame.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSalaries);
		
		JButton btnBooks = new JButton("Purchase Budget");
		btnBooks.setBounds(222, 132, 116, 26);
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				budgetmain frame = new budgetmain();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnBooks);
		
		JLabel lblBudgetCetacories = new JLabel("LMS Budget");
		lblBudgetCetacories.setBounds(136, 29, 202, 42);
		lblBudgetCetacories.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblBudgetCetacories);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(164, 202, 110, 26);
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			dispose();
			}
		});
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 116, 110);
		//Image img=new ImageIcon (this.getClass().getResource("/bud.png")).getImage();
		//label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("___________\r\n");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(136, 29, 157, 54);
		contentPane.add(label_1);
		
		
	}
}
