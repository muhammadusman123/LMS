package gui.msg_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Msg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Msg dialog = new Msg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Msg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("OK");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			button.setBounds(153, 90, 89, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("Librarian has not yet entered this field.");
			label.setForeground(new Color(255, 0, 0));
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(97, 27, 434, 52);
			contentPanel.add(label);
		}
	}

}
