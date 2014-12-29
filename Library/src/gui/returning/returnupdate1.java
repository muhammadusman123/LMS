package gui.returning;

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

import algo.returnalgo;
import algo.returnautocomplete;
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
public class returnupdate1 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public String id;
	public reservation_gui frame;
	private JTextField textField;

	/**
	 * @throws Exception
	 * 
	 */
	public returnupdate1() throws Exception {
		setResizable(false);
		setBounds(100, 100, 450, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Book Return Update Form");
		JLabel lblStudentid = new JLabel("Book ID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentid.setBounds(65, 53, 63, 14);
		contentPanel.add(lblStudentid);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			// @Override
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
		textField.setBounds(224, 51, 113, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		returnautocomplete obj = new returnautocomplete(textField, "returnid");

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
					private String returnid;

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							returnid = textField.getText();
							returnalgo obj2 = new returnalgo();
							obj2.querryupdatea(returnid);
							if (returnalgo.founder == 1) {
								returnalgo.founder = 0;
								returnupdate2 obj3 = new returnupdate2(returnid);
								obj2.set(obj3, returnid);
								obj3.setVisible(true);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
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
