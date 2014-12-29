package algo;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import database.payroll_dbclass;
import database.resrvation_db;
import database.userreport_dbclass;

public class reservationautocomplete {

	public reservationautocomplete(JTextField txtInput, String decider)
			throws Exception {

		resrvation_db obj = new resrvation_db();
		ResultSet rs = obj.Report();
		ArrayList<String> items = new ArrayList<String>();
		if (decider.matches("reservationid")) {
			for (int i = 0; rs.next(); i++) {
				String item = rs.getString("reservationid");
				items.add(item);
			}
		} else if (decider.matches("name")) {
			for (int i = 0; rs.next(); i++) {
				String item = rs.getString("Book_name");
				items.add(item);
			}
		} else if (decider.matches("bookid")) {
			rs = obj.Report();
			for (int i = 0; rs.next(); i++) {
				String item = rs.getString("Book_id");
				items.add(item);
			}
		} else if (decider.matches("studentid")) {
			rs = obj.Report();
			for (int i = 0; rs.next(); i++) {
				String item = rs.getString("Student_id");
				items.add(item);

			}
		} else if (decider.matches("date")) {
			rs = obj.Report();
			for (int i = 0; rs.next(); i++) {
				String item = rs.getString("Reservation_Date");
				items.add(item);

			}
		}
		// JTextField txtInput = new JTextField();
		setupAutoComplete(txtInput, items);
		txtInput.setColumns(30);

	}

	private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}

	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}

	public static void setupAutoComplete(final JTextField txtInput,
			final ArrayList<String> items) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		setAdjusting(cbInput, false);
		for (String item : items) {
			model.addElement(item);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						txtInput.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						txtInput.setText(cbInput.getSelectedItem().toString());
						cbInput.setPopupVisible(false);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateList();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateList();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateList();
			}

			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				// cbInput.setPopupVisible(model.getSize() > 0);
				cbInput.hidePopup();
				cbInput.setPopupVisible(model.getSize() > 0);
				setAdjusting(cbInput, false);
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);
	}
}