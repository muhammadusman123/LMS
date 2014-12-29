package gui.Labeling;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
public class record extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField1;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public record() {
		setTitle("Record Window");
		setBounds(100, 100, 450, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField1 = new JTextField();
			textField1.setEditable(false);
			textField1.setBounds(255, 50, 102, 20);
			contentPanel.add(textField1);
			textField1.setColumns(10);
		}
		{
			JLabel lblTotalPurchaseBooks = new JLabel(
					"Total Purchase Books  ");
			lblTotalPurchaseBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTotalPurchaseBooks.setBounds(49, 50, 156, 17);
			contentPanel.add(lblTotalPurchaseBooks);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
