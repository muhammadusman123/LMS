package testcases;

import static org.junit.Assert.*;
import gui.Discard_Book_gui.Insert_Discard;

import java.sql.SQLException;

import org.junit.Test;

import database.Budget_database;
import database.Discard_DB;
import database.Salary_budget;

public class test_discard_algo {
	public static void main(String[] args) {
	}

	@Test
	public void Insert_frame() throws Exception {
		int s;
		Insert_Discard framea = new Insert_Discard();
		Discard_DB budget = new Discard_DB();
		s = 1;
		String[] ID = new String[100];
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		algo.Discard_algo algosaaobj = new algo.Discard_algo();
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
		framea.Discard_datee = "2/2/2";
		framea.reason = "lost";
		framea.ID = "5";
		framea.ISBN = "2154";
		framea.copy = "7";
		framea.edit = "7";
		framea.name = "7";
		framea.book = "fall";
		framea.price = "7";
		framea.purchase_date = "2/2/2";
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
