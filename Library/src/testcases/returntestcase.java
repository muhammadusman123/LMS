package testcases;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import database.returndb;
import algo.issuancealgo;
import algo.purchasealgo;
import algo.returnalgo;
public class returntestcase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void insertchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		returnalgo obj = new returnalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		issuancealgo obj1 = new issuancealgo();
		ResultSet rs1 = obj1.queryrep();
		String id = null;
		while (rs1.next()) {
			id = rs1.getString("issuanceid");
		}
		obj.querygen("01/01/2014", id, "500", "12345678", "15");
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
		returnalgo obj = new returnalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		issuancealgo obj1 = new issuancealgo();
		ResultSet rs1 = obj1.queryrep();
		String id = null;
		while (rs1.next()) {
			id = rs1.getString("issuanceid");
		}
		System.out.println(id + "usmaaaaaaaaaaaaaaaaan");
		obj.querygen("01/01/2014", id, "500", "12345678", "15");
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
		returnalgo obj = new returnalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
			id = rs.getString("returnid");
		}
		// obj.querygen("01/01/2014", "id", "500", "1", "15");
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
