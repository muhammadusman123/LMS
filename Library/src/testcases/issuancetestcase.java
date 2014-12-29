package testcases;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import database.issuancedb;
import algo.issuancealgo;
import algo.purchasealgo;
import algo.studentalgo;
public class issuancetestcase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void insertchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		issuancealgo obj = new issuancealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter + "counter");
		studentalgo obj1 = new studentalgo();
		ResultSet rs1 = obj1.queryrep();
		String id = null;
		while (rs1.next()) {
			id = rs1.getString("studentid");
		}
		System.out.println(id + "student");
		obj.querygen("15", "12345678", "12345678", "01/02/2014");
		rs = obj.queryrep();
		while (rs.next()) {
			counterchecker++;
		}
		System.out.println(counterchecker + "checker");
		assertEquals("", counter + 1, counterchecker);
	}
	@Test
	public void returnchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		issuancealgo obj = new issuancealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter + "counter");
		studentalgo obj1 = new studentalgo();
		ResultSet rs1 = obj1.queryrep();
		String id = null;
		while (rs1.next()) {
			id = rs1.getString("studentid");
		}
		System.out.println(id + "student");
		obj.querygen("15", "12345678", "12345678", "01/02/2014");
		rs = obj.queryrep();
		while (rs.next()) {
			counterchecker++;
		}
		System.out.println(counterchecker + "checker");
		assertEquals("", counter + 1, counterchecker);
	}
	@Test
	public void deletechecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		String id = null;
		issuancealgo obj = new issuancealgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
			id = rs.getString("issuanceid");
		}
		System.out.println(counter);
		obj.querygen("6", "123456789", "01/01/2014", "01/01/2014");
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
