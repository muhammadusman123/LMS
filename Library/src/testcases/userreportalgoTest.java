package testcases;
import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import algo.userreportalgo;
public class userreportalgoTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testUpdate() {
		userreportalgo obj = new userreportalgo();
		boolean result = false;
		result = obj.Update(1234, "", 12345, "A", "12/9/2014");
		assertEquals("name field is empty", false, result);
	}
	@Test
	public void testDelete() throws SQLException {
		userreportalgo obj = new userreportalgo();
		boolean result = false;
		result = obj.Delete("14", "yousaf");
		assertEquals("id not found", false, result);
	}
	@Test
	public void testSearch() throws SQLException {
		userreportalgo obj = new userreportalgo();
		boolean result = false;
		result = obj.Search(25);
		assertEquals("id found", false, result);
	}
	@Test
	public void testSearch_name() throws SQLException {
		userreportalgo obj = new userreportalgo();
		boolean result = false;
		result = obj.Search_name(13, "usman");
		assertEquals("name mismatched", true, result);
	}
	@Test
	public void testIs_id_field_empty() throws SQLException {
		userreportalgo obj = new userreportalgo();
		boolean[] result = new boolean[3];
		;
		result = obj.is_id_field_empty("", result);
		assertEquals("name mismatched", true, result[0]);
	}
	@Test
	public void testIsInteger() {
		userreportalgo obj = new userreportalgo();
		boolean result = false;
		result = obj.isInteger("asd");
		assertEquals("name mismatched", false, result);
	}
}
