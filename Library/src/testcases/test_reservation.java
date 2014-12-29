package testcases;
import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
public class test_reservation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void testfun() throws SQLException {
		int a = 0;
		int b = 0;
		int result = 0;
		reservationalgo obj = new reservationalgo();
		ResultSet rs = null;
		// obj.Report();
		// rs=obj.Report();
		// while(rs.next())
		// {
		// }
		assertEquals("   ", null, rs);
		obj.Insert("5", "OOAD", 5, "01/01/2014");
		obj.Update(5, "anas", "ooad", 6, "01/01/2013");
	}
	@Test
	public void testfun1() throws SQLException {
		int a = 0;
		int b = 0;
		int result = 0;
		int counter = 0;
		int countchecker = 0;
		reservationalgo obj = new reservationalgo();
		ResultSet rs = null;
		// obj.Report();
		rs = obj.Report();
		while (rs.next()) {
			counter++;
		}
		obj.Insert("6", "OOAD", 5, "01/01/2014");
		rs = obj.Report();
		while (rs.next()) {
			countchecker++;
		}
		assertEquals("", counter + 1, countchecker);
	}
}
