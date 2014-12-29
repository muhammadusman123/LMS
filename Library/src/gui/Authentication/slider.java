package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import algo.purchasealgo;

//import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.awt.Color;

public class slider extends JFrame {
	private JPanel contentPane;
	public JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnCancel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slider frame = new slider();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public slider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 178, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			private Object ResultSet;
			public void actionPerformed(ActionEvent e) {
				lblId.setText("ID");
				lblNewLabel.setText("ISBN");
				lblNewLabel_1.setText("Author_Name");
				lblNewLabel_2.setText("Book_Title");
				purchasealgo obj=new purchasealgo();
				java.sql.ResultSet rs=null;
				try {
					rs=obj.querryupdatea("1");
					while(rs.next()){
						System.out.println(rs.getString("Book_ID"));
						lblNewLabel_4.setText(rs.getString("Book_ID"));
						lblNewLabel_5.setText(rs.getString("ISBN"));
						lblNewLabel_6.setText(rs.getString("Author_Name"));
						lblNewLabel_7.setText(rs.getString("Book_Title"));}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(31, 51, 115, 29);
		panel.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Budget");
		btnNewButton_1.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			Object ResultSet;
			public void actionPerformed(ActionEvent e) {
				lblId.setText("ID");
				lblNewLabel.setText("CS");
				lblNewLabel_1.setText("EE");
				lblNewLabel_2.setText("BBA");
				algo.budgetalgo obj=new algo.budgetalgo();
				java.sql.ResultSet rs=null;
				try {
					rs=obj.querryupdatea("1");
					while(rs.next()){
						System.out.println(rs.getString("ID"));
						lblNewLabel_4.setText(rs.getString("ID"));
						lblNewLabel_5.setText(rs.getString("CS"));
						lblNewLabel_6.setText(rs.getString("EE"));
						lblNewLabel_7.setText(rs.getString("BBA"));}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(31, 109, 115, 29);
		panel.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("UserReport");
		btnNewButton_2.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object ResultSet;
				lblId.setText("Student ID");
				lblNewLabel.setText("Student Name");
				lblNewLabel_1.setText("From Date");
				lblNewLabel_2.setText("To Date");
				algo.userreportalgo obj=new algo.userreportalgo();
				java.sql.ResultSet rs=null;
				try {
					rs=obj.update_field(1);
					while(rs.next()){
						lblNewLabel_4.setText(rs.getString("Student_id"));
						lblNewLabel_5.setText(rs.getString("Student_name"));
						lblNewLabel_6.setText(rs.getString("From_Date"));
						lblNewLabel_7.setText(rs.getString("To_Date"));}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(31, 171, 115, 29);
		panel.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Reservation");
		btnNewButton_3.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			Object ResultSet;
			public void actionPerformed(ActionEvent e) {
				lblId.setText("Student ID");
				lblNewLabel.setText("Student Name");
				lblNewLabel_1.setText("Book_ID");
				lblNewLabel_2.setText("Book_Name");
				algo.reservationalgo obj=new algo.reservationalgo();
				java.sql.ResultSet rs=null;
				try {
					rs=obj.update_field(1);
					while(rs.next()){
						lblNewLabel_4.setText(rs.getString("Student_ID"));
						lblNewLabel_5.setText(rs.getString("Student_name"));
						lblNewLabel_6.setText(rs.getString("Book_id"));
						lblNewLabel_7.setText(rs.getString("Book_name"));}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(31, 232, 115, 29);
		panel.add(btnNewButton_3);		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(31, 291, 115, 29);
		panel.add(btnCancel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(193, 0, 432, 336);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		lblId = new JLabel("");
		lblId.setBounds(15, 38, 69, 20);
		panel_1.add(lblId);
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(15, 102, 69, 20);
		panel_1.add(lblNewLabel);
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(15, 169, 69, 20);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(15, 243, 69, 20);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(267, 38, 69, 20);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(267, 102, 69, 20);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(267, 169, 69, 20);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(267, 243, 69, 20);
		panel_1.add(lblNewLabel_7);
	}
}
