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
public class textlength extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			textlength dialog = new textlength();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public textlength() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\7777.png"));
		setTitle("error msg");
		setBounds(100, 100, 450, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			okButton.setBounds(170, 86, 74, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel lblEnterTheRight = new JLabel(
					"The length is not correct.Please enter the right lenght.");
			lblEnterTheRight.setForeground(new Color(255, 0, 0));
			lblEnterTheRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterTheRight.setBounds(67, 36, 336, 32);
			contentPanel.add(lblEnterTheRight);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(28, 36, 46, 41);
			//Image img = new ImageIcon(this.getClass().getResource("/7777.png")).getImage();
			//label.setIcon(new ImageIcon(img));
			contentPanel.add(label);
		}
	}
}
