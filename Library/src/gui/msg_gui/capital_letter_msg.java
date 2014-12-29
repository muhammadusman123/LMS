package gui.msg_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class capital_letter_msg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			capital_letter_msg dialog = new capital_letter_msg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public capital_letter_msg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			okButton.setBounds(171, 107, 74, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the semester type in small letters");
		lblPleaseEnterThe.setForeground(new Color(255, 0, 0));
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseEnterThe.setBounds(84, 49, 277, 23);
		contentPanel.add(lblPleaseEnterThe);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
