package gui.msg_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
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

public class noremainbook extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			noremainbook dialog = new noremainbook();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public noremainbook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 193);
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
			okButton.setBounds(176, 120, 77, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblBookContainingThis = new JLabel("No copy of the book entered is present in library");
		lblBookContainingThis.setForeground(new Color(255, 0, 0));
		lblBookContainingThis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookContainingThis.setBounds(66, 51, 323, 23);
		contentPanel.add(lblBookContainingThis);
		
		JLabel label = new JLabel("");
		label.setBounds(32, 39, 46, 51);
	//	Image img=new ImageIcon (this.getClass().getResource("/7777.png")).getImage();
	//	label.setIcon(new ImageIcon(img));
		contentPanel.add(label);
	}

}
