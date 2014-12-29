package gui.Budget;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

//import abc.myframe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	
	 /* Create the dialog.
	 */
	
	
	public myD(final String string, final String string2,final myframe myframe2) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCity = new JLabel(string2);
			
			contentPanel.add(lblCity);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ADD");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String a=textField.getText();
						setTitle(string2);
						if(string=="Add City")
							{myframe2.comboBox.addItem(""+a);
							myframe2.comboBox_1.addItem(""+a);}
						else if(string=="Add Cargo")
							myframe2.comboBox_2.addItem(""+a);
						else if(string=="Add Quantity")
							myframe2.comboBox_3.addItem(""+a);
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
