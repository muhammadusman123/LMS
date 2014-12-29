package gui.reservation;

import gui.Authentication.Display;

import java.awt.BorderLayout;
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
import algo.reservationautocomplete;
import algo.textvalidation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import database.alg;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class reservationinsertion extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String name, book;
	public int id, bookid;
	public reservation_gui frame;
	private ObservingTextField textField_3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public reservationinsertion() throws Exception {
		setBounds(100, 100, 450, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Insert Form");
		JLabel lblStudentname = new JLabel("Student_name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(47, 97, 117, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Book name");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBook.setBackground(Color.GRAY);
		lblBook.setBounds(47, 141, 117, 14);
		contentPanel.add(lblBook);
		JLabel lblBook_1 = new JLabel("Book_id");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBook_1.setBackground(Color.GRAY);
		lblBook_1.setBounds(58, 185, 87, 14);
		contentPanel.add(lblBook_1);
		textField = new JTextField();
		textField.setBounds(196, 94, 125, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
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
		btnReservationDate.setBounds(319, 38, 27, 20);
		contentPanel.add(btnReservationDate);
		textField_3 = new ObservingTextField();
		textField_3.setBounds(196, 38, 125, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		reservationautocomplete obj = new reservationautocomplete(textField,
				"name");
		reservationautocomplete obj2 = new reservationautocomplete(textField_2,
				"bookid");
		JLabel label = new JLabel("Date");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(66, 49, 46, 14);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// name = textField.getText();
						// book = textField_1.getText();
						// bookid = Integer.parseInt(textField_2.getText());
						// id=Integer.parseInt(textField_3.getText());
						// algo.reservationalgo obj = new
						// algo.reservationalgo();
						// obj.Insert(name, book, bookid,
						// textField_3.getText());
						// Display disp = new Display(
						// "Record has been Successfully Inserted");
						// disp.setVisible(true);
						check_input_field_valid object = new check_input_field_valid();
						textvalidation valobj = new textvalidation();
						if (valobj.fun(textField.getText())) {
							Display obj = new Display(
									"Student name is not enterd");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display("Book name is not enterd");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display("book_id is not enterd");
							obj.setVisible(true);
						} else if (valobj.fun(textField_3.getText())) {
							Display obj = new Display("no data  is  enterd");
							obj.setVisible(true);
						} else {

							String str1 = textField.getText();
							String str2 = textField_1.getText();
							String str3 = textField_2.getText();

							boolean value = object.checkIfNumber(str1);
							if (value) {
								String str = "Invalid";
								name = str;
								System.out.println("Value is integer!");
							} else {
								name = textField.getText();

								System.out.println("Value is in string!");
							}

							boolean value1 = object.checkIfNumber(str2);
							if (value1) {
								String str = "Invalid";
								name = str;
								System.out.println("Value is integer!");
							} else {
								book = textField_1.getText();

								System.out.println("Value is in string!");
							}

							boolean value2 = object.checkIfNumber(str3);
							if (value2) {
								System.out.println("Value is integer!");
								bookid = Integer.parseInt(textField_2.getText());

							} else {
								String str = "Invalid";
								name = str;
								System.out.println("Value is in string!");

							}

							// id = Integer.parseInt(textField_3.getText());
							algo.reservationalgo obj = new algo.reservationalgo();
							obj.Insert(textField.getText(),
									textField_1.getText(),
									Integer.parseInt(textField_2.getText()),
									textField_3.getText());

							algo.reservationalgo obj1 = new algo.reservationalgo();
							// id = Integer.parseInt(textField_3.getText());

							// obj.Insert(name, book, bookid,
							// textField_3.getText());
							Display disp = new Display(
									"Record has been Successfully Inserted");
							disp.setVisible(true);

							dispose();

						}
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
