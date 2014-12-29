package gui.returning;

import gui.Authentication.MainPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import algo.returnalgo;

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

import te.returningreport;
import java.awt.Font;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class returnmain extends JFrame {
	private JPanel contentPane;
	protected returninsert frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					returnmain frame = new returnmain();
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
	public returnmain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 330);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager
				.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book Return Main");
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returninsert obj;
				try {
					obj = new returninsert();
					obj.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(36, 109, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnupdate1 obj;
				try {
					obj = new returnupdate1();
					obj.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(36, 161, 115, 29);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Report");
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					returnreport returnreportobj = new returnreport();
					returnreportobj.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(244, 161, 115, 29);
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
		btnCancel.setBounds(244, 215, 115, 29);
		contentPane.add(btnCancel);
		JLabel label = new JLabel("");
		label.setBounds(0, 350, 428, -106);
		contentPane.add(label);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returndelete obj;
				try {
					obj = new returndelete();
					obj.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// obj.setVisible(true);
			}
		});
		btnDelete.setBounds(244, 109, 115, 29);
		contentPane.add(btnDelete);

		JButton btnNewButton_3 = new JButton("Reports");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returningreport obj = new returningreport();
				obj.setVisible(true);
			}

		});
		btnNewButton_3.setBounds(36, 215, 115, 29);
		contentPane.add(btnNewButton_3);

		JLabel lblLmsBookReturn = new JLabel("LMS Book Return");
		lblLmsBookReturn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsBookReturn.setBounds(104, 11, 200, 43);
		contentPane.add(lblLmsBookReturn);

		JLabel label_1 = new JLabel("______________\r\n");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(104, 11, 200, 54);
		contentPane.add(label_1);
	}
}
