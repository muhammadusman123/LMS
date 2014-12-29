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
import javax.swing.JComboBox;

import algo.DatePicker;
import algo.ObservingTextField;
import algo.alg;
//import algo.autocomplete_2;
import algo.payroll_algo;
import algo.payroll_autocomplete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class payroll_insertion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	private JTextField textField;
	private ObservingTextField textField_1;
	public String name,post,date_of_joining;
	public JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public payroll_insertion() throws Exception {
		setTitle("Employee Addition Window");
		setBounds(100, 100, 453, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(25, 24, 46, 25);
		contentPanel.add(lblName);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPost.setBounds(25, 60, 57, 14);
		contentPanel.add(lblPost);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfJoining.setBounds(10, 85, 93, 32);
		contentPanel.add(lblDateOfJoining);
		
		textField = new JTextField();
		payroll_autocomplete obj=new payroll_autocomplete(textField,"name");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField.getText().length()>49)
			    {
			
			      e.consume();
			    }
			}
		});
		textField.setBounds(256, 27, 137, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		  comboBox = new JComboBox();
		  comboBox.setModel(new DefaultComboBoxModel(new String[] {"Librarian", "Assistant_Librarian", "Manager", "Assistant_Manager", "Library_Technician", "Intern", "Peon"}));
		comboBox.setBounds(256, 58, 137, 20);
		contentPanel.add(comboBox);
		
		textField_1 = new ObservingTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(256, 92, 99, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lang=null;
				payroll_algo obj= new payroll_algo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp=new DatePicker(textField_1,locale);
				Date selectedDate=dp.parseDate(textField_1.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_1);
				
				
			}
			
			//comboBox.getText();
		});
		btnNewButton.setBounds(355, 89, 38, 25);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean flag=false;
						
						name=textField.getText();
					    post=comboBox.getSelectedItem().toString();
						date_of_joining=textField_1.getText();
						payroll_algo obj=new payroll_algo();
						flag=obj.Insert(name,post,date_of_joining);
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
