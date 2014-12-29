package testcases;
import static org.junit.Assert.*;
import gui.librarian_gui.Librarian_insert;
import java.sql.SQLException;
import org.junit.Test;
import database.Librarian_DB;
import database.Salary_budget;
public class test_librarian_algo {
	public static void main(String[] args) {
	}
	@Test
	public void Insert_frame() {
		int s;
		Librarian_insert framea = new Librarian_insert();
		Librarian_DB budget = new Librarian_DB();
		s = 1;
		String[] ID = new String[100];
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		algo.librarian_algo algosaaobj = new algo.librarian_algo();
		try {
			java.sql.ResultSet a;
			a = algosaaobj.select();
			while (a.next()) {
				// ID[i]=a.getString("ID");
				i++;
				count1++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(count1);
		framea.total = "2000";
		framea.year = "1234";
		framea.ReqA = "500";
		framea.type = "fall";
		budget.Insert_frame(s, framea);
		i = 0;
		// algo.Salary_algo algosaaobj=new algo.Salary_algo();
		try {
			java.sql.ResultSet a;
			a = algosaaobj.select();
			while (a.next()) {
				// ID[i]=a.getString("ID");
				i++;
				count2++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(count2);
		// count2++;
		assertEquals("when row is inserted ", true, check(count1, count2));
	}
	public boolean check(int count1, int count2) {
		if (count2 == (count1 + 1)) {
			return true;
		} else {
			return false;
		}
	}
}
