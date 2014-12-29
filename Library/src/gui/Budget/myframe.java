package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
//import abc.mydialog;
//import abc.myframe2;
public class myframe extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JComboBox comboBox_1;
	public JComboBox comboBox_3;
	public JComboBox comboBox_2;
	public JComboBox comboBox;
	public static myframe myframe2;// declaring vairalbe
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					myframe frame = new myframe();
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
	public myframe() {
		myframe2 = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTo = new JLabel("TO:");
		lblTo.setBounds(25, 26, 46, 14);
		contentPane.add(lblTo);
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(25, 68, 46, 14);
		contentPane.add(lblFrom);
		JLabel lblCargoType = new JLabel("quantity");
		lblCargoType.setBounds(10, 93, 61, 14);
		contentPane.add(lblCargoType);
		JLabel lblQuality = new JLabel("Cargo type");
		lblQuality.setBounds(10, 131, 61, 14);
		contentPane.add(lblQuality);
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(25, 168, 46, 14);
		contentPane.add(lblAmount);
		JLabel lblTex = new JLabel("tex");
		lblTex.setBounds(25, 193, 46, 14);
		contentPane.add(lblTex);
		JLabel lblTotalAmount = new JLabel("Total amount");
		lblTotalAmount.setBounds(10, 218, 86, 14);
		contentPane.add(lblTotalAmount);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Lahore",
				"Multan", "Chiniot" }));
		comboBox.setBounds(105, 23, 96, 20);
		contentPane.add(comboBox);
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "fsd",
				"lahor", "karachi" }));
		comboBox_1.setBounds(105, 65, 96, 20);
		contentPane.add(comboBox_1);
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "grams",
				"kilos", "pounds" }));
		comboBox_2.setBounds(105, 100, 96, 20);
		contentPane.add(comboBox_2);
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "wooden",
				"iron" }));
		comboBox_3.setBounds(105, 128, 96, 20);
		contentPane.add(comboBox_3);
		textField = new JTextField();
		textField.setBounds(81, 165, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(81, 190, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setBounds(81, 215, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		JButton btnAddMore = new JButton("add more");
		btnAddMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myD naveed = new myD("Add City", "City", myframe2);// passing
																	// variable
				naveed.setVisible(true);
				// new myD tem=new
			}
		});
		btnAddMore.setBounds(211, 22, 89, 23);
		contentPane.add(btnAddMore);
		JButton btnAddNew = new JButton("add new");
		btnAddNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myD naveed = new myD("Add City", "City", myframe2);// passing
																	// variable
				naveed.setVisible(true);
			}
		});
		btnAddNew.setBounds(211, 64, 89, 23);
		contentPane.add(btnAddNew);
		JButton btnAddNew_1 = new JButton("add new");
		btnAddNew_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myD naveed = new myD("Add Cargo", "Cargo", myframe2);// passing
																		// variable
				naveed.setVisible(true);
			}
		});
		btnAddNew_1.setBounds(211, 99, 89, 23);
		contentPane.add(btnAddNew_1);
		JButton btnAddNew_2 = new JButton("add new");
		btnAddNew_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myD naveed = new myD("Add Quantity", "Qunatity", myframe2);// passing
																			// variable
				naveed.setVisible(true);
			}
		});
		btnAddNew_2.setBounds(211, 131, 89, 23);
		contentPane.add(btnAddNew_2);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double a = Integer.parseInt(textField.getText());
				textField_1.setText("" + a / 2);
				textField_2.setText("" + 3 * a / 2);
				frameabc naveed123 = new frameabc(comboBox.getSelectedItem()
						.toString(), comboBox_1.getSelectedItem().toString(),
						comboBox_2.getSelectedItem().toString(), comboBox_3
								.getSelectedItem().toString(), "" + 3 * a / 2);// passing
																				// variable
				naveed123.setVisible(true);
			}
		});
		btnNewButton.setBounds(243, 211, 115, 29);
		contentPane.add(btnNewButton);
	}
}
