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
import java.awt.Font;
import javax.swing.UIManager;
import algo.textvalidation;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class loginupdate2 extends JFrame {
	private JPanel contentPane;
	public static JTextField textField;
	protected JTextComponent textField_2;
	protected loginupdate2 framea;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public String id;
			@Override
			public void run() {
				try {
					loginupdate2 frame = new loginupdate2(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public loginupdate2(final String id) throws SQLException {
		framea = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 190);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Update Form");
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(234, 39, 106, 20);
		contentPane.add(textField);
		JLabel lblUserPassword = new JLabel("User Password");
		lblUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserPassword.setBounds(71, 41, 112, 14);
		contentPane.add(lblUserPassword);
		ResultSet rs;
		algo.loginalgo alg = new algo.loginalgo();
		rs = alg.updatea(id);
		try {
			while (rs.next()) {
				loginupdate2.textField.setText(rs.getString("User_pswd"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
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
						algosaaobj.updateb(id, textField.getText());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					Display disp = new Display(
							"Record has been Successfully Updated");
					disp.setVisible(true);
					dispose();
					dispose();
				}
			}
		});
		btnUpdate.setBounds(94, 106, 89, 23);
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
		btnClose.setBounds(232, 106, 89, 23);
		contentPane.add(btnClose);
	}
}