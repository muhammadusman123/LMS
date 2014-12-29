package gui.Discard_Book_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import te.budgetreport;
import te.discardingreport;

import java.awt.Toolkit;

/**
 * 
 * @author Naveed
 *
 */
public class discard_book_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					discard_book_main frame = new discard_book_main();
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

	public discard_book_main() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\pic.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 308);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager
				.getColor("FormattedTextField.selectionForeground"));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Discard Book");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager
				.getColor("CheckBoxMenuItem.background"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Insert_Discard frame;
				try {
					frame = new Insert_Discard();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnNewButton.setBounds(30, 108, 116, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(" Delete");

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager
				.getColor("CheckBoxMenuItem.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					Discard_update_1 frame = new Discard_update_1();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// dispose();

			}
		});
		btnNewButton_1.setBounds(213, 108, 116, 26);
		contentPane.add(btnNewButton_1);
		setTitle("Welcome to Discard Book main");
		JButton btnNewButton_2 = new JButton("  Report");
		btnNewButton_2.setIcon(new ImageIcon(
				"C:\\Users\\Naveed\\Desktop\\pic\\4444.png"));

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(UIManager
				.getColor("CheckBoxMenuItem.background"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					Discard_table obj = new Discard_table();
					obj.setVisible(true);
					// obj.setVisible(true);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_2.setBounds(30, 161, 116, 26);
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
		btnNewButton_3.setBackground(UIManager
				.getColor("CheckBoxMenuItem.background"));
		btnNewButton_3.setBounds(131, 211, 108, 26);
		contentPane.add(btnNewButton_3);

		JLabel lblDiscardingOfBooks = new JLabel("Discarding of Books");
		lblDiscardingOfBooks
				.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblDiscardingOfBooks.setBounds(100, 33, 188, 32);
		contentPane.add(lblDiscardingOfBooks);

		JLabel label = new JLabel("");
		label.setBounds(20, 11, 52, 72);
		// Image img = new ImageIcon(this.getClass().getResource("/pic.png"))
		// .getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(label);

		JButton btnCustomReports = new JButton("Reports");
		btnCustomReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				discardingreport obj = new discardingreport();
				obj.setVisible(true);
			}
		});
		btnCustomReports.setBounds(213, 161, 116, 29);
		contentPane.add(btnCustomReports);

	}
}
