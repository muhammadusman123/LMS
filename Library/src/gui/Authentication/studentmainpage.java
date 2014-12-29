package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentmainpage extends JFrame {
	private JPanel contentPane;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentmainpage frame = new studentmainpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 */
	public studentmainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Student Main Page");
		JButton btnNewButton_8 = new JButton("User Report");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_8.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentloginmain obj = new studentloginmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(131, 38, 152, 29);
		contentPane.add(btnNewButton_8);
		JButton btnNewButton_2 = new JButton("Account Options");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentloginmain obj = new studentloginmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(131, 110, 152, 29);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(131, 179, 152, 29);
		contentPane.add(btnNewButton_3);
	}
}