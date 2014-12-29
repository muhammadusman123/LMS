package testcases;
import static org.junit.Assert.*;
import gui.Budget.Inset_Salary_budget;
import java.sql.SQLException;
import org.junit.Test;
import database.Salary_budget;
public class test_salary_algo {
	public static void main(String[] args) {
	}
	@Test
	public void Insert_frame() {
		int s;
		Inset_Salary_budget framea = new Inset_Salary_budget();
		Salary_budget budget = new Salary_budget();
		s = 1;
		String[] ID = new String[100];
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		algo.Salary_algo algosaaobj = new algo.Salary_algo();
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
		framea.amount = "1";
		framea.cur = "2";
		framea.id = "3";
		framea.sdate = "4/4/4";
		framea.spent = "5";
		framea.type = "fall";
		framea.yearr = "7";
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
