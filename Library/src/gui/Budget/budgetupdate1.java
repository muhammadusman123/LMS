package gui.Budget;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

//import algo.alg;
import algo.budgetalgo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.UIManager;

//import com.mysql.jdbc.ResultSet;




//import msg_gui.update_failed_msgg;

import java.awt.Toolkit;
import java.awt.SystemColor;
/**
 * 
 * @author Naveed
 *
 */
public class budgetupdate1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public String id;

	/**
	 * Launch the application.
	 */public static String []ID=new String[100];
	//public reservation_gui frame;
	private JTextField textField;
	/**
	 * Create the dialog.
	 */
	public budgetupdate1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\pic\\bud.png"));
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setBounds(100, 100, 450, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Update Budget");
		JLabel lblStudentid = new JLabel("Enter ID");
		lblStudentid.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		lblStudentid.setBounds(135, 108, 76, 14);
		contentPanel.add(lblStudentid);
		

		

		textField = new JTextField();
		textField.setBounds(209, 104, 108, 23);
		contentPanel.add(textField);
		textField.setColumns(10);
		//alg a=new alg();
		//a.fun36(textField);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(320, 11, 46, 48);
		
		//Image imge=new ImageIcon (this.getClass().getResource("/1013.png")).getImage();
			//	label_1.setIcon(new ImageIcon(imge));
		contentPanel.add(label_1);
		
		JLabel lblPurchaseBudget = new JLabel("Purchase Budget");
		lblPurchaseBudget.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblPurchaseBudget.setBounds(135, 23, 412, 36);
		contentPanel.add(lblPurchaseBudget);
		
		{
			//Image img=new ImageIcon (this.getClass().getResource("/bb.jpg")).getImage();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						id=textField.getText();
						int i=0;
						algo.budgetalgo algosaaobj=new algo.budgetalgo();
						
						try {
							java.sql.ResultSet a;
							a=algosaaobj.select();
							while (a.next()) {
								
								ID[i]=a.getString("ID");
								
								i++;
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int checkit=0;
						for(int j=0;j<i;j++)
						{
						if(ID[j].equals(id))
						{
							System.out.println("id" +id);
							System.out.println("ID" +ID[0]);
							checkit=1;
							dispose();
							budgetupdate2 obj=new budgetupdate2(id);
							obj.setVisible(true);
							//dispose();
							break;
						}
					
						
						}
						//budgetupdate2 obj=new budgetupdate2(id);
						//obj.setVisible(true);
						//dispose();
						if(checkit==0)
						{
							
							gui.msg_gui.update_failed_msgg jj=new gui.msg_gui.update_failed_msgg ();
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
				cancelButton.setForeground(SystemColor.desktop);
				cancelButton.setBackground(UIManager.getColor("Button.disabledShadow"));
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
