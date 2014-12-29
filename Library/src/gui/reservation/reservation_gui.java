package gui.reservation;

import gui.Authentication.MainPage;

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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.UIManager;

import te.reservationreport;

import java.awt.Font;

public class reservation_gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					reservation_gui frame = new reservation_gui();
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
	public reservation_gui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager
				.getColor("TextField.inactiveBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Reservation Main");
		JButton btnStudentReportGeneration = new JButton("JTable");
		btnStudentReportGeneration.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStudentReportGeneration.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnStudentReportGeneration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					reservationjtable obj;
					obj = new reservationjtable();

					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnStudentReportGeneration.setBounds(26, 147, 123, 29);
		contentPane.add(btnStudentReportGeneration);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				reservationinsertion in;
				try {
					in = new reservationinsertion();
					in.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnInsert.setBounds(26, 94, 123, 29);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				reservationupdate1 up;

				try {
					up = new reservationupdate1();
					up.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.setBounds(218, 94, 123, 29);
		contentPane.add(btnUpdate);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				MainPage obj = new MainPage();
				obj.setVisible(true);
			}
		});
		btnExit.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnExit.setBounds(122, 207, 123, 29);
		contentPane.add(btnExit);

		JButton btnCustomiseReports = new JButton("Reports");
		btnCustomiseReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservationreport obj = new reservationreport();
				obj.setVisible(true);
			}
		});
		btnCustomiseReports.setBounds(218, 148, 123, 29);
		contentPane.add(btnCustomiseReports);

		JLabel lblLmsBookReservation = new JLabel("LMS Book Reservation");
		lblLmsBookReservation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsBookReservation.setBounds(65, 11, 259, 43);
		contentPane.add(lblLmsBookReservation);

		JLabel label = new JLabel("__________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(65, 11, 237, 54);
		contentPane.add(label);

	}

}
