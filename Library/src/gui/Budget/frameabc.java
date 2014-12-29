package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class frameabc extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 * @param string5
	 * @param string4
	 * @param string3
	 * @param string2
	 * @param string
	 */
	public frameabc(String string, String string2, String string3,
			String string4, String string5) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(15, 16, 43, 50);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(25, 62, 200, 50);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(15, 98, 200, 50);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Quality");
		lblNewLabel_3.setBounds(15, 138, 200, 50);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Amount");
		lblNewLabel_4.setBounds(15, 199, 200, 50);
		contentPane.add(lblNewLabel_4);
		textField = new JTextField();
		textField.setBounds(154, 16, 200, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(string);
		textField_1 = new JTextField();
		textField_1.setBounds(154, 82, 200, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(string2);
		textField_2 = new JTextField();
		textField_2.setBounds(154, 138, 200, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(string3);
		textField_3 = new JTextField();
		textField_3.setBounds(154, 180, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(string4);
		textField_4 = new JTextField();
		textField_4.setBounds(154, 211, 200, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(string5);
	}
}
