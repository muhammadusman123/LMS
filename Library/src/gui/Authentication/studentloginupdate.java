package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import algo.loginalgo;
import algo.textvalidation;
import java.awt.Font;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentloginupdate extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	protected JTextComponent textField_2;
	protected studentloginupdate framea;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentloginupdate frame = new studentloginupdate();
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
	public studentloginupdate() {
		framea = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Update Form");
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(198, 42, 129, 20);
		contentPane.add(textField);
		JLabel lblUserPassword = new JLabel("User Password");
		lblUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserPassword.setBounds(44, 45, 115, 14);
		contentPane.add(lblUserPassword);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textvalidation valobj = new textvalidation();
				if (valobj.fun(textField.getText())) {
					Display obj = new Display("Password not Entered");
					obj.setVisible(true);
				} else {
					algo.loginalgo algosaaobj = new algo.loginalgo();
					try {
						algosaaobj.updateb(loginalgo.username,
								textField.getText());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
			}
		});
		btnUpdate.setBounds(174, 105, 89, 23);
		contentPane.add(btnUpdate);
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 0, 0));
		btnClose.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(302, 105, 89, 23);
		contentPane.add(btnClose);
		JButton btnNewButton = new JButton("View");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				algo.loginalgo algosaaobj = new algo.loginalgo();
				System.out.println();
				try {
					ResultSet a;
					a = algosaaobj.updatea(loginalgo.username);
					while (a.next()) {
						textField.setText(a.getString("User_pswd"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(31, 102, 115, 29);
		contentPane.add(btnNewButton);
	}
}
