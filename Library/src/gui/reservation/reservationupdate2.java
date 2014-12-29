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

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import database.alg;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.check_input_field_valid;
import algo.reservationautocomplete;
import algo.textvalidation;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class reservationupdate2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	public String name, bookname;
	public int bookid;
	public reservation_gui frame;
	private ObservingTextField textField_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public reservationupdate2(final int id) throws Exception {

		setBounds(100, 100, 450, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Update Form");
		JLabel lblNobooks = new JLabel("Book id");
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNobooks.setBounds(43, 202, 86, 14);
		contentPanel.add(lblNobooks);

		JLabel lblStudentname = new JLabel("Student_name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentname.setBounds(29, 99, 147, 14);
		contentPanel.add(lblStudentname);

		JLabel lblBook = new JLabel("Book name");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBook.setBounds(29, 153, 100, 14);
		contentPanel.add(lblBook);

		textField = new JTextField();
		textField.setBounds(212, 96, 109, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		a.fun42(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(212, 150, 109, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		a.fun43(textField_1);

		textField_3 = new JTextField();
		reservationautocomplete obj = new reservationautocomplete(textField_1,
				"name");
		reservationautocomplete obj2 = new reservationautocomplete(textField_3,
				"bookid");
		textField_3.addKeyListener(new KeyAdapter() {
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

		textField_3.setBounds(212, 200, 109, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		a.fun44(textField_3);

		textField_2 = new ObservingTextField();
		textField_2.setBounds(212, 50, 109, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnReservationDate = new JButton("...");
		btnReservationDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnReservationDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);

			}

			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);

				} else {
					return Locale.US;
				}

			}
		});
		btnReservationDate.setBounds(320, 50, 22, 23);
		contentPanel.add(btnReservationDate);

		JLabel label = new JLabel("Date");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(42, 52, 46, 14);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						textvalidation valobj = new textvalidation();
						check_input_field_valid object = new check_input_field_valid();

						if (valobj.fun(textField.getText())) {
							Display obj = new Display(
									"Student name is not enterd");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display("Book name is not enterd");
							obj.setVisible(true);
						}

						else if (valobj.fun(textField_3.getText())) {
							Display obj = new Display("Id  is not enterd");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display("no value is not enterd");
							obj.setVisible(true);
						} else {
							String str1 = textField.getText();
							String str2 = textField_1.getText();
							String str3 = textField_3.getText();

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
								bookname = textField_1.getText();

								System.out.println("Value is in string!");
							}

							boolean value3 = object.checkIfNumber(str3);
							if (value3) {
								bookid = Integer.parseInt(textField_3.getText());
								System.out.println("Value is integer!");
							} else {
								String str = "Invalid";
								name = str;

								System.out.println("Value is in string!");
							}

							algo.reservationalgo obj = new algo.reservationalgo();
							obj.Update(id, textField.getText(),
									textField_1.getText(),
									Integer.parseInt(textField_3.getText()),
									textField_2.getText());

							Display disp = new Display(
									"Record has been Successfully Updated");
							disp.setVisible(true);
						}
						dispose();

					}
				});
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

						dispose();
					}
				});
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void set(int id) throws SQLException {
		String c;
		ResultSet rs;
		algo.reservationalgo alg = new algo.reservationalgo();
		rs = alg.update_field(id);
		while (rs.next()) {
			textField.setText(rs.getString("Student_name"));
			textField_1.setText(rs.getString("Book_name"));
			c = Integer.toString(rs.getInt("Book_id"));
			textField_3.setText(c);
			textField_2.setText(rs.getString("Reservation_Date"));

		}
	}

}
