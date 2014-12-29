package testcases;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import algo.purchasealgo;
public class purchase {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// insertchecker();
		// returnchecker();
	}
	@Test
	public void insertchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		purchasealgo obj = new purchasealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		obj.querygen("01/01/2014", "987654321", "Usman", "CN", " 6", "01",
				"CS", "1234567899");
		rs = obj.queryrep();
		while (rs.next()) {
			counterchecker++;
		}
		System.out.println(counterchecker);
		assertEquals("", counter + 1, counterchecker);
	}
	@Test
	public void returnchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		purchasealgo obj = new purchasealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		obj.querygen("01/01/2014", "987654321", "Usman", "CN", " 6", "01",
				"CS", "12345678");
		rs = obj.queryrep();
		while (rs.next()) {
			counterchecker++;
		}
		System.out.println(counterchecker);
		assertEquals("", counter + 1, counterchecker);
	}
	@Test
	public void deletechecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		String id = null;
		purchasealgo obj = new purchasealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
			id = rs.getString("Book_ID");
		}
		System.out.println(counter);
		obj.querygen("01/01/2014", "987654321", "Usman", "CN", " 6", "01",
				"CS", "12345678");
		int a = 0;
		id = String.valueOf(Integer.parseInt(id) + 1);
		System.out.println(id);
		obj.delete(id);
		rs = obj.queryrep();
		while (rs.next()) {
			counterchecker++;
		}
		System.out.println(counterchecker);
		assertEquals("", counter, counterchecker);
	}
}
