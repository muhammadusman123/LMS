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
public class Bill_update extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					Bill_update frame = new Bill_update();
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
	public Bill_update() {
		setTitle("Bill Budget Update Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
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
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(145, 11, 117, 30);
		panel.add(label);
		JLabel label_1 = new JLabel("Bill Amount");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(48, 68, 74, 14);
		panel.add(label_1);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 65, 105, 20);
		panel.add(textField);
		JButton button = new JButton("Press");
		button.setBounds(236, 64, 59, 23);
		panel.add(button);
		JLabel label_2 = new JLabel("Issue_Amount");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(34, 177, 100, 14);
		panel.add(label_2);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 112, 86, 20);
		panel.add(textField_1);
		JLabel label_3 = new JLabel("Issue_Date");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(48, 115, 74, 14);
		panel.add(label_3);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 174, 86, 20);
		panel.add(textField_2);
		JButton button_1 = new JButton("Issue");
		button_1.setBounds(110, 248, 89, 23);
		panel.add(button_1);
		JButton button_2 = new JButton("Cencel");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(209, 248, 89, 23);
		panel.add(button_2);
	}
}
