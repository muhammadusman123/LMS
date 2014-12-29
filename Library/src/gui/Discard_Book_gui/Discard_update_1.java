package gui.Discard_Book_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.msg_gui.*;
import algo.alg;
import algo.discardautocomplete;

import java.awt.Toolkit;

/**
 * 
 * @author Naveed
 *
 */
public class Discard_update_1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public String id;

	/**
	 * Launch the application.
	 */
	public static String[] ID = new String[100];
	// public reservation_gui frame;
	private JTextField textField;

	/**
	 * Create the dialog.
	 * 
	 * @throws Exception
	 */
	public Discard_update_1() throws Exception {
		// setIconImage(Toolkit.getDefaultToolkit().getImage(
		// "C:\\Users\\Naveed\\Desktop\\project\\Librarian\\pic.png"));
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setBounds(100, 100, 450, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Delete wrong discarded book");
		JLabel lblStudentid = new JLabel("Discard Book ID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentid.setBounds(77, 80, 113, 14);
		contentPanel.add(lblStudentid);

		textField = new JTextField();
		textField.setBounds(233, 78, 113, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		// discardautocomplete obj = new discardautocomplete(textField, "id");

		// alg a=new alg();
		// a.fun36(textField);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(343, 25, 46, 48);

		// Image imge=new ImageIcon
		// (this.getClass().getResource("/1013.png")).getImage();
		// label_1.setIcon(new ImageIcon(imge));
		contentPanel.add(label_1);

		JLabel lblDiscardBook = new JLabel("Discard Book");
		lblDiscardBook.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblDiscardBook.setBounds(143, 22, 412, 36);
		contentPanel.add(lblDiscardBook);

		{
			// Image img=new ImageIcon
			// (this.getClass().getResource("/bb.jpg")).getImage();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

						id = textField.getText();
						int i = 0;
						algo.Discard_algo algosaaobj = new algo.Discard_algo();

						try {
							java.sql.ResultSet a;
							a = algosaaobj.select();
							while (a.next()) {

								ID[i] = a.getString("ID");

								i++;
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int checkit = 0;
						for (int j = 0; j < i; j++) {
							if (ID[j].equals(id)) {
								System.out.println("id" + id);
								System.out.println("ID" + ID[0]);
								checkit = 1;
								dispose();
								Update_Discard obj;
								try {
									obj = new Update_Discard(id);
									obj.setVisible(true);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								// dispose();
								break;
							}

						}
						// budgetupdate2 obj=new budgetupdate2(id);
						// obj.setVisible(true);
						// dispose();
						if (checkit == 0) {

							update_failed_msgg jj = new update_failed_msgg();
							jj.setVisible(true);
						}
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
