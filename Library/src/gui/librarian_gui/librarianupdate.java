package gui.librarian_gui;

import gui.msg_gui.Empty_MSG;
import gui.msg_gui.update_failed_msgg;
import gui.msg_gui.updated_msgg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import algo.librarian_algo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Color;

/**
 * 
 * @author Naveed
 *
 */
public class librarianupdate extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	public String id;
	public String req;
	public String total;
	// public static String[] ID = new String[100];
	// public static String[] ttype = new String[100];
	// public static String[] yyear = new String[100];
	public librarianupdate framea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					librarianupdate frame = new librarianupdate();
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
	public librarianupdate() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\project\\Librarian\\abx.png"));
		framea = this;
		this.id = id;
		setTitle("Update Request Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(144, 81, 46, 14);
		contentPane.add(lblId);
		JLabel lblRequestedAmount = new JLabel("Requested Amount");
		lblRequestedAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequestedAmount.setBounds(99, 188, 125, 25);
		contentPane.add(lblRequestedAmount);
		JLabel lblTotalSalaries = new JLabel("Total Salaries");
		lblTotalSalaries.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalSalaries.setBounds(112, 140, 116, 14);
		contentPane.add(lblTotalSalaries);
		t1 = new JTextField();
		t1.setBounds(235, 77, 108, 23);
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cha = e.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
				if (t1.getText().length() > 8) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		contentPane.add(t1);
		t1.setColumns(10);
		t2 = new JTextField();
		t2.setBounds(235, 189, 108, 23);
		t2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cha = e.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
				if (t2.getText().length() > 8) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		contentPane.add(t2);
		t2.setColumns(10);
		t3 = new JTextField();
		t3.setBounds(235, 136, 108, 23);
		t3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char cha = e.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
				if (t3.getText().length() > 8) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		contentPane.add(t3);
		t3.setColumns(10);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(123, 251, 89, 23);
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id = t1.getText();
				req = t2.getText();
				total = t3.getText();
				if (req.isEmpty() || id.isEmpty() || total.isEmpty()) {
					Empty_MSG msg = new Empty_MSG();
					msg.setVisible(true);
				} else {
					librarian_algo al = new librarian_algo();
					al.Update(2, framea);
					updated_msgg msg = new updated_msgg();
					msg.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnUpdate);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.setForeground(Color.RED);
		btnCencel.setBounds(243, 251, 89, 23);
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCencel);
		JLabel lblRequestForBudget = new JLabel("Request for Budget");
		lblRequestForBudget.setBounds(141, 11, 179, 41);
		lblRequestForBudget
				.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		contentPane.add(lblRequestForBudget);
	}
}
