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
public class update_failed_msgg extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			update_failed_msgg dialog = new update_failed_msgg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public update_failed_msgg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 184);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYouHaveEntered = new JLabel(
					"You have entered wrong year or semester type.");
			lblYouHaveEntered.setForeground(new Color(255, 0, 0));
			lblYouHaveEntered.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblYouHaveEntered.setBounds(77, 29, 334, 39);
			contentPanel.add(lblYouHaveEntered);
		}
		{
			JButton button = new JButton("OK");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setBounds(157, 96, 89, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(34, 41, 46, 55);
			//Image img = new ImageIcon(this.getClass().getResource("/7777.png")).getImage();
			//label.setIcon(new ImageIcon(img));
			contentPanel.add(label);
		}
	}
}
