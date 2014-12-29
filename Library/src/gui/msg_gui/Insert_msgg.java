package gui.msg_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class Insert_msgg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Insert_msgg dialog = new Insert_msgg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Insert_msgg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\8888.png"));
		setTitle("Budget insert msg");
		setBounds(100, 100, 450, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(160, 100, 89, 23);
		contentPanel.add(button);
		
		JLabel label = new JLabel("You have successfully inserted the budget");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(77, 28, 328, 57);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(21, 41, 46, 39);
	//	Image img=new ImageIcon (this.getClass().getResource("/8888.png")).getImage();
	//	label.setIcon(new ImageIcon(img));
		contentPanel.add(label_1);
	}
}
