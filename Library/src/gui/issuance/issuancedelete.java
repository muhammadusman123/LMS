package gui.issuance;

import gui.Authentication.Display;
import gui.reservation.reservation_gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algo.issuancealgo;
import algo.issueautocomplete;
import algo.textvalidation;
import algo.verification;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.UIManager;

import database.alg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Muhammad Usman
 *
 */
public class issuancedelete extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public String id;
	public reservation_gui frame;
	private JTextField textField;
	public String issuanceid = null;

	/**
	 * @throws Exception
	 * 
	 */
	public issuancedelete() throws Exception {
		setResizable(false);
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Issuance Delete Form");
		JLabel lblStudentid = new JLabel("Issue ID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentid.setBounds(69, 55, 63, 14);
		contentPanel.add(lblStudentid);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField.setBounds(223, 53, 108, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		issueautocomplete obj = new issueautocomplete(textField, "id");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						issuancealgo obj = new issuancealgo();
						try {
							issuanceid = textField.getText();
							obj.delete(issuanceid);
							if (issuancealgo.founder == 1) {
								issuancealgo.founder = 0;
								dispose();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
