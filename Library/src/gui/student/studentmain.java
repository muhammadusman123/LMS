package gui.student;

import gui.Authentication.MainPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import algo.studentalgo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.JLabel;

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

import database.alg;
import database.dbclass;

import javax.swing.UIManager;

import te.universityreport;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class studentmain extends JFrame {
	private JPanel contentPane;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentmain frame = new studentmain();
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
	public studentmain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager
				.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Student Main Form");
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				studentinsert obj;
				try {
					obj = new studentinsert();
					obj.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(51, 111, 123, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				studentupdate1 obj;
				try {
					obj = new studentupdate1();
					obj.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(51, 164, 123, 29);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("JTable");
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					studentreport studentreportobj = new studentreport();
					studentreportobj.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(238, 164, 123, 29);
		contentPane.add(btnNewButton_2);
		JButton btnCancel = new JButton("Exit");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage obj = new MainPage();
				obj.setVisible(true);
			}
		});
		btnCancel.setBounds(238, 215, 123, 29);
		contentPane.add(btnCancel);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentdelete obj;
				try {
					obj = new studentdelete();
					obj.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDelete.setBounds(238, 111, 115, 29);
		contentPane.add(btnDelete);

		JButton btnCustomiseReports = new JButton("Reports");
		btnCustomiseReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				universityreport obj = new universityreport();
				obj.setVisible(true);
			}
		});
		btnCustomiseReports.setBounds(51, 215, 123, 29);
		contentPane.add(btnCustomiseReports);

		JLabel lblLmsStudentModule = new JLabel("LMS Student Module");
		lblLmsStudentModule.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsStudentModule.setBounds(114, 11, 223, 43);
		contentPane.add(lblLmsStudentModule);

		JLabel label = new JLabel("_________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(114, 11, 223, 54);
		contentPane.add(label);
	}
}