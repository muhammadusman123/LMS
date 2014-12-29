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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
public class insert_msg extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					insert_msg frame = new insert_msg();
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
	public insert_msg() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setTitle("Budget Message Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 154);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("");
		label.setBounds(91, 11, 121, 95);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/8888.png")).getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		JLabel label_1 = new JLabel("You have successfully inserted the budget");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(91, 33, 283, 39);
		contentPane.add(label_1);
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(180, 83, 89, 23);
		contentPane.add(button);
	}
}
