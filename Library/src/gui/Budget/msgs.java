package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class msgs extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					msgs frame = new msgs();
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
	public msgs() {
		setTitle("Budget Message Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblLibrarianHasNat = new JLabel(
				"Librarian has not yet requsted for budget.Do you want to Issue budget");
		lblLibrarianHasNat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLibrarianHasNat.setBounds(39, 25, 461, 35);
		contentPane.add(lblLibrarianHasNat);
		JLabel lblDoYouWant = new JLabel(
				" without Librarian geting requested amount and total salaries.");
		lblDoYouWant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoYouWant.setBounds(49, 58, 414, 23);
		contentPane.add(lblDoYouWant);
		JButton btnOk = new JButton("yes");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Inset_Salary_budget i = new Inset_Salary_budget();
				i.setVisible(true);
				dispose();
			}
		});
		btnOk.setBounds(141, 115, 89, 23);
		contentPane.add(btnOk);
		JButton btnCencel = new JButton("No");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dispose();
				// Salary_budget_main s=new Salary_budget_main();
				// dispose();
			}
		});
		btnCencel.setBounds(237, 115, 89, 23);
		contentPane.add(btnCencel);
	}
}
