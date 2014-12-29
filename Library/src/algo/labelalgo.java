package algo;
import java.sql.SQLException;
import javax.resource.cci.ResultSet;
import database.purchasedb;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class labelalgo {
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public int calculatelabel(String s) throws SQLException {
		purchasedb obj = new purchasedb();
		java.sql.ResultSet rs = obj.queryrep();
		int counter = 0;
		while (rs.next()) {
			if (rs.getString("Category").equals(s)) {
				counter++;
			}
		}
		return counter + 1;
	}
	/**
	 * 
	 * @param s
	 */
	public void printlabel(String s) {
		DirectPrint obj = new DirectPrint();
		obj.printing(s);
		// TODO Auto-generated method stub
	}
}
