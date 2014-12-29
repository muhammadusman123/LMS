package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Bill_insert extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					Bill_insert frame = new Bill_insert();
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
	public Bill_insert() {
		setTitle("Bill Budget Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 346);
		contentPane.add(panel);
		JLabel label = new JLabel("Bills Budget");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(145, 11, 117, 30);
		panel.add(label);
		JLabel label_1 = new JLabel("Bill Amount");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(48, 68, 74, 14);
		panel.add(label_1);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 65, 117, 20);
		panel.add(textField);
		JButton button = new JButton("Press");
		button.setBounds(273, 64, 74, 23);
		panel.add(button);
		JLabel label_2 = new JLabel("Issue_Amount");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(37, 231, 98, 14);
		panel.add(label_2);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 111, 86, 20);
		panel.add(textField_1);
		JLabel label_3 = new JLabel("Issue_Date");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(48, 174, 74, 14);
		panel.add(label_3);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 171, 86, 20);
		panel.add(textField_2);
		JLabel label_4 = new JLabel("ID (month&year)");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(37, 114, 114, 17);
		panel.add(label_4);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 228, 86, 20);
		panel.add(textField_3);
		JButton button_1 = new JButton("Issue");
		button_1.setBounds(110, 297, 89, 23);
		panel.add(button_1);
		JButton button_2 = new JButton("Cencel");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(209, 297, 89, 23);
		panel.add(button_2);
	}
}
