package gui.Payroll;

import gui.UserReport.userreportupdate2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import algo.alg;
import algo.payroll_algo;
import algo.payroll_autocomplete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class payroll_update1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	public int id;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public payroll_update1() throws Exception {
		setTitle("Employee Verification");
		setBounds(100, 100, 366, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEnterId = new JLabel("Enter id");
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterId.setBounds(24, 21, 55, 14);
		contentPanel.add(lblEnterId);

		textField = new JTextField();
		payroll_autocomplete obj = new payroll_autocomplete(textField, "id");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField.getText().length() > 4) {

					e.consume();
				}
			}
		});
		textField.setBounds(174, 19, 97, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String msg;
						String s_id = textField.getText();
						boolean[] flag = new boolean[3];
						boolean is_int = false;
						payroll_algo p_alg_obj = new payroll_algo();
						try {
							flag = p_alg_obj.is_id_field_empty(s_id, flag);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (flag[0] == false) {
							// is_int=p_alg_obj.isInteger(s_id);
							if (flag[2]) {
								if (flag[1] == true) {
									id = Integer.parseInt(s_id);
									payroll_update2 obj = null;
									try {
										obj = new payroll_update2(id);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									obj.setVisible(true);

									try {
										p_alg_obj.set_textfields_2(obj, id);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
									}
									dispose();
								} else {

									msg = "Employee id not found ";
									Display d_obj = new Display(msg, 0);
									d_obj.setVisible(true);
								}
							} else {
								msg = "Employee id must be numerical ";
								Display d_obj = new Display(msg, 0);
								d_obj.setVisible(true);
							}
						} else {

							msg = "Employee id field is empty";
							Display d_obj = new Display(msg, 0);
							d_obj.setVisible(true);
						}

					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
