package gui.Purchase;

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
import algo.purchase_autocomplete;
import algo.purchasealgo;
import algo.textvalidation;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class BookPurchaseUpdate extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	// public String name, bookname;
	public int bookid;
	public BookPurchaseUpdate frameab;
	public JTextField textField_3;
	public JTextField textField_4;
	public ObservingTextField textField_5;
	public JTextField textField_7;
	public JComboBox comboBox;
	public String date = null;
	public String isbn = null;
	public String authorname = null;
	public String bookname = null;
	public String edition = null;
	public String price = null;
	public String category = null;
	public String upc = null;

	public BookPurchaseUpdate(final String id) throws Exception {
		setResizable(false);
		frameab = this;
		setBounds(100, 100, 450, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Purchase Update Form");
		contentPanel.setLayout(null);
		JLabel lblNobooks = new JLabel("BookName");
		lblNobooks.setBounds(24, 137, 77, 14);
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNobooks);
		JLabel lblStudentname = new JLabel("ISBN");
		lblStudentname.setBounds(24, 77, 134, 14);
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("AuthorName");
		lblBook.setBounds(24, 107, 106, 14);
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblBook);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 10) {
					e.consume();
				}
			}
		});
		textField.setBounds(212, 76, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		// a.fun31(textField);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(212, 104, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun32(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9'))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_2.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(212, 135, 115, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun33(textField_2);
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_3.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(212, 166, 115, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		// a.fun34(textField_3);
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_4.getText().length() == 2) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(212, 197, 115, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(24, 166, 69, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Edition");
		lblNewLabel_1.setBounds(24, 197, 69, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(212, 45, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);

		purchase_autocomplete obj = new purchase_autocomplete(textField, "isbn");
		purchase_autocomplete obj1 = new purchase_autocomplete(textField_1,
				"author");
		purchase_autocomplete obj2 = new purchase_autocomplete(textField_2,
				"book");
		purchase_autocomplete obj3 = new purchase_autocomplete(textField_4,
				"edition");
		purchase_autocomplete obj4 = new purchase_autocomplete(textField_3,
				"price");
		JButton btnPurchaseDate = new JButton("Purchase Date");
		btnPurchaseDate.setBounds(327, 45, 30, 20);
		btnPurchaseDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnPurchaseDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				purchasealgo obj = new purchasealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
		});
		contentPanel.add(btnPurchaseDate);
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(24, 45, 106, 14);
		contentPanel.add(lblNewLabel_2);
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategory.setBounds(24, 233, 69, 20);
		contentPanel.add(lblCategory);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(212, 258, 115, 26);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpc.setBounds(24, 269, 69, 20);
		contentPanel.add(lblUpc);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "CS", "BBA",
				"HS", "EE" }));
		comboBox.setBounds(212, 228, 115, 26);
		contentPanel.add(comboBox);
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
						date = textField_5.getText();
						isbn = textField.getText();
						authorname = textField_1.getText();
						bookname = textField_2.getText();
						edition = textField_4.getText();
						price = textField_3.getText();
						category = (String) comboBox.getSelectedItem();
						upc = textField_7.getText();
						// algosobj.querygen();
						purchasealgo algosobj = new purchasealgo();
						try {
							algosobj.querryupdateb(id, date, isbn, authorname,
									bookname, edition, price, category, upc);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (purchasealgo.founder == 1) {
							purchasealgo.founder = 0;
							dispose();
						}
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
}