package gui.Payroll;

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

import java.awt.Font;

public class Display1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public Display1(String msg ,int val) {
		setTitle("Message Box");
		setBounds(100, 100, 391, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(95, 36, 276, 28);
		
		contentPanel.add(label);
		JLabel label_icon = new JLabel("");
		label_icon.setBounds(22, 22, 63, 60);
		contentPanel.add(label_icon);
		label.setText(msg);
			if(val==1)
				{
					Image img=new ImageIcon (this.getClass().getResource("/tick.png")).getImage();
					label_icon.setIcon(new ImageIcon(img));
					contentPanel.add(label_icon);
				}
				else
				{
					Image img=new ImageIcon (this.getClass().getResource("/cross.png")).getImage();
					label_icon.setIcon(new ImageIcon(img));
					contentPanel.add(label_icon);
				}
			
			{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
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
