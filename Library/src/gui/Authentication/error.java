package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import algo.loginalgo;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class error extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public MainPage o;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			error dialog = new error(0, "");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param i
	 * @param text
	 */
	public error(final int i, String text) {
		setBounds(100, 100, 450, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		if (i == 0) {
			setTitle("Invalid Password Error");
		} else {
			setTitle("Authenticated");
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblYouEnteredWrong = new JLabel(text);
			lblYouEnteredWrong.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(lblYouEnteredWrong);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						loginalgo obj = new loginalgo();
						obj.typeofuser(i);
						dispose();
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
