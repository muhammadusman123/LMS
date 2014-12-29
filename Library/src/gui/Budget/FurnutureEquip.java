package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
public class FurnutureEquip extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FurnutureEquip frame = new FurnutureEquip();
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
	public FurnutureEquip() {
		setTitle("Equipment And Furniture Budget");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Equipments_budget frame = new Equipments_budget();
				frame.setVisible(true);
			}
		});
		btnInsert.setBounds(40, 106, 111, 23);
		contentPane.add(btnInsert);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Furnitur_update dialog = new Furnitur_update();
				dialog.setVisible(true);
			}
		});
		btnUpdate.setBounds(198, 106, 111, 23);
		contentPane.add(btnUpdate);
		JButton btnReport = new JButton("Report");
		btnReport.setBounds(40, 160, 111, 23);
		contentPane.add(btnReport);
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(198, 160, 111, 23);
		contentPane.add(btnExit);
		
		JLabel lblLmsEquipmentAnd = new JLabel("LMS Equipment And Furniture Budget");
		lblLmsEquipmentAnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLmsEquipmentAnd.setBounds(10, 11, 343, 43);
		contentPane.add(lblLmsEquipmentAnd);
		
		JLabel label = new JLabel("__________________________\r\n\r\n");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(10, 11, 343, 54);
		contentPane.add(label);
	}
}
