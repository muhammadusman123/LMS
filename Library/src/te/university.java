package te;

import java.awt.Dimension;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import com.mysql.jdbc.Statement;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class university {

	Connection conn = null;

	public void initConnection() {

		String HOST = "jdbc:mysql://localhost:3306/lms";
		String USERNAME = "root";
		String PASSWORD = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void showReport(String s) throws SQLException {

		// Path to your .jasper file in your package
		String reportName = "te/University.jasper";

		// Get a stream to read the file
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream(reportName);

		try {
			Map parameters = new HashMap();

			parameters.put("Parameter3", "2");
			// parameters.put(, value)
			// parameters.put(, "Aziz");
			// parameters.
			String bookid = "6032";
			Statement st2 = (Statement) conn.createStatement();
			String queryString = s;
			ResultSet rset = null;
			rset = st2.executeQuery(queryString);
			JRResultSetDataSource jasperReports = new JRResultSetDataSource(
					rset);
			// Fill the report with parameter, connection and the stream reader
			JasperPrint jp = JasperFillManager.fillReport(is, null,
					jasperReports);

			// Viewer for JasperReport
			JRViewer jv = new JRViewer(jp);

			// Insert viewer to a JFrame to make it showable
			JFrame jf = new JFrame();
			jf.getContentPane().add(jv);
			jf.validate();
			jf.setVisible(true);
			jf.setSize(new Dimension(800, 600));
			jf.setLocation(300, 100);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {

		university ma = new university();
		ma.initConnection();
		ma.showReport("");
	}

}