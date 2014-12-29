package gui.Payroll;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import algo.payroll_algo;
import algo.payroll_autocomplete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class payroll_deletion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	public JTextField textField;
	public JTextField textField_1;
	public int id;
	public String name;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public payroll_deletion() throws Exception {
		setTitle("Employee Deletion Window");
		setBounds(100, 100, 450, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee id");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeId.setBounds(32, 28, 85, 14);
		contentPanel.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee name");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeName.setBounds(32, 76, 97, 14);
		contentPanel.add(lblEmployeeName);
		
		textField = new JTextField();
		payroll_autocomplete obj=new payroll_autocomplete(textField,"id");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(textField.getText().length()>4)
			    {
			
			      e.consume();
			    }
			}
		});
		textField.setBounds(263, 26, 85, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		payroll_autocomplete obj2=new payroll_autocomplete(textField_1,"name");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_1.getText().length()>49)
			    {
			
			      e.consume();
			    }
			}
		});
		textField_1.setBounds(263, 70, 149, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean flag = false;
						String s_id;
						s_id=textField.getText();
						//id=Integer.parseInt(s_id);
						name=textField_1.getText();
						payroll_algo obj=new payroll_algo();
						try {
							flag=obj.Delete(s_id,name);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} //s_id is string id
						
						if(flag)
							{
							dispose();
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
