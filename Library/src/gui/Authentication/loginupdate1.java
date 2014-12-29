package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import algo.loginalgo;

//import com.mysql.jdbc.ResultSet;


import algo.textvalidation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import database.alg;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class loginupdate1 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public String id;
	public loginupdate1 frame;
	private JTextField textField;
	/**
	 * 
	 */
	public loginupdate1() {
		setBounds(100, 100, 433, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Login Update1 Form");
		JLabel lblStudentid = new JLabel("User Name");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentid.setBounds(83, 40, 86, 14);
		contentPanel.add(lblStudentid);
		textField = new JTextField();
		textField.setBounds(208, 39, 105, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a=new alg();
		a.fun(textField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						textvalidation valobj = new textvalidation();
						if (valobj.fun(textField.getText())) {
							Display obj = new Display("Password not Entered");
							obj.setVisible(true);
					
						} else {
					
						
						id=textField.getText();
						System.out.println(id);
						loginupdate2 obj1;
						try {
							obj1 = new loginupdate2(id);
							obj1.setVisible(true);
							dispose();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
