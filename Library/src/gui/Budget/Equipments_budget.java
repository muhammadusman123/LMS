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
public class Equipments_budget extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Equipments_budget frame = new Equipments_budget();
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
	public Equipments_budget() {
		setTitle("Budget Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEq = new JLabel("Equipments and Furniture");
		lblEq.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEq.setBounds(148, 11, 245, 37);
		contentPane.add(lblEq);
		JLabel lblDate = new JLabel("Issue_Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(228, 97, 77, 14);
		contentPane.add(lblDate);
		textField = new JTextField();
		textField.setBounds(339, 94, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblComputer = new JLabel("Computers");
		lblComputer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComputer.setBounds(10, 158, 67, 14);
		contentPane.add(lblComputer);
		textField_1 = new JTextField();
		textField_1.setBounds(110, 155, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblPrinters = new JLabel("Study Rooms");
		lblPrinters.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrinters.setBounds(228, 268, 77, 14);
		contentPane.add(lblPrinters);
		textField_2 = new JTextField();
		textField_2.setBounds(339, 265, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		JLabel lblNewLabel = new JLabel("Open Tables");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 214, 90, 14);
		contentPane.add(lblNewLabel);
		textField_3 = new JTextField();
		textField_3.setBounds(110, 211, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblChairs = new JLabel("Chairs");
		lblChairs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChairs.setBounds(244, 214, 46, 14);
		contentPane.add(lblChairs);
		textField_4 = new JTextField();
		textField_4.setBounds(339, 211, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(424, 93, 21, 23);
		contentPane.add(btnNewButton);
		JLabel lblComputerTables = new JLabel("Computer Tables");
		lblComputerTables.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComputerTables.setBounds(228, 158, 98, 14);
		contentPane.add(lblComputerTables);
		textField_5 = new JTextField();
		textField_5.setBounds(339, 155, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		JLabel lblBookRacks = new JLabel("Book racks");
		lblBookRacks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookRacks.setBounds(10, 268, 67, 14);
		contentPane.add(lblBookRacks);
		textField_6 = new JTextField();
		textField_6.setBounds(110, 265, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		JLabel lblOtherEquipments = new JLabel("Other Equipmnt");
		lblOtherEquipments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOtherEquipments.setBounds(10, 318, 110, 14);
		contentPane.add(lblOtherEquipments);
		textField_7 = new JTextField();
		textField_7.setBounds(110, 315, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(148, 373, 89, 23);
		contentPane.add(btnInsert);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(251, 373, 89, 23);
		contentPane.add(btnCencel);
		textField_8 = new JTextField();
		textField_8.setBounds(110, 94, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		JLabel lblId = new JLabel("ID (month&year)");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(10, 97, 98, 14);
		contentPane.add(lblId);
	}
}
