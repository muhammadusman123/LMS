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
import java.awt.Font;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentloginmain extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentloginmain frame = new studentloginmain();
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
	public studentloginmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Main Form");
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentloginupdate q = new studentloginupdate();
				q.setVisible(true);
			}
		});
		btnUpdate.setBounds(133, 97, 187, 50);
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
		btnReport.setBounds(133, 23, 187, 50);
		contentPane.add(btnReport);
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage obj = new MainPage();
				dispose();
			}
		});
		btnNewButton.setBounds(133, 172, 187, 50);
		contentPane.add(btnNewButton);
	}
}
