package te;

import gui.Authentication.Display;
import gui.reservation.reservation_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.check_input_field_valid;
import algo.textvalidation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import database.alg;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class reservationreport extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String name, book;
	public int id, bookid;
	public reservation_gui frame;
	private ObservingTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					reservationreport frame = new reservationreport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public reservationreport() {
		setBounds(100, 100, 643, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Report Window");
		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(47, 97, 117, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Book name");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBook.setBackground(Color.GRAY);
		lblBook.setBounds(47, 141, 117, 14);
		contentPanel.add(lblBook);
		JLabel lblBook_1 = new JLabel("Book id");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBook_1.setBackground(Color.GRAY);
		lblBook_1.setBounds(49, 187, 87, 14);
		contentPanel.add(lblBook_1);
		textField = new JTextField();
		textField.setBounds(196, 94, 125, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		// alg a = new alg();
		// a.fun42(textField);
		textField_1 = new JTextField();
		textField_1.setBounds(196, 138, 125, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun43(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char cha = e.getKeyChar();
				int count = 0;
				if (!((cha >= '0') && (cha <= '9')
						|| (cha == KeyEvent.VK_BACK_SPACE) || (cha == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();

				}
				if (textField.getText().length() > 13) {
					getToolkit().beep();
					e.consume();

				}
			}
		});
		textField_2.setBounds(196, 184, 125, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun44(textField_2);
		JButton btnReservationDate = new JButton("...");
		btnReservationDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnReservationDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_3, locale);
				Date selectedDate = dp.parseDate(textField_3.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_3);
			}

			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnReservationDate.setBounds(331, 34, 34, 29);
		contentPanel.add(btnReservationDate);
		textField_3 = new ObservingTextField();
		textField_3.setBounds(196, 38, 125, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		JLabel label = new JLabel("Date");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(47, 49, 46, 14);
		contentPanel.add(label);

		textField_4 = new JTextField();
		textField_4.setBounds(385, 35, 146, 26);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Report");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

						String name = textField.getText();
						String book = textField_1.getText();
						String id = textField_2.getText();
						String date = textField_3.getText();
						String dateto = textField_4.getText();
						int counter = 0;
						String query = "SELECT * FROM `reservation` ";

						if (!name.equals("") && counter == 0) {
							query += " where `Student_id` ='" + name + "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!name.equals("") && counter != 0) {
							query += " AND `Student_id` ='" + name + "'";
							counter = 1;
						}

						if (!book.equals("") && counter == 0) {
							query += " where `Book_name` ='" + book + "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!book.equals("") && counter != 0) {
							query += " AND `Book_name` ='" + book + "'";
							counter = 1;
						}

						if (!id.equals("") && counter == 0) {
							query += " where `Book_id` ='" + id + "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!id.equals("") && counter != 0) {
							query += " AND `Book_id` ='" + id + "'";
							counter = 1;
						}

						if (!date.equals("") && counter == 0) {
							query += " where `Reservation_Date` >='" + date
									+ "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!date.equals("") && counter != 0) {
							query += " AND `Reservation_Date` >='" + date + "'";
							counter = 1;
						}

						if (!dateto.equals("") && counter == 0) {
							query += " where `Reservation_Date` <='" + dateto
									+ "'";
							counter = 1;
							System.out.println("I am in isbn");
						} else if (!dateto.equals("") && counter != 0) {
							query += " AND `Reservation_Date` <='" + dateto
									+ "'";
							counter = 1;
						}
						reservation ma = new reservation();
						ma.initConnection();
						try {
							ma.showReport(query);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// obj.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
