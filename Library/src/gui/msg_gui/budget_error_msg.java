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
import java.awt.Color;

public class budget_error_msg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			budget_error_msg dialog = new budget_error_msg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public budget_error_msg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTheValueYou = new JLabel("The value you have entered is not correct");
			lblTheValueYou.setForeground(new Color(255, 0, 0));
			lblTheValueYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTheValueYou.setBounds(101, 48, 245, 14);
			contentPanel.add(lblTheValueYou);
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnOk.setBounds(153, 88, 89, 23);
		contentPanel.add(btnOk);
		{
			JLabel label = new JLabel("");
			label.setBounds(45, 32, 46, 48);
		//	Image img=new ImageIcon (this.getClass().getResource("/7777.png")).getImage();
		//	label.setIcon(new ImageIcon(img));
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
