package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import algo.loginalgo;
import algo.textvalidation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import database.alg;
import java.awt.Font;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class logininsertion extends JFrame {
	private JPanel contentPane;
	public JTextField p;
	public JTextField q;
	public logininsertion framea;
	public JTextField r;
	public String abc;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					logininsertion frame = new logininsertion();
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
	public logininsertion() {
		framea = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 238);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Register Form");
		JLabel lblUserid = new JLabel("User Name");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserid.setBounds(61, 26, 89, 14);
		contentPane.add(lblUserid);
		abc = "student";
		p = new JTextField();
		p.setBounds(236, 23, 108, 20);
		contentPane.add(p);
		p.setColumns(10);
		alg a = new alg();
		a.fun(p);
		JLabel lblUserpswd = new JLabel("User Password");
		lblUserpswd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserpswd.setBounds(61, 73, 120, 14);
		contentPane.add(lblUserpswd);
		q = new JTextField();
		q.setBounds(236, 70, 108, 20);
		contentPane.add(q);
		q.setColumns(10);
		if (loginalgo.logintype.equals("owner")) {
			r = new JTextField();
			r.setBounds(236, 147, 89, 26);
			contentPane.add(r);
			r.setColumns(10);
			JLabel lblType = new JLabel("Type");
			lblType.setBounds(50, 150, 69, 20);
			contentPane.add(lblType);
		}
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textvalidation valobj = new textvalidation();
				if (valobj.fun(p.getText())) {
					Display obj = new Display("UserName not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(q.getText())) {
					Display obj = new Display("Password not Entered");
					obj.setVisible(true);
				} else {
					loginalgo obj = new loginalgo();
					if (loginalgo.logintype.equals("owner")) {
						obj.logininsertion(p.getText(), q.getText(),
								r.getText());
					} else {
						obj.logininsertion(p.getText(), q.getText(), "student");
					}
				}
			}
		});
		btnNewButton.setBounds(61, 144, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(256, 144, 115, 29);
		contentPane.add(btnNewButton_1);
	}
}
