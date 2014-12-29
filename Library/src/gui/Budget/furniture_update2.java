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
public class furniture_update2 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					furniture_update2 frame = new furniture_update2();
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
	public furniture_update2() {
		setTitle("Budget Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, -19, 476, 407);
		contentPane.add(panel);
		JLabel label = new JLabel("Equipments and Furniture");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(148, 11, 245, 37);
		panel.add(label);
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIssueDate.setBounds(10, 97, 77, 14);
		panel.add(lblIssueDate);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(110, 94, 86, 20);
		panel.add(textField);
		JLabel label_2 = new JLabel("Computers");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(10, 158, 67, 14);
		panel.add(label_2);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 155, 86, 20);
		panel.add(textField_1);
		JLabel label_3 = new JLabel("Study Rooms");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(228, 97, 77, 14);
		panel.add(label_3);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(339, 94, 86, 20);
		panel.add(textField_2);
		JLabel label_4 = new JLabel("Open Tables");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(10, 214, 77, 14);
		panel.add(label_4);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 211, 86, 20);
		panel.add(textField_3);
		JLabel label_5 = new JLabel("Chairs");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(244, 214, 46, 14);
		panel.add(label_5);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(339, 211, 86, 20);
		panel.add(textField_4);
		JButton button = new JButton("...");
		button.setBounds(197, 93, 21, 23);
		panel.add(button);
		JLabel label_6 = new JLabel("Computer Tables");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(228, 158, 98, 14);
		panel.add(label_6);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(339, 155, 86, 20);
		panel.add(textField_5);
		JLabel label_7 = new JLabel("Book racks");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(10, 268, 67, 14);
		panel.add(label_7);
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(110, 265, 86, 20);
		panel.add(textField_6);
		JLabel label_8 = new JLabel("Other Equipmnt");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(230, 271, 110, 14);
		panel.add(label_8);
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(339, 268, 86, 20);
		panel.add(textField_7);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(148, 340, 89, 23);
		panel.add(btnUpdate);
		JButton button_2 = new JButton("Cencel");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(251, 340, 89, 23);
		panel.add(button_2);
	}
}
