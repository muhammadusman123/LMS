package gui.Authentication;

import gui.Purchase.BookPurchaseMain;
import gui.UserReport.st_database_GUI;
import gui.bookinventory.bookinventory;
import gui.issuance.issuancemain;
import gui.reservation.reservation_gui;
import gui.returning.returnmain;
import gui.student.studentmain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class librarianmainpage extends JFrame {
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					librarianmainpage frame = new librarianmainpage();
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
	public librarianmainpage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Librarian Main Page");
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookPurchaseMain obj = new BookPurchaseMain();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 109, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_8 = new JButton("Membership");
		btnNewButton_8.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				st_database_GUI obj = new st_database_GUI();
				obj.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(162, 109, 115, 29);
		contentPane.add(btnNewButton_8);
		JButton btnNewButton_1 = new JButton("Reservation");
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservation_gui obj = new reservation_gui();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(26, 161, 115, 29);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Account Options");
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginmain obj = new loginmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(26, 221, 115, 29);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(295, 221, 115, 29);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("Issuance");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancemain obj = new issuancemain();
				obj.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(295, 109, 115, 29);
		contentPane.add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton("Returning");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnmain obj = new returnmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(295, 161, 115, 29);
		contentPane.add(btnNewButton_5);
		JButton btnBookReport = new JButton("Book Report");
		btnBookReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bookinventory obj;
				try {
					obj = new bookinventory();
					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBookReport.setBounds(162, 161, 115, 29);
		contentPane.add(btnBookReport);
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				studentmain obj = new studentmain();
				obj.setVisible(true);
			}
		});
		btnStudent.setBounds(162, 221, 115, 29);
		contentPane.add(btnStudent);

		JLabel lblLmsLibrarianModule = new JLabel("LMS Librarian Module");
		lblLmsLibrarianModule.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsLibrarianModule.setBounds(88, 11, 251, 43);
		contentPane.add(lblLmsLibrarianModule);

		JLabel label = new JLabel("__________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(88, 11, 251, 54);
		contentPane.add(label);
	}
}