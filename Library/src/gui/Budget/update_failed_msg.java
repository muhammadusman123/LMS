package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
public class update_failed_msg extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					update_failed_msg frame = new update_failed_msg();
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
	public update_failed_msg() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setTitle("Budget Message Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("");
		label.setBounds(71, 0, 121, 95);
		contentPane.add(label);
		JLabel lblYouHaveEntered = new JLabel("You have entered the wrong ID. ");
		lblYouHaveEntered.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYouHaveEntered.setBounds(116, 24, 209, 39);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/7777.png")).getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(lblYouHaveEntered);
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Inset_Salary_budget a = new Inset_Salary_budget();
				a.setVisible(true);
			}
		});
		button.setBounds(161, 72, 89, 23);
		contentPane.add(button);
	}
}
