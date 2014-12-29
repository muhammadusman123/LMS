package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
public class updated_msg extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					updated_msg frame = new updated_msg();
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
	public updated_msg() {
		setTitle("Budget Message Window");
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 159);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("");
		label.setBounds(81, 15, 121, 95);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/8888.png")).getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		JLabel lblYourBudgetIs = new JLabel("Your budget is updated");
		lblYourBudgetIs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYourBudgetIs.setBounds(124, 28, 184, 39);
		contentPane.add(lblYourBudgetIs);
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				// budgetmain frame = new budgetmain();
				// frame.setVisible(true);
			}
		});
		btnOk.setBounds(151, 87, 89, 23);
		contentPane.add(btnOk);
	}
}
