package algo;

import java.sql.ResultSet;
import java.sql.SQLException;

//import budget_gui.Update_Salary_Budget;
import database.Librarian_DB;
import database.Salary_budget;
/**
 * 
 * @author Naveed
 *
 */
public class librarian_algo {
	/**
	 * 
	 * @param s
	 * @param framea
	 */
	
	public void Insert_frame(int s, gui.librarian_gui.Librarian_insert framea)
	{
		
		Librarian_DB budget=new Librarian_DB();
		budget.Insert_frame(s, framea);
		

	}
/**
 * 
 * @return
 * @throws SQLException
 */
	public ResultSet select() throws SQLException
	{

		Librarian_DB budget=new Librarian_DB();
		ResultSet rs=budget.select();

		
		return rs;


	}
/**
 * 
 * @return
 */
	public ResultSet selects()
	{
		
		Librarian_DB budget=new Librarian_DB();
		ResultSet rs=budget.selects();
		return rs;			


	}
/**
 * 
 * @param s
 * @param framea
 */
	public void Update(int s, gui.librarian_gui.librarianupdate framea)///////////change
	{
		
		
	

		Librarian_DB budget=new Librarian_DB();
		budget.Update(s, framea);
		
		
	}

/**
 * 
 * @param s
 * @return
 * @throws SQLException
 */
	public ResultSet querryupdatea(String s) throws SQLException
	{
		
		
		System.out.println("algo class");
		

		Librarian_DB budget=new Librarian_DB();
		ResultSet rs =budget.querryupdatea(s);
		return rs;
		
		
		
		
	}
	

}
