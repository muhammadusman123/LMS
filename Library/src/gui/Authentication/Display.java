package gui.Authentication;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import algo.labelalgo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class Display extends JDialog {
	private final JPanel contentPanel = new JPanel();
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Display dialog = new Display("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param string
	 */
	public Display(final String string) {
		setBounds(100, 100, 760, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Transaction Status");
		JLabel label = new JLabel("");
		label.setBounds(226, 29, 349, 50);
		label.setText(string);
		contentPanel.add(label);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(165, 29, 63, 60);
		if (string.equals("Record has been Successfully Inserted")
				|| string.equals("Record has been Successfully Updated")
				|| string
						.equals("Do you want to Print a Label for this new Book !!!")) {
			Image img = new ImageIcon(this.getClass().getResource("/tick.png"))
					.getImage();
			label_1.setIcon(new ImageIcon(img));
			contentPanel.add(label_1);
		} else {
			Image img = new ImageIcon(this.getClass().getResource("/cross.png"))
					.getImage();
			label_1.setIcon(new ImageIcon(img));
			contentPanel.add(label_1);
		}
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (string
								.equals("Do you want to Print a Label for this new Book !!!")) {
							labelalgo obj = new labelalgo();
							obj.printlabel(gui.Purchase.bookPurchase.labelofbook);
						}
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
