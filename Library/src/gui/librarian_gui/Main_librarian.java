package gui.librarian_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

/**
 * 
 * @author Naveed
 *
 */
public class Main_librarian extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main_librarian frame = new Main_librarian();
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
	public Main_librarian() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\project\\Librarian\\1011.png"));
		setTitle(" Librarian Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInsert = new JButton("Issue Req");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Librarian_insert dialog = new Librarian_insert();
				dialog.setVisible(true);
			}
		});
		btnInsert.setBounds(43, 118, 108, 26);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("Update Req");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				librarianupdate up = new librarianupdate();
				up.setVisible(true);

			}
		});
		btnUpdate.setBounds(204, 118, 108, 26);
		contentPane.add(btnUpdate);

		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Librarian_table up;
				try {
					up = new Librarian_table();
					up.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnReport.setBounds(43, 174, 108, 26);
		contentPane.add(btnReport);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(204, 174, 108, 26);
		contentPane.add(btnExit);

		JLabel lblLibrarian = new JLabel("LMS Librarian Budget Request");
		lblLibrarian.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
		lblLibrarian.setBounds(29, 27, 294, 39);
		contentPane.add(lblLibrarian);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 108, 81);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/abx.png")).getImage();
		// lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("______________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(29, 15, 309, 54);
		contentPane.add(label);
	}
}
