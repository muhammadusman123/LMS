package gui.Authentication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JSlider;
import algo.loginalgo;
import algo.textvalidation;
import database.alg;
import database.dbclass;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class Authentication extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblPassword;
	private JLabel label_1;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				try {
					Authentication frame = new Authentication();
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
	public Authentication() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 284);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Authentication Form");
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(192, 184, 115, 29);
		btnLogin.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				textvalidation valobj = new textvalidation();
				if (valobj.fun(textField.getText())) {
					Display obj = new Display("UserName not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_1.getText())) {
					Display obj = new Display("Password not Entered");
					obj.setVisible(true);
				} else {
					loginalgo obj = new loginalgo();
					obj.validation(textField.getText(), textField_1.getText());
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		textField = new JTextField();
		textField.setBounds(107, 111, 115, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(366, 111, 115, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(10, 99, 159, 50);
		contentPane.add(lblUserName);
		lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(266, 99, 90, 50);
		contentPane.add(lblPassword);

		JLabel lblLibrary = new JLabel("Library");
		lblLibrary.setForeground(UIManager
				.getColor("CheckBoxMenuItem.selectionBackground"));
		lblLibrary.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblLibrary.setBounds(26, 15, 128, 55);
		contentPane.add(lblLibrary);

		JLabel lblManagement = new JLabel("Management");
		lblManagement.setForeground(UIManager
				.getColor("CheckBoxMenuItem.selectionBackground"));
		lblManagement.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblManagement.setBounds(144, 21, 200, 43);
		contentPane.add(lblManagement);

		JLabel lblSystem = new JLabel("System");
		lblSystem.setForeground(UIManager
				.getColor("CheckBoxMenuItem.selectionBackground"));
		lblSystem.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblSystem.setBounds(354, 25, 159, 34);
		contentPane.add(lblSystem);
		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 424, 243);
		JLabel label = new JLabel("");
		label.setBackground(new Color(240, 240, 240));
		label.setBounds(0, 0, 605, 347);
	}
}