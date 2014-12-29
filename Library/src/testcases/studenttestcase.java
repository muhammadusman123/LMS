package testcases;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import database.studentdb;
import algo.studentalgo;
public class studenttestcase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void insertchecker() throws SQLException {
		int counter = 0;
		int counterchecker = 0;
		studentalgo obj = new studentalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		obj.querygen("Usman", "8061gmail", "01/01/2014", "Male", "8788817",
				"01/01/2014");
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
		studentalgo obj = new studentalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
		}
		System.out.println(counter);
		obj.querygen("Usman", "8061gmail", "01/01/2014", "Male", "8788817",
				"01/01/2014");
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
		studentalgo obj = new studentalgo();
		ResultSet rs = obj.queryrep();
		while (rs.next()) {
			counter++;
			id = rs.getString("studentid");
		}
		System.out.println(counter);
		obj.querygen("Usman", "8061gmail", "01/01/2014", "Male", "8788817",
				"01/01/2014");
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
