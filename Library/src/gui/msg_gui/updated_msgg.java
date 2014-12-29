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
public class updated_msgg extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			updated_msgg dialog = new updated_msgg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public updated_msgg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Naveed\\Desktop\\pic\\8888.png"));
		setTitle("Update msg");
		setBounds(100, 100, 450, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblYourBudgetIs = new JLabel(
					"Your budget is updated successfuly.");
			lblYourBudgetIs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblYourBudgetIs.setBounds(111, 43, 230, 39);
			contentPanel.add(lblYourBudgetIs);
		}
		{
			JButton button = new JButton("OK");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setBounds(159, 112, 89, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(51, 34, 63, 60);
		//	Image img = new ImageIcon(this.getClass().getResource("/8888.png")).getImage();
		//	label.setIcon(new ImageIcon(img));
			contentPanel.add(label);
		}
	}
}
