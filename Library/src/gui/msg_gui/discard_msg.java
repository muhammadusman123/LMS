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

public class discard_msg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			discard_msg dialog = new discard_msg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public discard_msg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\8888.png"));
		setTitle("Discard Book");
		setBounds(100, 100, 450, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBookIsSuccessfully = new JLabel("Book is successfully discarded");
			lblBookIsSuccessfully.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblBookIsSuccessfully.setBounds(121, 41, 250, 34);
			contentPanel.add(lblBookIsSuccessfully);
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnOk.setBounds(166, 100, 89, 23);
		contentPanel.add(btnOk);
		{
			JLabel label = new JLabel("");
			label.setBounds(57, 27, 79, 58);
			//Image img=new ImageIcon (this.getClass().getResource("/8888.png")).getImage();
			//label.setIcon(new ImageIcon(img));
			contentPanel.add(label);
		}
		{
			
		}
		{
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
