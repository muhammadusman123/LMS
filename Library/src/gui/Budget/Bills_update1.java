package gui.Budget;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class Bills_update1 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bills_update1 dialog = new Bills_update1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public Bills_update1() {
		setTitle("Bill Budget Update WIndow");
		setBounds(100, 100, 450, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("ID (month&year)");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(76, 56, 118, 17);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(207, 53, 108, 20);
			contentPanel.add(textField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					// @Override
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Bill_update frame = new Bill_update();
						frame.setVisible(true);
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
