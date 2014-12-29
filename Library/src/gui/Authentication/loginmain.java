package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import algo.loginalgo;
import java.awt.Font;
import javax.swing.JLabel;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class loginmain extends JFrame {
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
					loginmain frame = new loginmain();
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
	public loginmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 280);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Main Form");
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logininsertion m = new logininsertion();
				m.setVisible(true);
			}
		});
		btnInsert.setBounds(24, 123, 109, 30);
		contentPane.add(btnInsert);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (loginalgo.logintype.equals("librarian")) {
					studentloginupdate obj = new studentloginupdate();
					obj.setVisible(true);
				} else {
					loginupdate1 obj1 = new loginupdate1();
					obj1.setVisible(true);
				}
			}
		});
		btnUpdate.setBounds(224, 123, 109, 30);
		contentPane.add(btnUpdate);
		JButton btnReport = new JButton("Report");
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loginjtable obj = new loginjtable();
					obj.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnReport.setBounds(24, 195, 109, 30);
		contentPane.add(btnReport);
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage obj = new MainPage();
				dispose();
			}
		});
		btnNewButton.setBounds(224, 195, 109, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblLmsLogin = new JLabel("LMS Login");
		lblLmsLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsLogin.setBounds(106, 11, 145, 43);
		contentPane.add(lblLmsLogin);
		
		JLabel label = new JLabel("__________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(95, 11, 157, 54);
		contentPane.add(label);
	}
}
