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
import java.awt.Color;
public class Bills_main extends JFrame {
	private JPanel contentPane;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnReport;
	private JButton button_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// @Override
			@Override
			public void run() {
				try {
					Bills_main frame = new Bills_main();
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
	public Bills_main() {
		setTitle("Biil Budget WIndow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblBillsBudget = new JLabel("Bills Budget");
		lblBillsBudget.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBillsBudget.setBounds(135, 11, 117, 30);
		contentPane.add(lblBillsBudget);
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bill_insert frame = new Bill_insert();
				frame.setVisible(true);
			}
		});
		btnInsert.setBounds(40, 100, 99, 23);
		contentPane.add(btnInsert);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bills_update1 dialog = new Bills_update1();
				dialog.setVisible(true);
			}
		});
		btnUpdate.setBounds(219, 100, 99, 23);
		contentPane.add(btnUpdate);
		btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReport.setBounds(40, 158, 99, 23);
		contentPane.add(btnReport);
		button_3 = new JButton("Exit");
		button_3.setForeground(Color.RED);
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_3.setBounds(219, 158, 99, 23);
		contentPane.add(button_3);
	}
}
