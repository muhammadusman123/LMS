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

public class Empty_MSG extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Empty_MSG dialog = new Empty_MSG();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Empty_MSG() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPleaseFillAll = new JLabel("Please fill all the fields correctly");
		lblPleaseFillAll.setForeground(new Color(255, 0, 0));
		lblPleaseFillAll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseFillAll.setBounds(114, 36, 231, 30);
		contentPanel.add(lblPleaseFillAll);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				}
			});
			okButton.setBounds(169, 89, 65, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
