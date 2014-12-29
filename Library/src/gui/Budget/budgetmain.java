package gui.Budget;

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
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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

//import algo.SendEmail;
//import algo.alg;
import database.dbclass;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
import javax.swing.text.html.ImageView;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;

import te.budgetreport;

import java.awt.Toolkit;
import java.awt.SystemColor;

/**
 * 
 * @author Naveed
 *
 */
public class budgetmain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetmain frame = new budgetmain();
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

	public budgetmain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 309);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager
				.getColor("FormattedTextField.selectionForeground"));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Issue budget");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager
				.getColor("InternalFrame.inactiveTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				budgetinsertion m = new budgetinsertion();
				m.setVisible(true);

			}
		});

		btnNewButton.setBounds(46, 109, 115, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("  Update");
		// btnNewButton_1.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\5555.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				budgetupdate1 up = new budgetupdate1();
				up.setVisible(true);
				// dispose();

			}
		});
		btnNewButton_1.setBounds(242, 109, 115, 26);
		contentPane.add(btnNewButton_1);
		setTitle("Purchase Budget Window");
		JButton btnNewButton_2 = new JButton("View Report");
		btnNewButton_2.setIcon(new ImageIcon(
				"C:\\Users\\Naveed\\Desktop\\pic\\4444.png"));

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					budgetjtable obj = new budgetjtable();
					obj.setVisible(true);
					// obj.setVisible(true);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_2.setBounds(46, 160, 115, 26);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(" Exit");

		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// MainPage obj=new MainPage();
				// obj.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_3.setBounds(150, 217, 115, 26);
		contentPane.add(btnNewButton_3);

		JButton btnCustomReports = new JButton("Reports");
		btnCustomReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				budgetreport obj = new budgetreport();
				obj.setVisible(true);
			}
		});
		btnCustomReports.setBounds(242, 160, 115, 29);
		contentPane.add(btnCustomReports);

		JLabel lblLmsPurchaseBudget = new JLabel("LMS Purchase Budget");
		lblLmsPurchaseBudget.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsPurchaseBudget.setBounds(106, 23, 251, 43);
		contentPane.add(lblLmsPurchaseBudget);

		JLabel label = new JLabel("__________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(106, 23, 237, 54);
		contentPane.add(label);

	}
}
