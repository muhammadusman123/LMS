package testcases;
import static org.junit.Assert.*;
import gui.Budget.budgetinsertion;
import java.sql.SQLException;
import org.junit.Test;
import database.Budget_database;
import database.Salary_budget;
public class test_budget_algo {
	public static void main(String[] args) {
	}
	@Test
	public void Insert_frame() {
		int s;
		budgetinsertion framea = new budgetinsertion();
		Budget_database budget = new Budget_database();
		s = 1;
		String[] ID = new String[100];
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		algo.budgetalgo algosaaobj = new algo.budgetalgo();
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
		framea.sdate = "2/2/2";
		framea.CS = "2";
		framea.EE = "3";
		framea.BBA = "4";
		framea.HR = "5";
		framea.year = "2154";
		framea.req = "7";
		framea.asp = "7";
		framea.issue = "7";
		framea.type = "fall";
		framea.equip = "7";
		framea.bill = "7";
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
